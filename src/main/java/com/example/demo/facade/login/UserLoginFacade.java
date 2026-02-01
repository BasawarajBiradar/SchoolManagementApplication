package com.example.demo.facade.login;

import com.example.demo.model.login.LoginRequestRequestModel;
import com.example.demo.model.login.retrieve_user_profile.RetrieveUserProfileRequestRequestModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface UserLoginFacade {
    ResponseEntity<?> facadeEntryPointForLogin(LoginRequestRequestModel request);

    ResponseEntity<?> facadeEntryPointForRetrieveUserProfileData(HttpServletRequest request, RetrieveUserProfileRequestRequestModel requestModel);
}
