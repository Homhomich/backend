package ru.relex.tastyfasty.services.dto.address;

import lombok.Data;

@Data
public class AddressDto {
    private int id;
    private String city;
    private String street;
    private int building;
}
