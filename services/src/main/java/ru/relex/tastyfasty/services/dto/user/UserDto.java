package ru.relex.tastyfasty.services.dto.user;

import lombok.Data;
import ru.relex.commons.model.Role;

@Data
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private Role role;
    private PersonalInfoDto personalInfoDto;
}
