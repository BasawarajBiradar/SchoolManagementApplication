package com.example.demo.model.admin.userManagement.retrieveUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetrieveUsersResultModel {
    private String userName;
    private String password;
    private String role;
    private String emailId;
    private String createdOn;
    private String createdBy;
    private String lastUpdatedOn;
    private String lastUpdatedBy;
    private String activeStatus;
}
