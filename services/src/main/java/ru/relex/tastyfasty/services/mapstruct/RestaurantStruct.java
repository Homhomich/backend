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

    @Named("fromId")
    protected AddressDto fromId(Restaurant restaurant) {
        return addressService.findAddressById(restaurant.getAddress());
    }

    @Named("toIntOpenTime")
    protected int toIntOpenTime(Restaurant restaurant) {
        return restaurant.getOpen_time().getHour();
    }

    @Named("toIntCloseTime")
    protected int toIntCloseTime(Restaurant restaurant) {
        return restaurant.getClose_time().getHour();
    }

    @Named("toLocalTimeOpen")
    protected LocalTime toLocalTimeOpen(RestaurantDto restaurantDto) {
        LocalTime localTime = LocalTime.MIDNIGHT;
        localTime = localTime.plusHours(restaurantDto.getRestaurantInfo().getOpen_time());
        return localTime;
    }

    @Named("toLocalTimeClose")
    protected LocalTime toLocalTimeClose(RestaurantDto restaurantDto) {
        LocalTime localTime = LocalTime.MIDNIGHT;
        localTime = localTime.plusHours(restaurantDto.getRestaurantInfo().getClose_time());
        return localTime;
    }


    @Mapping(target = "restaurantInfo.tags", source = "tags")
    @Mapping(target = "restaurantInfo.name", source = "name")
    @Mapping(target = "restaurantInfo.rating", source = "rating")
    @Mapping(target = "restaurantInfo.open_time", qualifiedByName = "toIntOpenTime")
    @Mapping(target = "restaurantInfo.close_time", qualifiedByName = "toIntCloseTime")
    @Mapping(target = "restaurantInfo.address", source = "address")
    public abstract RestaurantDto toDto(Restaurant restaurant);

    @Mapping(target = "tags", source = "restaurantInfo.tags")
    @Mapping(target = "name", source = "restaurantInfo.name")
    @Mapping(target = "rating", source = "restaurantInfo.rating")
    @Mapping(target = "open_time", qualifiedByName = "toLocalTimeOpen")
    @Mapping(target = "close_time", qualifiedByName = "toLocalTimeClose")
    @Mapping(target = "address", source = "restaurantInfo.address.id")
    public abstract Restaurant fromDto(RestaurantDto RestaurantDto);

    public abstract List<RestaurantDto> toDto(List<Restaurant> restaurants);

    public abstract List<Restaurant> fromDto(List<RestaurantDto> restaurantDto);

    public AddressDto AddressIdToAddressDto(int addressId) {
        System.out.println("fromId");
        return addressService.findAddressById(addressId);
    }
}
