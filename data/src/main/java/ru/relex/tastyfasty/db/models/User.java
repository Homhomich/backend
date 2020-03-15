package ru.relex.tastyfasty.db.models;

import lombok.Data;

@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private int role;
    private String username;
    private String password;

    public void setId(int id) {
        this.id = id;
    }
}
