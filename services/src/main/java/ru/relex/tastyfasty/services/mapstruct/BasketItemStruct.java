package ru.relex.tastyfasty.services.mapstruct;

import org.mapstruct.Mapper;
import ru.relex.tastyfasty.db.model.BasketItem;
import ru.relex.tastyfasty.services.dto.basket.BasketItemDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BasketItemStruct {

    BasketItemDto toDto(BasketItem basketItem);

    BasketItem fromDto(BasketItemDto basketItemDto);

    List<BasketItemDto> toDto(List<BasketItem> basketItems);

    List<BasketItem> fromDto(List<BasketItemDto> basketItemDtos);
}
