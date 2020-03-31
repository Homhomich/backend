package ru.relex.tastyfasty.services.service;

import ru.relex.tastyfasty.services.dto.basket.BasketDto;


import javax.validation.Valid;
import java.util.List;

public interface IBasketService {
    List<BasketDto> findBaskets(String search);

    BasketDto findBasketByUserId(int userID);

    BasketDto findBasketById(int basketID);

    BasketDto create(@Valid BasketDto basketDto);

    BasketDto update(@Valid BasketDto basketDto);

    void remove(int basketID);
}
