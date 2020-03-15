package ru.relex.tastyfasty.db.models;

import lombok.Data;

@Data
public class Breakfast {
    private int breakfast_id;
    private String name;
    private String tag;
    private double price;

    public void setId(int id) {
        this.breakfast_id = id;
    }
}
