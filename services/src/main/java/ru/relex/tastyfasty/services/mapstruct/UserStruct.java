package ru.relex.tastyfasty.services.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.relex.tastyfasty.db.model.User;
import ru.relex.tastyfasty.services.dto.user.UserDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserStruct {

    @Mapping(target = "personalInfoDto.firstName", source = "firstName")
    @Mapping(target = "personalInfoDto.lastName", source = "lastName")
    @Mapping(target = "personalInfoDto.middleName", source = "middleName")
    @Mapping(target = "personalInfoDto.address", source = "")  // TODO: 24.03.2020 how to find address by id
    UserDto toDto(User user);

    @Mapping(target = "firstName", source = "personalInfoDto.firstName")
    @Mapping(target = "lastName", source = "personalInfoDto.lastName")
    @Mapping(target = "middleName", source = "personalInfoDto.middleName")
    @Mapping(target = "address", source = "personalInfoDto.address.id")
    User fromDto(UserDto userDto);

    List<UserDto> toDto(List<User> user);

    List<User> fromDto(List<UserDto> userDto);
}
