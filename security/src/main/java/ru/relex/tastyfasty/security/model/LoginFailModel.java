package ru.relex.tastyfasty.security.model;

import ru.relex.commons.model.CurrentUser;
import ru.relex.commons.model.LoggingModelInfo;
import ru.relex.commons.model.Role;

public class LoginFailModel implements CurrentUser {
     private boolean authenticated;
     private LoggingModelInfo info;

    public LoginFailModel() {
        this.authenticated = false;
        this.info = new LoggingModelInfo(-1, "fail", Role.ADMIN);
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public LoggingModelInfo getInfo() {
        return info;
    }
}
