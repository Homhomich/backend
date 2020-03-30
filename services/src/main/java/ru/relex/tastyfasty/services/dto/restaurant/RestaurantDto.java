package ru.relex.tastyfasty.services.dto.restaurant;

import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static ru.relex.tastyfasty.services.constraint.ConstraintMessage.Constraint;
import static ru.relex.tastyfasty.services.constraint.ConstraintMessage.Field;

@Data
public class RestaurantDto {
    private int restaurantId;

    @Valid
    @NotNull(message = Field.RESTAURANT_INFO + Constraint.IS_NULL)
    private RestaurantInfoDto restaurantInfo;

    public RestaurantInfoDto getRestaurantInfo() {
        return restaurantInfo;
    }
}
