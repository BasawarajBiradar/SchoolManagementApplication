package com.example.demo.service.login;

import com.example.demo.model.login.LoginRequestRequestModel;
import com.example.demo.model.login.retrieve_user_profile.RetrieveUserProfileRequestRequestModel;
import com.example.demo.model.login.retrieve_user_profile.RetrieveUserProfileResultModel;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public interface UserLoginService {
    Map<String, String> serviceEntryPointForLogin(LoginRequestRequestModel request);

    RetrieveUserProfileResultModel serviceEntryPointForRetrieveUserProfileData(HttpServletRequest request, RetrieveUserProfileRequestRequestModel requestModel);
}
