package ru.relex.tastyfasty.services.dto.user;

import lombok.Data;
import ru.relex.tastyfasty.services.dto.address.AddressDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static ru.relex.tastyfasty.services.constraint.ConstraintMessage.Constraint;
import static ru.relex.tastyfasty.services.constraint.ConstraintMessage.Field;

@Data
public class PersonalInfoDto {

    @NotBlank(message = Field.FIRST_NAME + Constraint.IS_EMPTY)
    @Size(max = 50, message = Field.FIRST_NAME + Constraint.TOO_LONG)
    private String firstName;

    @NotBlank(message = Field.LAST_NAME + Constraint.IS_EMPTY)
    @Size(max = 50, message = Field.LAST_NAME + Constraint.TOO_LONG)
    private String lastName;

    @Size(max = 50, message = Field.MIDDLE_NAME + Constraint.TOO_LONG)
    private String middleName;
    private AddressDto address;
}
