package ru.relex.tastyfasty.db.model;

import lombok.Data;
import ru.relex.commons.model.Status;

@Data
public class Order {
    private int id;
    private int restaurantID;
    private Status status;
    private String name;
    private String tag;
    private int customerID;
    private int deliverymanID;
    private Integer price;


}
