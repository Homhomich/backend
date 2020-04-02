package ru.relex.tastyfasty.db.model;

import lombok.Data;

@Data
public class Basket {
    private int basketID;
    private double fullPrice;
    private int numberOfPersons;
    private int userID;
}
