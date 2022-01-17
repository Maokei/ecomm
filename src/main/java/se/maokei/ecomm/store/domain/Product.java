package se.maokei.ecomm.store.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Product extends BaseEntity {
  @NotNull
  private String name;
}
