package ru.relex.tastyfasty.services.dto.user;

import lombok.Data;
import ru.relex.tastyfasty.db.model.Address;

@Data
public class PersonalInfoDto {
    private String firstName;
    private String lastName;
    private String middleName;
    private Address address;
}
