package com.example.demo.facade.adminFacade;

import com.example.demo.model.admin.userManagement.retrieveUser.RegisterUserRequestBody;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;

public interface UserManagementFacade {

    ResponseEntity<?> facadeEntryForRegisterUser(RegisterUserRequestBody requestBody);
}
