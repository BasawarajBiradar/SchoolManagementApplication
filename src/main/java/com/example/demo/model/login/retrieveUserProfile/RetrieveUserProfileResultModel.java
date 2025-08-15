package com.example.demo.model.login.retrieveUserProfile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetrieveUserProfileResultModel {
    private String userId;
    private String firstName;
    private String lastName;
    private Integer roleId;
    private String role;
    private String emailId;
}
