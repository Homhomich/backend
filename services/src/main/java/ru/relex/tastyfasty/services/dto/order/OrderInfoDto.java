package ru.relex.tastyfasty.services.dto.order;

import lombok.Data;
import ru.relex.tastyfasty.services.constraint.ConstraintMessage;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class OrderInfoDto {
    @NotBlank(message = ConstraintMessage.Field.ORDER_NAME + ConstraintMessage.Constraint.IS_EMPTY)
    @Size(max = 50, message = ConstraintMessage.Field.ORDER_NAME + ConstraintMessage.Constraint.TOO_LONG)
    private String name;

    @NotBlank(message = ConstraintMessage.Field.ORDER_TAG + ConstraintMessage.Constraint.IS_EMPTY)
    @Size(max = 20, message = ConstraintMessage.Field.ORDER_TAG + ConstraintMessage.Constraint.TOO_LONG)
    private String tag;
}
