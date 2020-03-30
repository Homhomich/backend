package ru.relex.tastyfasty.db.model;

import lombok.Data;

import java.time.Instant;
import java.time.LocalTime;

@Data
public class Restaurant {
    private int restaurantId;
    private String tags;
    private int address;
    private String name;
    private int rating;
    private LocalTime openTime;
    private LocalTime closeTime;
}
