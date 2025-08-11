package com.example.demo.facade.adminFacade.impl;

import com.example.demo.facade.adminFacade.UserManagementFacade;
import com.example.demo.model.admin.userManagement.registerUser.RegisterUserRequestBody;
import com.example.demo.model.admin.userManagement.retrieveUser.RetrieveUsersRequestBody;
import com.example.demo.service.adminService.userManagement.UserManagementService;
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
        // add validation
        return this.userManagementService.serviceEntryPointForRegisterUser( requestBody);
    }

    @Override
    public ResponseEntity<?> facadeEntryPointForRetrieveUsers(RetrieveUsersRequestBody requestBody) {
        // add validation if required.
        return this.userManagementService.serviceEntryPointForRetrieveUsers(requestBody);
    }
}
