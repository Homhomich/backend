package ru.relex.commons.model;

import ru.relex.commons.model.Role;

public interface CurrentUser {

    int getId();

    String getUsername();

    Role getRole();

}
