package se.maokei.ecomm.store.domain.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import se.maokei.ecomm.store.domain.BaseEntity;
import se.maokei.ecomm.store.domain.User;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="user_role")
public class UserRole extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }
}
