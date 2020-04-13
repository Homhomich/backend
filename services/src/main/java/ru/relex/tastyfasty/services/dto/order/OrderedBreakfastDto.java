package ru.relex.tastyfasty.services.dto.order;

import lombok.Data;

@Data
public class OrderedBreakfastDto {
    private int orderBreakfastID;
    private int orderID;
    private int breakfastID;
}
