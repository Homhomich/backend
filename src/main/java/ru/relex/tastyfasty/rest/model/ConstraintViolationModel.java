package ru.relex.tastyfasty.rest.model;

import lombok.Data;

@Data
public class ConstraintViolationModel {
    private String error;

    public ConstraintViolationModel(String error) {
        this.error = error;
    }

}
