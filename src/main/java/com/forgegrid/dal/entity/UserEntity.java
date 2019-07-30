package com.forgegrid.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String login;
    @Column(unique = true)
    private String email;
    private String password;
    private Role role;
    private int money;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<ProductEntity> purchases;

    public enum Role {
        ADMIN,
        DEVELOPER,
        USER,
        ANONYMOUS
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(Role.USER.name()));
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void alterLogin(@NotEmpty @Nullable String newLogin) {
        if (newLogin != null) {
            this.login = newLogin;
        }
    }

    public void alterEmail(@NotEmpty @Nullable String newEmail) {
        if (newEmail != null) {
            this.email = newEmail;
        }
    }

    public void alterPassword(@NotEmpty @Nullable String newPassword) {
        if (newPassword != null) {
            this.password = newPassword;
        }
    }
}
