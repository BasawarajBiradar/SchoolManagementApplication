package com.example.demo.service.adminService.userManagement;

import com.example.demo.model.admin.userManagement.registerUser.RegisterUserRequestBody;
import com.example.demo.model.admin.userManagement.retrieveUser.RetrieveUsersRequestBody;
import org.springframework.http.ResponseEntity;

public interface UserManagementService {

    ResponseEntity<?> serviceEntryPointForRegisterUser(RegisterUserRequestBody requestBody);

    ResponseEntity<?> serviceEntryPointForRetrieveUsers(RetrieveUsersRequestBody requestBody);
}

