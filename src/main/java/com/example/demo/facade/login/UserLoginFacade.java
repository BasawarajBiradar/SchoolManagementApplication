package com.example.demo.facade.login;

import com.example.demo.model.login.LoginRequestRequestModel;
import com.example.demo.model.login.retrieve_user_profile.RetrieveUserProfileRequestRequestModel;
import com.example.demo.model.login.retrieve_user_profile.RetrieveUserProfileResultModel;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public interface UserLoginFacade {
    Map<String, String> facadeEntryPointForLogin(LoginRequestRequestModel request);

    RetrieveUserProfileResultModel facadeEntryPointForRetrieveUserProfileData(HttpServletRequest request, RetrieveUserProfileRequestRequestModel requestModel);
}
