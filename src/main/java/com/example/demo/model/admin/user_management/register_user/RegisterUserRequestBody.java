package com.example.demo.model.admin.user_management.register_user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequestBody {
    @NotBlank(message = "Username is required")
    @Size(min = 4, max = 20, message = "Username must be 4 to 20 characters")
    private String userName;
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;
    @NotBlank(message = "Email id is required")
    private String emailId;
    @NotBlank(message = "First Name is required")
    private String firstName;
    @NotBlank(message = "Last Name is required")
    private String lastName;
    private Integer roleId;
}
