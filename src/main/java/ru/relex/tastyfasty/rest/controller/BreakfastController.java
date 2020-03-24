package ru.relex.tastyfasty.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.tastyfasty.db.mapper.BreakfastMapper;
import ru.relex.tastyfasty.db.model.Breakfast;

import java.util.List;

@RestController
@RequestMapping(
        path = "/breakfasts",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class BreakfastController {

    private final BreakfastMapper breakfastMapper;

    @Autowired
    public BreakfastController(final BreakfastMapper breakfastMapper) {
        this.breakfastMapper = breakfastMapper;
    }


    @GetMapping
    List<Breakfast> getBreakfasts(@RequestParam(name = "search", required = false) String search) {
        return breakfastMapper.getBreakfasts(search);
    }

    @GetMapping("/{id}")
    Breakfast getBreakfastById(@PathVariable("breakfastID") int id) {
        return breakfastMapper.findById(id);
    }

    @PutMapping("/{id}")
    Breakfast update(@PathVariable("breakfastID") int id, @RequestBody Breakfast breakfast) {
        breakfast.setBreakfastID(id);
        breakfastMapper.update(breakfast);
        return getBreakfastById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Breakfast create(@RequestBody Breakfast breakfast) {
        breakfastMapper.insert(breakfast);
        return breakfast;
    }
}
