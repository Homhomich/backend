package ru.relex.tastyfasty.db.model;

import lombok.Data;
import ru.relex.commons.model.Role;

import java.sql.Blob;


@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private int address;
    private Role role;
    private String username;
    private String password;
    private Integer phoneNumber;
    private byte[] img;
}
