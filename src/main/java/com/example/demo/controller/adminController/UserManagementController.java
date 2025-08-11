package com.example.demo.controller.adminController;

import com.example.demo.facade.adminFacade.UserManagementFacade;
import com.example.demo.model.admin.userManagement.registerUser.RegisterUserRequestBody;
import com.example.demo.model.admin.userManagement.retrieveUser.RetrieveUsersRequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/user-management")
public class UserManagementController {

    private final UserManagementFacade userManagementFacade;

    public UserManagementController(UserManagementFacade userManagementFacade) {
        this.userManagementFacade = userManagementFacade;
    }

    @PostMapping("/register")
    private ResponseEntity<?> registerUser(@RequestBody RegisterUserRequestBody requestBody) {
        return this.userManagementFacade.facadeEntryForRegisterUser( requestBody);
    }

    @PostMapping("/get-users")
    private ResponseEntity<?> retrieveUsers(@RequestBody RetrieveUsersRequestBody requestBody) {
        return this.userManagementFacade.facadeEntryPointForRetrieveUsers(requestBody);
    }

}
