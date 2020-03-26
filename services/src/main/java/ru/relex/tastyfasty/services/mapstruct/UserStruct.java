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

    @Named("fromId")
    protected AddressDto fromId(User user) {
        return addressService.findAddressById(user.getAddress());
    }

    @Mapping(target = "personalInfoDto.firstName", source = "firstName")
    @Mapping(target = "personalInfoDto.lastName", source = "lastName")
    @Mapping(target = "personalInfoDto.middleName", source = "middleName")
    @Mapping(target = "personalInfoDto.address", qualifiedByName = "fromId")
    public abstract UserDto toDto(User user);

    @Mapping(target = "firstName", source = "personalInfoDto.firstName")
    @Mapping(target = "lastName", source = "personalInfoDto.lastName")
    @Mapping(target = "middleName", source = "personalInfoDto.middleName")
    @Mapping(target = "address", source = "personalInfoDto.address.id")
    public abstract User fromDto(UserDto userDto);

    public abstract List<UserDto> toDto(List<User> user);

    public abstract List<User> fromDto(List<UserDto> userDto);
}
