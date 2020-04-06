package ru.relex.tastyfasty.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.relex.commons.model.CurrentUser;
import ru.relex.commons.model.Role;
import ru.relex.tastyfasty.db.model.UserPermission;
import ru.relex.tastyfasty.db.model.UserSecurityDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


public class UserDetailsImpl implements UserDetails, CurrentUser {

    private final UserSecurityDetails user;

    public UserDetailsImpl(UserSecurityDetails user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = user.getPermissions()
                .stream()
                .map(UserPermission::asString)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toUnmodifiableSet());
        System.err.println(authorities);
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword().strip(); // TODO: 06.04.2020 убрать strip
    }

    @Override
    public int getId() {
        return user.getId();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public Role getRole() {
        return user.getRole();
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
