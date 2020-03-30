package ru.relex.tastyfasty.db.model;

import lombok.Data;

import java.time.Instant;

@Data
public class Restaurant {
    private int restaurant_id;
    private String tags;
    private int address;
    private String name;
    private int rating;
    private Instant open_time;
    private Instant close_time;

    public Instant getOpen_time() {
        return open_time;
    }

    public Instant getClose_time() {
        return close_time;
    }
}
