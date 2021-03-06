package ru.relex.tastyfasty.db.model;

import java.util.Optional;

public enum  UserPermission {
    GET_USERS(1),
    CREATE_USERS(2),
    DELETE_USERS(3),
    UPDATE_USERS(4),
    GET_ORDERS(5),
    CREATE_ORDERS(6),
    DELETE_ORDERS(7),
    UPDATE_ORDERS(8),
    ;

    private final int id;


    UserPermission(int id) {
        this.id=id;
    }

    public String asString()
    {
        return "ROLE_" + this.name();
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

    public int getId() {
        return id;
    }
}
