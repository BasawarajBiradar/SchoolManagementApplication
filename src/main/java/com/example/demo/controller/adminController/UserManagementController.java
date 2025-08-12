package com.example.demo.controller.adminController;

import com.example.demo.facade.adminFacade.UserManagementFacade;
import com.example.demo.model.admin.userManagement.registerUser.RegisterUserRequestBody;
import com.example.demo.model.admin.userManagement.retrieveUser.RetrieveUsersRequestBody;
import com.example.demo.utils.response.ResponseHandler;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/user-management")
public class UserManagementController {

    private final UserManagementFacade userManagementFacade;

    public UserManagementController(UserManagementFacade userManagementFacade) {
        this.userManagementFacade = userManagementFacade;
    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/register")
    private ResponseEntity<?> registerUser(@Valid @RequestBody RegisterUserRequestBody requestBody) {
        return this.userManagementFacade.facadeEntryForRegisterUser( requestBody);
    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/get-users")
    private ResponseEntity<?> retrieveUsers(@RequestBody RetrieveUsersRequestBody requestBody) {
        return this.userManagementFacade.facadeEntryPointForRetrieveUsers(requestBody);
    }

}
