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
    @Size(max = 100, message = ConstraintMessage.Field.NUMBER_OF_PERSONS + ConstraintMessage.Constraint.TOO_LONG)
    private int numberOfPersons;
    private double fullPrice;

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    private int userID;

    public int getBasketID() {
        return basketID;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public int getUserID() {
        return userID;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }
}