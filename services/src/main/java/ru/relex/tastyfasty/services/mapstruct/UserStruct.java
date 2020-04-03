package ru.relex.tastyfasty.services.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.tastyfasty.db.model.User;
import ru.relex.tastyfasty.services.dto.address.AddressDto;
import ru.relex.tastyfasty.services.dto.user.UserDto;
import ru.relex.tastyfasty.services.service.IAddressService;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserStruct {

    @Autowired
    private IAddressService addressService;

    @Mapping(target = "personalInfo.firstName", source = "firstName")
    @Mapping(target = "personalInfo.lastName", source = "lastName")
    @Mapping(target = "personalInfo.middleName", source = "middleName")
    @Mapping(target = "personalInfo.address", source = "address")
    @Mapping(target = "personalInfo.phoneNumber", source = "phoneNumber")
    @Mapping(target = "personalInfo.img", source = "img")
    public abstract UserDto toDto(User user);

    @Mapping(target = "firstName", source = "personalInfo.firstName")
    @Mapping(target = "lastName", source = "personalInfo.lastName")
    @Mapping(target = "middleName", source = "personalInfo.middleName")
    @Mapping(target = "address", source = "personalInfo.address.id")
    @Mapping(target = "phoneNumber", source = "personalInfo.phoneNumber")
    @Mapping(target = "img", source = "personalInfo.img")
    public abstract User fromDto(UserDto userDto);

    public abstract List<UserDto> toDto(List<User> user);

    public abstract List<User> fromDto(List<UserDto> userDto);

    protected AddressDto AddressIdToAddressDto(int addressId) {
        return addressService.findAddressById(addressId);
    }
}
