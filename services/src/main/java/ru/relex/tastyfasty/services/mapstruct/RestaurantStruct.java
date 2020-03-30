package ru.relex.tastyfasty.services.mapstruct;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.tastyfasty.db.model.Restaurant;
import ru.relex.tastyfasty.db.model.User;
import ru.relex.tastyfasty.services.dto.address.AddressDto;
import ru.relex.tastyfasty.services.dto.restaurant.RestaurantDto;
import ru.relex.tastyfasty.services.service.IAddressService;

import java.time.Instant;
import java.time.LocalTime;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RestaurantStruct {

    @Autowired
    private IAddressService addressService;

    @Mapping(target = "restaurantInfo.tags", source = "tags")
    @Mapping(target = "restaurantInfo.name", source = "name")
    @Mapping(target = "restaurantInfo.rating", source = "rating")
    @Mapping(target = "restaurantInfo.openTime", source = "openTime")
    @Mapping(target = "restaurantInfo.closeTime", source = "closeTime")
    @Mapping(target = "restaurantInfo.address", source = "address")
    public abstract RestaurantDto toDto(Restaurant restaurant);

    @Mapping(target = "tags", source = "restaurantInfo.tags")
    @Mapping(target = "name", source = "restaurantInfo.name")
    @Mapping(target = "rating", source = "restaurantInfo.rating")
    @Mapping(target = "openTime", source = "restaurantInfo.openTime")
    @Mapping(target = "closeTime", source = "restaurantInfo.closeTime")
    @Mapping(target = "address", source = "restaurantInfo.address.id")
    public abstract Restaurant fromDto(RestaurantDto RestaurantDto);

    public abstract List<RestaurantDto> toDto(List<Restaurant> restaurants);

    public abstract List<Restaurant> fromDto(List<RestaurantDto> restaurantDto);

    protected AddressDto AddressIdToAddressDto(int addressId) {
        return addressService.findAddressById(addressId);
    }

    protected int LocalTimeToInt(LocalTime time) {
        return time.getHour();
    }

    protected LocalTime IntToLocalTime(int time) {
        LocalTime localTime = LocalTime.MIDNIGHT;
        localTime = localTime.plusHours(time);
        return localTime;
    }

}
