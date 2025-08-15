package com.example.demo.controller.loginController;

import com.example.demo.facade.login.UserLoginFacade;
import com.example.demo.model.login.LoginRequestRequestModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class UserLoginController {

    private final UserLoginFacade userLoginFacade;

    public UserLoginController(UserLoginFacade userLoginFacade) {
        this.userLoginFacade = userLoginFacade;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestRequestModel request) {
        return this.userLoginFacade.facadeEntryPointForLogin(request);
    }
}
