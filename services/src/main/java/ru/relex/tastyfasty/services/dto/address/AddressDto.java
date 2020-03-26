package ru.relex.tastyfasty.services.dto.address;

import lombok.Data;
import ru.relex.tastyfasty.services.constraint.ConstraintMessage;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AddressDto {
    private int id;

    @NotBlank(message = ConstraintMessage.Field.CITY + ConstraintMessage.Constraint.IS_EMPTY)
    @Size(max = 15, message = ConstraintMessage.Field.BREAKFAST_NAME + ConstraintMessage.Constraint.TOO_LONG)
    private String city;

    @NotBlank(message = ConstraintMessage.Field.STREET + ConstraintMessage.Constraint.IS_EMPTY)
    @Size(max = 15, message = ConstraintMessage.Field.BREAKFAST_NAME + ConstraintMessage.Constraint.TOO_LONG)
    private String street;

    @NotBlank(message = ConstraintMessage.Field.BUILDING + ConstraintMessage.Constraint.IS_EMPTY)
    @Size(max = 5, message = ConstraintMessage.Field.BREAKFAST_NAME + ConstraintMessage.Constraint.TOO_LONG)
    private int building;
}
