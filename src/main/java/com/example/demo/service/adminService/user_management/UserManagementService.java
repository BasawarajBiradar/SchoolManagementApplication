package com.example.demo.service.adminService.user_management;

import com.example.demo.model.admin.user_management.register_user.RegisterUserRequestBody;
import com.example.demo.model.admin.user_management.retrieve_user.RetrieveUsersRequestBody;
import org.springframework.http.ResponseEntity;

public interface UserManagementService {

    ResponseEntity<?> serviceEntryPointForRegisterUser(RegisterUserRequestBody requestBody);

    ResponseEntity<?> serviceEntryPointForRetrieveUsers(RetrieveUsersRequestBody requestBody);
}

