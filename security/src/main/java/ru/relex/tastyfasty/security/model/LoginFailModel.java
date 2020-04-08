package ru.relex.tastyfasty.security.model;

import ru.relex.commons.model.CurrentUser;
import ru.relex.commons.model.LoggingModelInfo;

public class LoginFailModel implements CurrentUser {
     private boolean authenticated;
     private LoggingModelInfo info;

    public boolean isAuthenticated() {
        return authenticated;
    }

    public LoggingModelInfo getInfo() {
        return info;
    }

    public LoginFailModel() {
        this.authenticated = false;
        this.info = null;
    }
}
