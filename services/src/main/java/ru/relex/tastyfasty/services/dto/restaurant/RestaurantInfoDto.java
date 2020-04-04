package ru.relex.tastyfasty.services.dto.restaurant;

import lombok.Data;
import ru.relex.tastyfasty.services.constraint.ConstraintMessage;
import ru.relex.tastyfasty.services.dto.address.AddressDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.time.LocalTime;

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

    //@Size(max = 10, message = Field.RESTAURANT_TIME + Constraint.TOO_LONG)
    private int openTime;


   // @Size(max = 10, message = Field.RESTAURANT_TIME + Constraint.TOO_LONG)
    private int closeTime;

    private AddressDto address;

    private byte [] img;
}
