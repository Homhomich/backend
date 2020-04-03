package ru.relex.tastyfasty.services.service;

import ru.relex.tastyfasty.services.dto.user.UserDto;

import javax.validation.Valid;
import java.util.List;

public interface IUserService {

    List<UserDto> findUsers(String search);

    UserDto findUserById(int userId);

    UserDto create(@Valid UserDto userDto);

    UserDto update(@Valid UserDto userDto);

    void remove(int userId);
}
