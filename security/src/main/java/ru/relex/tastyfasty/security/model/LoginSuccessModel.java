package ru.relex.tastyfasty.security.model;

import lombok.Data;
import ru.relex.commons.model.CurrentUser;
import ru.relex.commons.model.LoggingModelInfo;
import ru.relex.commons.model.Role;

@Data
public class LoginSuccessModel implements CurrentUser {

    private boolean authenticated;
    private LoggingModelInfo info;

    public LoginSuccessModel(CurrentUser info) {
        authenticated = true;
        this.info = info.getInfo();
    }

    @Override
    public LoggingModelInfo getInfo() {
        return info;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }
}
