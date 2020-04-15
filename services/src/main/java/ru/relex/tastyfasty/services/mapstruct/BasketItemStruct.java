package ru.relex.tastyfasty.services.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.tastyfasty.db.model.BasketItem;
import ru.relex.tastyfasty.services.dto.basket.BasketItemDto;
import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;
import ru.relex.tastyfasty.services.service.IBreakfastService;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class BasketItemStruct {

    @Autowired
    private IBreakfastService breakfastService;

    @Mapping(target = "breakfast", source = "breakfastID")
    public abstract BasketItemDto toDto(BasketItem basketItem);

    @Mapping(target = "breakfastID", source = "breakfast")
    public abstract BasketItem fromDto(BasketItemDto basketItemDto);

    public abstract List<BasketItemDto> toDto(List<BasketItem> basketItems);

    public abstract List<BasketItem> fromDto(List<BasketItemDto> basketItemDtos);

    protected BreakfastDto breakfastIdToDto(int id) {
        return breakfastService.findBreakfastById(id);
    }

    protected int breakfastDtoToId(BreakfastDto breakfastDto) {
        return breakfastDto.getId();
    }
}
