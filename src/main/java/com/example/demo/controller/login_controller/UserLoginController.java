package com.example.demo.controller.login_controller;

import com.example.demo.facade.login.UserLoginFacade;
import com.example.demo.model.login.LoginRequestRequestModel;
import com.example.demo.model.login.retrieve_user_profile.RetrieveUserProfileRequestRequestModel;
import com.example.demo.model.login.retrieve_user_profile.RetrieveUserProfileResultModel;
import com.example.demo.utils.response.ApiResponse;
import com.example.demo.utils.response.ResponseHandler;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserLoginController {

    private final UserLoginFacade userLoginFacade;

    public UserLoginController(UserLoginFacade userLoginFacade) {
        this.userLoginFacade = userLoginFacade;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Map<String, String>>> login(@RequestBody LoginRequestRequestModel request) {
        return ResponseHandler.success(this.userLoginFacade.facadeEntryPointForLogin(request), "Success", "200");
    }

    @PostMapping("/retrieve/user-profile")
    public ResponseEntity<ApiResponse<RetrieveUserProfileResultModel>> retrieveUserProfileData(HttpServletRequest request, @RequestBody RetrieveUserProfileRequestRequestModel requestModel) {
        return ResponseHandler.success(this.userLoginFacade.facadeEntryPointForRetrieveUserProfileData(request, requestModel), "Success", "200");
    }
}
