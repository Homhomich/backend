package ru.relex.tastyfasty.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.tastyfasty.db.mapper.OrderBreakfastsMapper;
import ru.relex.tastyfasty.db.model.BreakfastsInBasket;
import ru.relex.tastyfasty.db.model.OrderBreakfasts;
import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;
import ru.relex.tastyfasty.services.mapstruct.BreakfastStruct;
import ru.relex.tastyfasty.services.service.IOrderFillingService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class OrderFillingServiceImpl implements IOrderFillingService {

    private final BreakfastStruct breakfastStruct;
    private final OrderBreakfastsMapper orderBreakfastsMapper;

    @Autowired
    public OrderFillingServiceImpl(BreakfastStruct breakfastStruct, OrderBreakfastsMapper orderBreakfastsMapper) {
        this.breakfastStruct = breakfastStruct;
        this.orderBreakfastsMapper = orderBreakfastsMapper;
    }


    @Override
    public List<BreakfastDto> getBreakfastsInOrder(int orderId) {
        var breakfasts = orderBreakfastsMapper.findByOrderId(orderId);
        return breakfastStruct.toDto(breakfasts);
    }

    @Override
    public BreakfastDto addBreakfastToOrder(int orderId, @Valid BreakfastDto breakfastDto) {
        OrderBreakfasts orderBreakfasts = new OrderBreakfasts();
        orderBreakfasts.setBreakfastID(breakfastDto.getId());
        orderBreakfasts.setOrderID(orderId);
        orderBreakfastsMapper.insert(orderBreakfasts);
        return breakfastDto;
    }

    @Override
    public BreakfastDto updateBreakfastInOrder(int orderId, @Valid BreakfastDto breakfastDto) {
        OrderBreakfasts orderBreakfasts = new OrderBreakfasts();
        orderBreakfasts.setBreakfastID(breakfastDto.getId());
        orderBreakfasts.setOrderID(orderId);
        orderBreakfastsMapper.update(orderBreakfasts);
        return breakfastDto;
    }

    @Override
    public void removeBreakfastsByOrderId(int orderId) {
        orderBreakfastsMapper.deleteByOrderId(orderId);
    }

    @Override
    public void removeBreakfastFromOrder(int orderId, int breakfastId) {
        orderBreakfastsMapper.deleteBreakfastFromOrder(orderId, breakfastId);
    }
}
