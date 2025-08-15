package com.example.demo.facade.adminFacade;

import com.example.demo.model.admin.userManagement.registerUser.RegisterUserRequestBody;
import com.example.demo.model.admin.userManagement.retrieveUser.RetrieveUsersRequestBody;
import org.springframework.http.ResponseEntity;

public interface UserManagementFacade {

    ResponseEntity<?> facadeEntryForRegisterUser(RegisterUserRequestBody requestBody);

    ResponseEntity<?> facadeEntryPointForRetrieveUsers(RetrieveUsersRequestBody requestBody);
}
