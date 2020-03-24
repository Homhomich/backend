package ru.relex.tastyfasty.db.model;

import lombok.Data;

@Data
public class Address {
    private int id;
    private String city;
    private String street;
    private int building;
}
