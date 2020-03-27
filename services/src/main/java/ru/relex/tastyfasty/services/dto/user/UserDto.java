package ru.relex.tastyfasty.services.dto.user;

import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import ru.relex.commons.model.Role;

import static ru.relex.tastyfasty.services.constraint.ConstraintMessage.Constraint;
import static ru.relex.tastyfasty.services.constraint.ConstraintMessage.Field;


@Data
public class UserDto {
    private Integer id;

    @NotBlank(message = Field.USERNAME + Constraint.IS_EMPTY)
    private String username;

    @Size(min = 8, message = Field.PASSWORD + Constraint.TOO_SHORT)
    private String password;

    @NotNull(message = Field.ROLE + Constraint.IS_NULL)
    private Role role;

    @Valid
    @NotNull(message = Field.PERSONAL_INFO + Constraint.IS_NULL)
    private PersonalInfoDto personalInfoDto;

    public void setId(Integer id) {
        this.id = id;
    }
}
