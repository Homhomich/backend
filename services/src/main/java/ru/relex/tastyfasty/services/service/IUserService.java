package ru.relex.tastyfasty.services.service;

import ru.relex.tastyfasty.services.dto.user.UserDto;

import java.util.List;

public interface IUserService {

    List<UserDto> findUsers(String search);

    UserDto create(UserDto userDto);

    UserDto update(UserDto userDto);

    void remove(int userId);
}
