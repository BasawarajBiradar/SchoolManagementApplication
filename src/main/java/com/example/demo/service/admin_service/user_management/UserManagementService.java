package com.example.demo.service.admin_service.user_management;

import com.example.demo.model.admin.user_management.register_user.RegisterUserRequestBody;
import com.example.demo.model.admin.user_management.retrieve_user.RetrieveUsersRequestBody;
import com.example.demo.model.admin.user_management.retrieve_user.RetrieveUsersResultModel;

import java.util.List;

public interface UserManagementService {

    String serviceEntryPointForRegisterUser(RegisterUserRequestBody requestBody);

    List<RetrieveUsersResultModel> serviceEntryPointForRetrieveUsers(RetrieveUsersRequestBody requestBody);
}

