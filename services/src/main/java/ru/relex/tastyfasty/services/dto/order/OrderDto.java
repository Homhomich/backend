package ru.relex.tastyfasty.services.dto.order;

import lombok.Data;
import ru.relex.commons.model.Status;
import ru.relex.tastyfasty.services.constraint.ConstraintMessage;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class OrderDto {

    private int orderID;

    @Valid
    @NotNull(message = ConstraintMessage.Field.ORDER_INFO + ConstraintMessage.Constraint.IS_NULL)
    private OrderInfoDto orderInfo;

    @NotNull(message = ConstraintMessage.Field.STATUS + ConstraintMessage.Constraint.IS_NULL)
    private Status status;

    private int restaurantID;
    private int customerID;
    private int deliverymanID;
}
