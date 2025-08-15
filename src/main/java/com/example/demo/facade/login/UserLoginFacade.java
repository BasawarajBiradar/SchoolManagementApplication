package com.example.demo.facade.login;

import com.example.demo.model.login.LoginRequestRequestModel;
import org.springframework.http.ResponseEntity;

public interface UserLoginFacade {
    ResponseEntity<?> facadeEntryPointForLogin(LoginRequestRequestModel request);
}
