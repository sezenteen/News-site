package com.example.amaraa.model.Dtos;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private String username;
    private String password;
    private Set<String> roles;
    private String level;
    private String firstName;
    private String lastName;
    private int age;
}
