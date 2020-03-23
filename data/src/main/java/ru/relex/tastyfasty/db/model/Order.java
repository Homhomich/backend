package ru.relex.tastyfasty.db.model;

import lombok.Data;

@Data
public class Order {
    private int orderID;
    private int restaurantID;
    private String name;
    private String tag;
    private int customerID;
    private int deliverymanID;
}
