package com.example.demo.facade.admin_facade.impl;

import com.example.demo.facade.admin_facade.UserManagementFacade;
import com.example.demo.model.admin.user_management.register_user.RegisterUserRequestBody;
import com.example.demo.model.admin.user_management.retrieve_user.RetrieveUsersRequestBody;
import com.example.demo.service.adminService.user_management.UserManagementService;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserManagementFacadeImpl implements UserManagementFacade {

    private final UserManagementService userManagementService;

    public UserManagementFacadeImpl(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @Override
    public ResponseEntity<?> facadeEntryForRegisterUser(RegisterUserRequestBody requestBody) {
        if (requestBody.getRoleId() == null)
            throw new ValidationException("Role Id : role id is required");

        return this.userManagementService.serviceEntryPointForRegisterUser( requestBody);
    }

    @Override
    public ResponseEntity<?> facadeEntryPointForRetrieveUsers(RetrieveUsersRequestBody requestBody) {
        // add validation if required.
        return this.userManagementService.serviceEntryPointForRetrieveUsers(requestBody);
    }
}
