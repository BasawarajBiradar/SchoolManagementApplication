package com.example.demo.facade.login.impl;

import com.example.demo.facade.login.UserLoginFacade;
import com.example.demo.model.login.LoginRequestRequestModel;
import com.example.demo.model.login.retrieve_user_profile.RetrieveUserProfileRequestRequestModel;
import com.example.demo.model.login.retrieve_user_profile.RetrieveUserProfileResultModel;
import com.example.demo.service.login.UserLoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserLoginFacadeImpl implements UserLoginFacade {

    private final UserLoginService userLoginService;

    public UserLoginFacadeImpl(UserLoginService userLoginService) {this.userLoginService = userLoginService;}

    @Override
    public Map<String, String> facadeEntryPointForLogin(LoginRequestRequestModel request) {
        return this.userLoginService.serviceEntryPointForLogin(request);
    }

    @Override
    public RetrieveUserProfileResultModel facadeEntryPointForRetrieveUserProfileData(HttpServletRequest request, RetrieveUserProfileRequestRequestModel requestModel) {
        return this.userLoginService.serviceEntryPointForRetrieveUserProfileData(request, requestModel);
    }
}
