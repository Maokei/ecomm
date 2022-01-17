package se.maokei.ecomm.store.domain.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import se.maokei.ecomm.store.domain.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Role extends BaseEntity {
    @NotNull
    @Column(unique=true, nullable=false)
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();
}
