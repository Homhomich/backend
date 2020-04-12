package ru.relex.tastyfasty.db.model;

import lombok.Data;

@Data
public class OrderedBreakfast {
    private int orderBreakfastID;
    private int orderID;
    private int breakfastID;
}
