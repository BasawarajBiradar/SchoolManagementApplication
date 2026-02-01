package com.example.demo.controller.admin_controller;

import com.example.demo.facade.admin_facade.UserManagementFacade;
import com.example.demo.model.admin.user_management.register_user.RegisterUserRequestBody;
import com.example.demo.model.admin.user_management.retrieve_user.RetrieveUsersRequestBody;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user-management")
public class UserManagementController {

    private final UserManagementFacade userManagementFacade;

    public UserManagementController(UserManagementFacade userManagementFacade) {
        this.userManagementFacade = userManagementFacade;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterUserRequestBody requestBody) {
        return this.userManagementFacade.facadeEntryForRegisterUser( requestBody);
    }

    @PreAuthorize("hasAuthority('USER_MANAGEMENT_READ')")
    @PostMapping("/get-users")
    public ResponseEntity<?> retrieveUsers(@RequestBody RetrieveUsersRequestBody requestBody) {
        return this.userManagementFacade.facadeEntryPointForRetrieveUsers(requestBody);
    }

}
