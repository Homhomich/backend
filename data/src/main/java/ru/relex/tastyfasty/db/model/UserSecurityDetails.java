package ru.relex.tastyfasty.db.model;

import lombok.Data;
import ru.relex.commons.model.Role;

import java.util.Set;

@Data
public class UserSecurityDetails {
    private int id;
    private String username;
    private Role role;
    private String password;
    private Set<UserPermission> permissions;
}
