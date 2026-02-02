package com.example.demo.facade.admin_facade.impl;

import com.example.demo.facade.admin_facade.UserManagementFacade;
import com.example.demo.model.admin.user_management.register_user.RegisterUserRequestBody;
import com.example.demo.model.admin.user_management.retrieve_user.RetrieveUsersRequestBody;
import com.example.demo.model.admin.user_management.retrieve_user.RetrieveUsersResultModel;
import com.example.demo.service.admin_service.user_management.UserManagementService;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserManagementFacadeImpl implements UserManagementFacade {

    private final UserManagementService userManagementService;

    public UserManagementFacadeImpl(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @Override
    public String facadeEntryForRegisterUser(RegisterUserRequestBody requestBody) {
        if (requestBody.getRoleId() == null)
            throw new ValidationException("Role Id : role id is required");
        return this.userManagementService.serviceEntryPointForRegisterUser( requestBody);
    }

    @Override
    public List<RetrieveUsersResultModel> facadeEntryPointForRetrieveUsers(RetrieveUsersRequestBody requestBody) {
        // add validation if required.
        return this.userManagementService.serviceEntryPointForRetrieveUsers(requestBody);
    }
}
