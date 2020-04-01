package ru.relex.tastyfasty.db.model;

import ru.relex.commons.model.Role;

import java.security.Permission;
import java.util.Optional;

public enum  UserPermission {
    GET_USERS(1),
    CREATE_USERS(2),
    DELETE_USERS(3),
    UPDATE_USERS(4),

    ;
    private final int id;


    UserPermission(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String asString()
    {
        return "ROLE_"+this.id;
    }

    public static Optional<UserPermission> of(final Integer id) {
        if (id == null) {
            return Optional.empty();
        }
        for (var value: UserPermission.values()) {
            if (value.id == id) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }

}
