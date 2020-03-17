package ru.relex.tastyfasty.db.model;

import lombok.Data;

import java.time.Instant;

@Data
public class Restaurant {
    private int restaurant_id;
    private String tags;
    private int address_id;
    private String name;
    private int rating;
    private Instant open_time;
    private Instant close_time;

}