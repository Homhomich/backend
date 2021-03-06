package ru.relex.tastyfasty.rest.handler;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ru.relex.tastyfasty.rest.model.ConstraintViolationModel;


@ControllerAdvice
public class TastyFastyExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<ConstraintViolationModel>> handleConstraintViolation(ConstraintViolationException exception) {
        var violations = exception.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .map(ConstraintViolationModel::new)
                .collect(Collectors.toList());

        return new ResponseEntity<>(violations, HttpStatus.BAD_REQUEST);
    }

}
