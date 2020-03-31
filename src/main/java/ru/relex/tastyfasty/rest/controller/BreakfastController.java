package ru.relex.tastyfasty.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.tastyfasty.services.dto.breakfast.BreakfastDto;
import ru.relex.tastyfasty.services.service.IBreakfastService;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(
        path = "/restaurants/{restaurantId}/breakfasts",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class BreakfastController {

    private final IBreakfastService breakfastService;

    @Autowired
    public BreakfastController(final IBreakfastService breakfastService) {
        this.breakfastService = breakfastService;
    }


    @GetMapping
    List<BreakfastDto> getBreakfastByRestaurantId(@PathVariable("restaurantId") int restaurantId) {
        return breakfastService.findBreakfastsByRestaurantId(restaurantId);
    }

    @GetMapping("/{id}")
    BreakfastDto getBreakfastById(@PathVariable("id") int id) {
        return breakfastService.findBreakfastById(id);
    }

    @GetMapping("/{tag}")
    List<BreakfastDto> getBreakfastByTag(
            @PathVariable("restaurantId") int restaurantId,
            @RequestParam(value = "tag") String tag
    ) {
        return breakfastService.findBreakfastsByTag(tag, restaurantId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    BreakfastDto create(@RequestBody BreakfastDto breakfastDto, @PathVariable("restaurantId") int restaurantId) {
        breakfastDto.setRestaurantId(restaurantId);
        return breakfastService.create(breakfastDto);
    }

    @PutMapping("/{id}")
    BreakfastDto update(
            @PathVariable("id") int id,
            @PathVariable("restaurantId") int restaurantId,
            @RequestBody BreakfastDto breakfastDto
    ) {
        breakfastDto.setId(id);
        breakfastDto.setRestaurantId(restaurantId);
        breakfastService.update(breakfastDto);
        return getBreakfastById(id);
    }

    @DeleteMapping("/{id}")
    void remove(@PathVariable("id") int id) {
        breakfastService.remove(id);
    }
}
