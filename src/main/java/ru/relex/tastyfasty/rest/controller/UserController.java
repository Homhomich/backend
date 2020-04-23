package ru.relex.tastyfasty.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.tastyfasty.services.dto.user.UserDto;
import ru.relex.tastyfasty.services.service.IUserService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(
        path = "/api/users",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(final IUserService userService) {
        this.userService = userService;
    }


    @GetMapping
    @RolesAllowed({"ROLE_GET_USERS"})
    List<UserDto> getUsers(@RequestParam(name = "search", required = false) String search) {
        return userService.findUsers(search);
    }

    @GetMapping("/{id}")
    @RolesAllowed("ROLE_GET_USERS")
    UserDto findById(@PathVariable("id") int id) {
        return userService.findUserById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed("ROLE_CREATE_USERS")
    UserDto create(@RequestBody UserDto userDto) {
        System.out.println(userDto.toString());
        System.out.println("create");
        return userService.create(userDto);
    }

    @PutMapping("/{id}")
    @RolesAllowed("ROLE_UPDATE_USERS")
    UserDto update(@PathVariable("id") int id, @RequestBody UserDto userDto) {
        userDto.setId(id);
        userService.update(userDto);
        return findById(id);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("ROLE_DELETE_USERS")
    void remove(@PathVariable("id") int id) {
        userService.remove(id);
    }
}
