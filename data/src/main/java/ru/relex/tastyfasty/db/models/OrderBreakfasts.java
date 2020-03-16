package ru.relex.tastyfasty.db.models;

public class OrderBreakfasts {
    private int orderBreakfastID;
    private int orderID;
    private int breakfastID;

    public OrderBreakfasts(int orderBreakfastID) {
        this.orderBreakfastID = orderBreakfastID;
    }
}
