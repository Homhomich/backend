package ru.relex.tastyfasty.services.dto.basket;

import lombok.Data;
import ru.relex.tastyfasty.services.constraint.ConstraintMessage;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BasketDto {

    private int basketID;

    @NotNull(message = ConstraintMessage.Field.NUMBER_OF_PERSONS + ConstraintMessage.Constraint.IS_NULL)
    @Min(message = ConstraintMessage.Field.NUMBER_OF_PERSONS + ConstraintMessage.Constraint.LESS_THAN_ONE, value = 1)
//    @Size(max = 100, message = ConstraintMessage.Field.NUMBER_OF_PERSONS + ConstraintMessage.Constraint.TOO_LONG)
    private int numberOfPersons;

    private double fullPrice;

    private int userID;
}