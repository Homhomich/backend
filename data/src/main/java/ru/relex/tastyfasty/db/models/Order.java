package ru.relex.tastyfasty.db.models;

import lombok.Data;

@Data
public class Order {
    private int orderID;
    private String name;
    private String tag;
    private int customerID;
    private int deliverymanID;

    public Order(int orderID) {
        this.orderID = orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
