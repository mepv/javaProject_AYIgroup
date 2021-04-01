package com.ayigroup.mepv.security.auth;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@SequenceGenerator(name = "APP_USER_SEQ")
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_USER_SEQ")
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String userNickName;

    @Column(name = "password")
    private String password;

    @Column(name = "account_expired")
    private Boolean accountNonExpired;

    @Column(name = "account_locked")
    private Boolean accountNonLocked;

    @Column(name = "credential_expired")
    private Boolean credentialsNonExpired;

    @Column(name = "enable")
    private Boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private AppUserRole appUserRole;

    @Column(name = "permission")
    @ElementCollection(targetClass = SimpleGrantedAuthority.class, fetch = FetchType.EAGER)
    private Set<? extends GrantedAuthority> grantedAuthorities;

    public AppUser(Set<? extends GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
        this.accountNonExpired = isAccountNonExpired();
        this.accountNonLocked = isAccountNonLocked();
        this.credentialsNonExpired = isCredentialsNonExpired();
        this.enabled = isEnabled();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userNickName;
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
}
