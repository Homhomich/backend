package ru.relex.tastyfasty.db.model;

import lombok.Data;
import ru.relex.commons.model.Role;

import java.security.Permission;
import java.util.List;

@Data
public class UserSecurityDetails {
    private int id;
    private String username;
    private Role role;
    private String password;
    private List<UserPermission> permissions;
}
