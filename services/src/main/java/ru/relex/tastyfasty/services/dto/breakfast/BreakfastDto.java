package ru.relex.tastyfasty.services.dto.breakfast;

import lombok.Data;

@Data
public class BreakfastDto {
    private int breakfastID;
    private String name;
    private String tag;
    private double price;
    private int restaurantID;
}
