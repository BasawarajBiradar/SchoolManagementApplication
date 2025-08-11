package com.example.demo.facade.adminFacade.impl;

import com.example.demo.facade.adminFacade.UserManagementFacade;
import com.example.demo.model.admin.userManagement.retrieveUser.RegisterUserRequestBody;
import com.example.demo.service.adminService.userManagement.UserManagementService;
import org.springframework.http.HttpRequest;
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
}
