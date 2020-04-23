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
        path = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class HomePageController {

    private final IBreakfastService breakfastService;

    @Autowired
    public HomePageController(IBreakfastService breakfastService) {
        this.breakfastService = breakfastService;
    }

    @GetMapping
    List<BreakfastDto> getAllBreakfasts(@RequestParam(name = "search", required = false) String search) {
        return breakfastService.findBreakfasts(search);
    }
}
