package ru.relex.commons.model;

import java.util.Optional;

public enum Status {
    STARTED_MAKING(1),
    WAITING_FOR_DELIVERYMAN(2),
    TO_RESTAURANT(3),
    GET_THE_ORDER(4),
    ON_THE_WAY_TO_CUSTOMER(5),
    WAITING_FOR_CUSTOMER(6),
    READY(7),
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
