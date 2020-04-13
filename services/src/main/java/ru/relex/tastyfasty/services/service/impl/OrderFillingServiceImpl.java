package ru.relex.tastyfasty.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.tastyfasty.db.mapper.OrderedBreakfastMapper;
import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;
import ru.relex.tastyfasty.services.dto.order.OrderedBreakfastDto;
import ru.relex.tastyfasty.services.mapstruct.BreakfastStruct;
import ru.relex.tastyfasty.services.mapstruct.OrderedBreakfastStruct;
import ru.relex.tastyfasty.services.service.IOrderFillingService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class OrderFillingServiceImpl implements IOrderFillingService {

    private final OrderedBreakfastStruct orderedBreakfastStruct;
    private final BreakfastStruct breakfastStruct;
    private final OrderedBreakfastMapper orderedBreakfastMapper;

    @Autowired
    public OrderFillingServiceImpl(
            OrderedBreakfastStruct orderedBreakfastStruct,
            BreakfastStruct breakfastStruct,
            OrderedBreakfastMapper orderedBreakfastMapper
    ) {
        this.orderedBreakfastStruct = orderedBreakfastStruct;
        this.breakfastStruct = breakfastStruct;
        this.orderedBreakfastMapper = orderedBreakfastMapper;
    }


    @Override
    public List<BreakfastDto> getBreakfastsInOrder(int orderId) {
        var breakfasts = orderedBreakfastMapper.findByOrderId(orderId);
        return breakfastStruct.toDto(breakfasts);
    }

    @Override
    public OrderedBreakfastDto addBreakfastToOrder(@Valid OrderedBreakfastDto orderedBreakfastDto) {
        orderedBreakfastMapper.insert(orderedBreakfastStruct.fromDto(orderedBreakfastDto));
        return orderedBreakfastDto;
    }

    @Override
    public OrderedBreakfastDto updateBreakfastInOrder(@Valid OrderedBreakfastDto orderedBreakfastDto) {
        orderedBreakfastMapper.update(orderedBreakfastStruct.fromDto(orderedBreakfastDto));
        return orderedBreakfastDto;
    }

    @Override
    public void removeBreakfastsByOrderId(int orderId) {
        orderedBreakfastMapper.deleteByOrderId(orderId);
    }

    @Override
    public void removeBreakfastFromOrder(int orderId, int breakfastId) {
        orderedBreakfastMapper.deleteBreakfastFromOrder(orderId, breakfastId);
    }
}
