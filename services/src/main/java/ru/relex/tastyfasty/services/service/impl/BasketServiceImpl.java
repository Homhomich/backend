package ru.relex.tastyfasty.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.tastyfasty.db.mapper.BasketMapper;


import ru.relex.tastyfasty.services.dto.basket.BasketDto;

import ru.relex.tastyfasty.services.mapstruct.BasketStruct;

import ru.relex.tastyfasty.services.service.IBasketService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class BasketServiceImpl  implements IBasketService {

    private final BasketMapper basketMapper;
    private final BasketStruct basketStruct;

    @Autowired
    public BasketServiceImpl(final BasketMapper basketMapper, final BasketStruct basketStruct) {
        this.basketMapper = basketMapper;
        this.basketStruct = basketStruct;
    }


    /*@Override
    public List<BasketDto> findBaskets(final String search) {
        var baskets = basketMapper.getBaskets(search);
        return basketStruct.toDto(baskets);
    }*/

    @Override
    public List<BasketDto> findBasketByUserId(final int userID) {
        var baskets = basketMapper.findByUserId(userID);
        return basketStruct.toDto(baskets);
    }

    @Override
    public BasketDto findBasketById(final int basketID) {
        var basket = basketMapper.findByBasketId(basketID);
        return basketStruct.toDto(basket);
    }

    @Override
    public BasketDto create(@Valid final BasketDto basketDto) {
        var basket = basketStruct.fromDto(basketDto);
        basketMapper.update(basket);
        return basketStruct.toDto(basket);
    }

    @Override
    public BasketDto update(@Valid BasketDto basketDto) {
        var basket = basketStruct.fromDto(basketDto);
        basketMapper.update(basket);
        return basketStruct.toDto(basket);
    }

    @Override
    public void removeByBasketId(int basketID) {
        basketMapper.deleteByBasketId(basketID);
    }

    @Override
    public void removeByUserId(int userId) {
        basketMapper.deleteByBasketId(userId);
    }

}
