FROM adoptopenjdk/maven-openjdk11 AS build
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
WORKDIR /opt/build
COPY pom.xml .
# go-offline using the pom.xml
RUN mvn dependency:go-offline
# copy your other files
COPY ./src ./src
# compile the source code and package it in a jar file
RUN mvn clean install -Dmaven.test.skip=true

FROM adoptopenjdk/openjdk11:jre-11.0.14_9-alpine
EXPOSE 8080
WORKDIR /opt/app
# copy over the built artifact from the maven image
COPY --from=build /opt/build/target/ecomm-store-0.0.1-SNAPSHOT.jar /opt/app/app.jar
CMD ["java", "-jar", "app.jar"]