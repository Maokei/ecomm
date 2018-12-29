package se.maokei.ecomm.store.domain.security;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int roleId;
}
