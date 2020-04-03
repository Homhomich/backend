package ru.relex.tastyfasty.security.model;

import java.util.Collection;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.relex.commons.model.CurrentUser;
import ru.relex.commons.model.Role;
import ru.relex.tastyfasty.db.model.UserSecurityDetails;


public class UserDetailsImpl implements UserDetails, CurrentUser {

    private final UserSecurityDetails user;

    public UserDetailsImpl(UserSecurityDetails user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
                /*return user.getPermissions()
                        .stream()
                        .map(UserPermission::asString)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toUnmodifiableSet());
            */
        return Set.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
    }

    @Override
    public String getPassword() {
        return user.getPassword().strip();
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
