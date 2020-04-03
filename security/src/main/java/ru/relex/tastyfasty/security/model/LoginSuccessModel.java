package ru.relex.tastyfasty.security.model;

import lombok.Data;
import ru.relex.commons.model.CurrentUser;
import ru.relex.commons.model.Role;

@Data
public class LoginSuccessModel implements CurrentUser {

    private int id;
    private String username;
    private Role role;

    public LoginSuccessModel(CurrentUser info) {
        this.id = info.getId();
        this.username = info.getUsername();
        this.role = info.getRole();
    }

}
