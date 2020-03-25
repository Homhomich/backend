package ru.relex.tastyfasty.services.mapstruct;

import org.mapstruct.Mapper;
import ru.relex.tastyfasty.db.model.Breakfast;
import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BreakfastStruct {

    BreakfastDto toDto(Breakfast breakfast);

    Breakfast fromDto(BreakfastDto breakfastDto);

    List<BreakfastDto> toDto(List<Breakfast> breakfasts);

    List<Breakfast> fromDto(List<BreakfastDto> breakfastDtos);
}
