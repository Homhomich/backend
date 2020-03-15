package ru.relex.tastyfasty.db.models;

import lombok.Data;

@Data
public class Order {
    private int order_id;
    private String name;
    private String tag;
    private int customer_id;
    private int deliveryman_id;
}
