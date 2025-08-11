package com.example.demo.service.adminService.userManagement;

import com.example.demo.model.admin.userManagement.retrieveUser.RegisterUserRequestBody;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;

public interface UserManagementService {

    ResponseEntity<?> serviceEntryPointForRegisterUser(RegisterUserRequestBody requestBody);
}

