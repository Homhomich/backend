package ru.relex.tastyfasty.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.tastyfasty.db.mapper.UserMapper;
import ru.relex.tastyfasty.services.dto.user.UserDto;
import ru.relex.tastyfasty.services.mapstruct.UserStruct;
import ru.relex.tastyfasty.services.service.IAddressService;
import ru.relex.tastyfasty.services.service.IUserService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class UserServiceImpl implements IUserService {

    private final UserMapper userMapper;
    private final UserStruct userStruct;

    private final IAddressService addressService;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserStruct userStruct, IAddressService addressService) {
        this.userMapper = userMapper;
        this.userStruct = userStruct;
        this.addressService = addressService;
    }


    @Override
    public List<UserDto> findUsers(final String search) {
        var users = userMapper.getUsers(search);
        return userStruct.toDto(users);
    }

    @Override
    public UserDto findUserById(int userId) {
        var user = userMapper.findById(userId);
        return userStruct.toDto(user);
    }

    @Override
    public UserDto create(@Valid final UserDto userDto) {
        var addressDto = addressService.create(userDto.getPersonalInfo().getAddress());
        var user = userStruct.fromDto(userDto);
        user.setAddress(addressDto.getId());
        userMapper.insert(user);
        return userStruct.toDto(user);
    }

    @Override
    public UserDto update(@Valid final UserDto userDto) {
        int addressId = userMapper.findById(userDto.getId()).getAddress();
        userDto.getPersonalInfo().getAddress().setId(addressId);
        var user = userStruct.fromDto(userDto);
        userMapper.update(user);
        return userStruct.toDto(user);
    }

    @Override
    public void remove(final int userId) {
        userMapper.delete(userId);
    }
}
