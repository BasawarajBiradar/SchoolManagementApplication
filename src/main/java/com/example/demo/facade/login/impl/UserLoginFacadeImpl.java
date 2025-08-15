package com.example.demo.facade.login.impl;

import com.example.demo.facade.login.UserLoginFacade;
import com.example.demo.model.login.LoginRequestRequestModel;
import com.example.demo.model.login.retrieveUserProfile.RetrieveUserProfileRequestRequestModel;
import com.example.demo.service.login.UserLoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserLoginFacadeImpl implements UserLoginFacade {

    private final UserLoginService userLoginService;

    public UserLoginFacadeImpl(UserLoginService userLoginService) {this.userLoginService = userLoginService;}

    @Override
    public ResponseEntity<?> facadeEntryPointForLogin(LoginRequestRequestModel request) {
        return this.userLoginService.serviceEntryPointForLogin(request);
    }

    @Override
    public ResponseEntity<?> facadeEntryPointForRetrieveUserProfileData(HttpServletRequest request, RetrieveUserProfileRequestRequestModel requestModel) {
        return this.userLoginService.serviceEntryPointForRetrieveUserProfileData(request, requestModel);
    }
}
