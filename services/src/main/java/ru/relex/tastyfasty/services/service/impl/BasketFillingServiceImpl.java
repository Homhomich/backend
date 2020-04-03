package ru.relex.tastyfasty.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.tastyfasty.db.mapper.BreakfastsInBasketMapper;
import ru.relex.tastyfasty.db.model.BreakfastsInBasket;
import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;
import ru.relex.tastyfasty.services.mapstruct.BreakfastStruct;
import ru.relex.tastyfasty.services.service.IBasketFillingService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class BasketFillingServiceImpl implements IBasketFillingService {

    private final BreakfastStruct breakfastStruct;
    private final BreakfastsInBasketMapper breakfastsInBasketMapper;

    @Autowired
    public BasketFillingServiceImpl(BreakfastStruct breakfastStruct, BreakfastsInBasketMapper breakfastsInBasketMapper) {
        this.breakfastStruct = breakfastStruct;
        this.breakfastsInBasketMapper = breakfastsInBasketMapper;
    }


    @Override
    public List<BreakfastDto> getBreakfastsInUserBasket(int basketId) {
        var breakfasts = breakfastsInBasketMapper.findByBasketId(basketId);
        return breakfastStruct.toDto(breakfasts);
    }

    @Override
    public BreakfastDto addBreakfastToBasket(int basketId, @Valid BreakfastDto breakfastDto) {
        BreakfastsInBasket breakfastsInBasket = new BreakfastsInBasket();
        breakfastsInBasket.setBreakfastID(breakfastDto.getId());
        breakfastsInBasket.setBasketID(basketId);
        breakfastsInBasketMapper.insert(breakfastsInBasket);
        return breakfastDto;
    }

    @Override
    public BreakfastDto updateBreakfastInBasket(int basketId, @Valid BreakfastDto breakfastDto) {
        BreakfastsInBasket breakfastsInBasket = new BreakfastsInBasket();
        breakfastsInBasket.setBreakfastID(breakfastDto.getId());
        breakfastsInBasket.setBasketID(basketId);
        breakfastsInBasketMapper.update(breakfastsInBasket);
        return breakfastDto;
    }

    @Override
    public void removeBreakfastsFromBasket(int basketId) {
        breakfastsInBasketMapper.deleteBreakfastsByBasketId(basketId);
    }

    @Override
    public void removeOneBreakfastFromBasket(int basketId, int breakfastId) {
        breakfastsInBasketMapper.deleteOneBreakfastByBasketId(basketId, breakfastId);
    }
}
