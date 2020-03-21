package ru.relex.tastyfasty.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.tastyfasty.db.mapper.UserMapper;
import ru.relex.tastyfasty.services.dto.user.UserDto;
import ru.relex.tastyfasty.services.mapstruct.UserStruct;
import ru.relex.tastyfasty.services.service.IUserService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class UserServiceImpl implements IUserService {
    private final UserMapper userMapper;
    private final UserStruct userStruct;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserStruct userStruct) {
        this.userMapper = userMapper;
        this.userStruct = userStruct;
    }

    @Override
    public List<UserDto> findUsers(final String search) {
        var users = userMapper.getUsers(search);
        return userStruct.toDto(users);
    }

    @Override
    public UserDto create(@Valid final UserDto userDto) {
        var user = userStruct.fromDto(userDto);
        userMapper.insert(user);
        return userStruct.toDto(user);
    }

    @Override
    public UserDto update(@Valid final UserDto userDto) {
        var user = userStruct.fromDto(userDto);
        userMapper.update(user);
        return userStruct.toDto(user);
    }

    @Override
    public void remove(final int userId) {

    }
}
