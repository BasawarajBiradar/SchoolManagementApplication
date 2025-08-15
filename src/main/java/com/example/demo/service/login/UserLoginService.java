package com.example.demo.service.login;

import com.example.demo.model.login.LoginRequestRequestModel;
import org.springframework.http.ResponseEntity;

public interface UserLoginService {
    ResponseEntity<?> serviceEntryPointForLogin(LoginRequestRequestModel request);
}
