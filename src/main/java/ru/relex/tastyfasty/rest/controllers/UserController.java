package ru.relex.tastyfasty.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.tastyfasty.db.mappers.UserMapper;
import ru.relex.tastyfasty.db.models.User;
import ru.relex.tastyfasty.rest.model.Value;

import java.util.List;

@RestController
@RequestMapping(
        path = "/users",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class UserController {

    private final UserMapper userMapper;

    @Autowired
    public UserController(final UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @GetMapping
    List<User> getUsers(@RequestParam(name = "search", required = false) String search) {
        return userMapper.getUsers(search);
    }

    @GetMapping("/{id}")
    User findById(@PathVariable("id") int id) {
        return userMapper.findById(id);
    }

    @PutMapping("/{id}")
    User update(@PathVariable("id") int id, @RequestBody User user) {
        user.setId(id);
        userMapper.update(user);
        return findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    User create(@RequestBody User user) {
        userMapper.insert(user);
        return user;


    }
}
