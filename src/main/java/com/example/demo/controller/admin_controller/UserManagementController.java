package com.example.demo.controller.admin_controller;

import com.example.demo.facade.admin_facade.UserManagementFacade;
import com.example.demo.model.admin.user_management.register_user.RegisterUserRequestBody;
import com.example.demo.model.admin.user_management.retrieve_user.RetrieveUsersRequestBody;
import com.example.demo.model.admin.user_management.retrieve_user.RetrieveUsersResultModel;
import com.example.demo.utils.response.ApiResponse;
import com.example.demo.utils.response.ResponseHandler;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> registerUser(@Valid @RequestBody RegisterUserRequestBody requestBody) {
        return ResponseHandler.success(this.userManagementFacade.facadeEntryForRegisterUser( requestBody), "Success", "200");
    }

    @PreAuthorize("hasAuthority('USER_MANAGEMENT_READ')")
    @PostMapping("/get-users")
    public ResponseEntity<ApiResponse<List<RetrieveUsersResultModel>>> retrieveUsers(@RequestBody RetrieveUsersRequestBody requestBody) {
        return ResponseHandler.success(this.userManagementFacade.facadeEntryPointForRetrieveUsers(requestBody), "Success", "200");
    }

}
