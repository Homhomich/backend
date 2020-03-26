package ru.relex.tastyfasty.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.tastyfasty.db.mapper.BreakfastMapper;
import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;
import ru.relex.tastyfasty.services.mapstruct.BreakfastStruct;
import ru.relex.tastyfasty.services.service.IBreakfastService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class BreakfastServiceImpl implements IBreakfastService {

    private final BreakfastMapper breakfastMapper;
    private final BreakfastStruct breakfastStruct;

    @Autowired
    public BreakfastServiceImpl(BreakfastMapper breakfastMapper, BreakfastStruct breakfastStruct) {
        this.breakfastMapper = breakfastMapper;
        this.breakfastStruct = breakfastStruct;
    }


    @Override
    public List<BreakfastDto> findBreakfasts(String search) {
        var breakfasts = breakfastMapper.getBreakfasts(search);
        return breakfastStruct.toDto(breakfasts);
    }

    @Override
    public List<BreakfastDto> findBreakfastsByTag(String search) {
        var breakfasts = breakfastMapper.findByTag(search);
        return breakfastStruct.toDto(breakfasts);
    }

    @Override
    public List<BreakfastDto> findBreakfastsByName(String search) {
        var breakfasts = breakfastMapper.findByName(search);
        return breakfastStruct.toDto(breakfasts);
    }

    @Override
    public List<BreakfastDto> findBreakfastsByRestaurantId(int restaurantId) {
        var breakfasts = breakfastMapper.findByRestaurantID(restaurantId);
        return breakfastStruct.toDto(breakfasts);
    }

    @Override
    public BreakfastDto findBreakfastById(int breakfastId) {
        var breakfast = breakfastMapper.findById(breakfastId);
        return breakfastStruct.toDto(breakfast);
    }

    @Override
    public BreakfastDto create(@Valid BreakfastDto breakfastDto) {
        var breakfast = breakfastStruct.fromDto(breakfastDto);
        breakfastMapper.insert(breakfast);
        return breakfastStruct.toDto(breakfast);
    }

    @Override
    public BreakfastDto update(@Valid BreakfastDto breakfastDto) {
        var breakfast = breakfastStruct.fromDto(breakfastDto);
        breakfastMapper.update(breakfast);
        return breakfastStruct.toDto(breakfast);
    }

    @Override
    public void remove(int breakfastId) {
        breakfastMapper.delete(breakfastId);
    }
}
