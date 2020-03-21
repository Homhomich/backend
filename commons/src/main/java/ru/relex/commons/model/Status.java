package ru.relex.commons.model;

import java.util.Optional;

public enum Status {

    TO_RESTAURANT(1),

    GET_THE_ORDER(2),

    ON_THE_WAY_TO_CUSTOMER(3),

    WAITING_FOR_CUSTOMER(4),

    READY(5)
    ;

    private final int id;

    Status(int id) {
        this.id = id;
    }

    public static Optional<Status> of(final Integer id) {
        if (id == null) {
            return Optional.empty();
        }
        for (var value : Status.values()) {
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
