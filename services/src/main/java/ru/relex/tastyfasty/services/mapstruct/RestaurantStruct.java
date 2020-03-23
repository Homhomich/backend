package ru.relex.tastyfasty.services.mapstruct;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.relex.tastyfasty.db.model.Restaurant;
import ru.relex.tastyfasty.services.dto.restaurant.RestaurantDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantStruct {

    @Mapping(target = "restaurantInfo.tags", source = "tags")
    @Mapping(target = "restaurantInfo.name", source = "name")
    @Mapping(target = "restaurantInfo.rating", source = "rating")
    @Mapping(target = "restaurantInfo.open_time", source = "open_time")
    @Mapping(target = "restaurantInfo.close_time", source = "close_time")
    RestaurantDto toDto(Restaurant restaurant);

    @Mapping(target = "tags", source = "restaurantInfo.tags")
    @Mapping(target = "name", source = "restaurantInfo.name")
    @Mapping(target = "rating", source = "restaurantInfo.rating")
    @Mapping(target = "open_time", source = "restaurantInfo.open_time")
    @Mapping(target = "close_time", source = "restaurantInfo.close_time")
    Restaurant fromDto(RestaurantDto RestaurantDto);

    List<RestaurantDto> toDto(List<Restaurant> restaurants);

    List<Restaurant> fromDto(List<RestaurantDto> restaurantDto);
}
