package com.example.demo.service.login;

import com.example.demo.model.login.LoginRequestRequestModel;
import com.example.demo.model.login.retrieveUserProfile.RetrieveUserProfileRequestRequestModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface UserLoginService {
    ResponseEntity<?> serviceEntryPointForLogin(LoginRequestRequestModel request);

    ResponseEntity<?> serviceEntryPointForRetrieveUserProfileData(HttpServletRequest request, RetrieveUserProfileRequestRequestModel requestModel);
}
