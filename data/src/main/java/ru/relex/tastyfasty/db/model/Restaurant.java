package ru.relex.tastyfasty.db.model;

import lombok.Data;

import java.time.Instant;
import java.time.LocalTime;

@Data
public class Restaurant {
    private int restaurant_id;
    private String tags;
    private int address;
    private String name;
    private int rating;
    private LocalTime open_time;
    private LocalTime close_time;

    public LocalTime getOpen_time() {
        return open_time;
    }

    public LocalTime getClose_time() {
        return close_time;
    }

    public int getAddress() {
        return address;
    }
}
