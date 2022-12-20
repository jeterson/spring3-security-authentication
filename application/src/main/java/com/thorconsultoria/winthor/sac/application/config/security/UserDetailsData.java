package com.thorconsultoria.winthor.sac.application.config.security;

import com.thorconsultoria.winthor.sac.application.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class UserDetailsData implements UserDetails {

    private Optional<User> user;
    private Integer id;

    public UserDetailsData(User user) {
        this.user = Optional.ofNullable(user);
    }

    public UserDetailsData() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  new ArrayList<>();
    }

    public Integer getId() {
        return user.orElse(new User()).getId();
    }

    @Override
    public String getPassword() {
        return user.orElse(new User()).getPassword();
    }

    @Override
    public String getUsername() {
        return user.orElse(new User()).getUsername();
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
