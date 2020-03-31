package ru.relex.tastyfasty.services.mapstruct;

import org.mapstruct.Mapper;
import ru.relex.tastyfasty.db.model.Basket;
import ru.relex.tastyfasty.services.dto.basket.BasketDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BasketStruct {

    BasketDto toDto(Basket basket);

    Basket fromDto(BasketDto basketDto);

    List<BasketDto> toDto(List<Basket> baskets);

    List<Basket> fromDto(List<BasketDto> basketDtos);
}
