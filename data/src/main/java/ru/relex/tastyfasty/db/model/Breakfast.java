package ru.relex.tastyfasty.db.model;

import lombok.Data;

@Data
public class  Breakfast {
    private int breakfastID;
    private String name;
    private String tag;
    private double price;
    private int restaurantID;
}
