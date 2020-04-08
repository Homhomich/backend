package ru.relex.commons.model;

import ru.relex.commons.model.Role;

public class LoggingModelInfo {
    private int id;
    private String username;
    private Role role;

    public LoggingModelInfo(int id, String username, Role role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }
}
