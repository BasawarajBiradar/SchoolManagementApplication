package com.example.demo.model.admin.userManagement.registerUser;

import lombok.Data;

@Data
public class RegisterUserRequestBody {

    private String userName;
    private String password;
    private String emailId;
    private String firstName;
    private String lastName;
    private Integer roleId;
}
