package ru.relex.tastyfasty.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(
        path = "/basket/{basketId}/",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class BasketFillingController {
}
