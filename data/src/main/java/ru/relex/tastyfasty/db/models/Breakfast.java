package ru.relex.tastyfasty.db.models;

import lombok.Data;

@Data
public class Breakfast {
    private int breakfastID;
    private String name;
    private String tag;
    private double price;

    public void setId(int id) {
        this.breakfastID = id;
    }
}
