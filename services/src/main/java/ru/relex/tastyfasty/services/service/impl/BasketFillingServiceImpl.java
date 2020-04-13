package ru.relex.tastyfasty.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.tastyfasty.db.mapper.BasketItemMapper;
import ru.relex.tastyfasty.db.model.BasketItem;
import ru.relex.tastyfasty.services.dto.basket.BasketItemDto;
import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;
import ru.relex.tastyfasty.services.mapstruct.BasketItemStruct;
import ru.relex.tastyfasty.services.mapstruct.BreakfastStruct;
import ru.relex.tastyfasty.services.service.IBasketFillingService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class BasketFillingServiceImpl implements IBasketFillingService {

    private final BreakfastStruct breakfastStruct;
    private final BasketItemStruct basketItemStruct;
    private final BasketItemMapper basketItemMapper;

    @Autowired
    public BasketFillingServiceImpl(BreakfastStruct breakfastStruct, BasketItemStruct basketItemStruct, BasketItemMapper basketItemMapper) {
        this.breakfastStruct = breakfastStruct;
        this.basketItemStruct = basketItemStruct;
        this.basketItemMapper = basketItemMapper;
    }


    @Override
    public List<BreakfastDto> getBreakfastsInUserBasket(int basketId) {
        var breakfasts = basketItemMapper.findBreakfastsByBasketId(basketId);
        return breakfastStruct.toDto(breakfasts);
    }

    @Override
    public List<BasketItemDto> getBasketItemsInUserBasket(int basketId) {
        var basketItems = basketItemMapper.findBasketItemsByBasketId(basketId);
        return basketItemStruct.toDto(basketItems);
    }

    @Override
    public BasketItemDto addBreakfastToBasket(@Valid BasketItemDto basketItemDto) {
        basketItemMapper.insert(basketItemStruct.fromDto(basketItemDto));
        return basketItemDto;
    }

    @Override
    public BasketItemDto updateBreakfastInBasket(@Valid BasketItemDto basketItemDto) {
        basketItemMapper.update(basketItemStruct.fromDto(basketItemDto));
        return basketItemDto;
    }

    @Override
    public void removeBreakfastsFromBasket(int basketId) {
        basketItemMapper.deleteBreakfastsByBasketId(basketId);
    }

    @Override
    public void removeOneBreakfastFromBasket(int basketId, int breakfastId) {
        basketItemMapper.deleteOneBreakfastByBasketId(basketId, breakfastId);
    }
}
