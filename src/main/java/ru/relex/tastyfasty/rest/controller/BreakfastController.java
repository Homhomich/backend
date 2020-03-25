package ru.relex.tastyfasty.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;
import ru.relex.tastyfasty.services.service.IBreakfastService;

import java.util.List;

@RestController
@RequestMapping(
        path = "/breakfasts",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class BreakfastController {

    private final IBreakfastService breakfastService;

    @Autowired
    public BreakfastController(final IBreakfastService breakfastService) {
        this.breakfastService = breakfastService;
    }


    @GetMapping
    List<BreakfastDto> getBreakfasts(@RequestParam(name = "search", required = false) String search) {
        return breakfastService.findBreakfasts(search);
    }

    @GetMapping("/{tag}")
    List<BreakfastDto> getBreakfastByTag(@PathVariable("tag") String tag) {
        return breakfastService.findBreakfastsByTag(tag);
    }

    @GetMapping("/{id}")
    BreakfastDto getBreakfastById(@PathVariable("breakfastID") int id) {
        return breakfastService.findBreakfastById(id);
    }

    @PutMapping("/{id}")
    BreakfastDto update(@PathVariable("breakfastID") int id, @RequestBody BreakfastDto breakfastDto) {
        breakfastDto.setBreakfastID(id);
        breakfastService.update(breakfastDto);
        return getBreakfastById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    BreakfastDto create(@RequestBody BreakfastDto breakfastDto) {
        breakfastService.create(breakfastDto);
        return breakfastDto;
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("breakfastID") int id) {
        breakfastService.remove(id);
    }
}
