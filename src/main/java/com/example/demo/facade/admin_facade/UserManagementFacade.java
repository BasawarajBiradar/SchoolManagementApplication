package com.example.demo.facade.admin_facade;

import com.example.demo.model.admin.user_management.register_user.RegisterUserRequestBody;
import com.example.demo.model.admin.user_management.retrieve_user.RetrieveUsersRequestBody;
import org.springframework.http.ResponseEntity;

public interface UserManagementFacade {

    ResponseEntity<?> facadeEntryForRegisterUser(RegisterUserRequestBody requestBody);

    ResponseEntity<?> facadeEntryPointForRetrieveUsers(RetrieveUsersRequestBody requestBody);
}
