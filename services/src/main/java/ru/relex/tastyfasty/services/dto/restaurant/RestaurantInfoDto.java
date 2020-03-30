package ru.relex.tastyfasty.services.dto.restaurant;

import lombok.Data;
import ru.relex.tastyfasty.services.constraint.ConstraintMessage;
import ru.relex.tastyfasty.services.dto.address.AddressDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

import static ru.relex.tastyfasty.services.constraint.ConstraintMessage.Constraint;
import static ru.relex.tastyfasty.services.constraint.ConstraintMessage.Field;

@Data
public class RestaurantInfoDto {


    @NotBlank(message = Field.RESTAURANT_TAGS + Constraint.IS_EMPTY)
    @Size(max = 100, message = Field.RESTAURANT_TAGS + Constraint.TOO_LONG)
    private String tags;

    @NotBlank(message = Field.RESTAURANT_NAME + Constraint.IS_EMPTY)
    @Size(max = 50, message = Field.RESTAURANT_NAME + Constraint.TOO_LONG)
    private String name;

    //не уверена что здесь в принципе нужна валидация
    private int rating;

    @NotBlank(message = Field.RESTAURANT_TIME+ Constraint.IS_EMPTY)
    @Size(max = 10, message = Field.RESTAURANT_TIME + Constraint.TOO_LONG)
    private Instant open_time;

    @NotBlank(message = Field.RESTAURANT_TIME+ Constraint.IS_EMPTY)
    @Size(max = 10, message = Field.RESTAURANT_TIME + Constraint.TOO_LONG)
    private Instant close_time;

    private AddressDto address;

}
