package ru.relex.tastyfasty.services.dto.breakfast;

import lombok.Data;
import ru.relex.tastyfasty.services.constraint.ConstraintMessage;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class BreakfastDto {

    private int id;

    @NotBlank(message = ConstraintMessage.Field.BREAKFAST_NAME + ConstraintMessage.Constraint.IS_EMPTY)
    @Size(max = 30, message = ConstraintMessage.Field.BREAKFAST_NAME + ConstraintMessage.Constraint.TOO_LONG)
    private String name;

    @NotBlank(message = ConstraintMessage.Field.BREAKFAST_TAG + ConstraintMessage.Constraint.IS_EMPTY)
    @Size(max = 20, message = ConstraintMessage.Field.BREAKFAST_TAG + ConstraintMessage.Constraint.TOO_LONG)
    private String tag;

    //@NotBlank(message = ConstraintMessage.Field.PRICE + ConstraintMessage.Constraint.IS_EMPTY)
    private double price;

    private int restaurantId;

    private byte[] img;
}
