package com.example.demo.service.adminService.user_management.impl;

import com.example.demo.entity.user_management.UserMst;
import com.example.demo.model.admin.user_management.register_user.RegisterUserRequestBody;
import com.example.demo.model.admin.user_management.retrieve_user.RetrieveUsersRequestBody;
import com.example.demo.model.admin.user_management.retrieve_user.RetrieveUsersResultModel;
import com.example.demo.repository.user_management.UserMstRepository;
import com.example.demo.repository.user_management.RoleMstRepository;
import com.example.demo.service.adminService.user_management.UserManagementService;
import com.example.demo.utils.common_methods.CommonMethods;
import com.example.demo.utils.response.ResponseHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    private final UserMstRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final RoleMstRepository roleMstRepository;

    public UserManagementServiceImpl(UserMstRepository userRepository, RoleMstRepository roleMstRepository) {
        this.userRepository = userRepository;
        this.roleMstRepository = roleMstRepository;
    }


    @Override
    public ResponseEntity<?> serviceEntryPointForRegisterUser(RegisterUserRequestBody requestBody) {
        UserMst user = new UserMst();
        user.setUserName(requestBody.getUserName());
        user.setPassword(passwordEncoder.encode(requestBody.getPassword())); // hash here
        user.setRole(roleMstRepository.findById(requestBody.getRoleId()).orElseThrow());
        user.setEmailId(requestBody.getEmailId());
        user.setFirstName(requestBody.getFirstName());
        user.setLastName(requestBody.getLastName());
        user.setActiveStatus(true);
        UserMst savedUser = userRepository.save(user);
        return ResponseHandler.success(savedUser, "Success", "200");
    }

    @Override
    public ResponseEntity<?> serviceEntryPointForRetrieveUsers(RetrieveUsersRequestBody requestBody) {
        List<Object[]> resultList = this.userRepository.retrieveUsersData(requestBody.getUserId());
        List<RetrieveUsersResultModel> resultModel = resultList.stream()
                .map(res -> new RetrieveUsersResultModel(
                        CommonMethods.safeToString(res[0]),
                        CommonMethods.safeToString(res[1]),
                        CommonMethods.safeToString(res[2]),
                        CommonMethods.safeToString(res[3]),
                        CommonMethods.safeToString(res[4]),
                        CommonMethods.safeToString(res[5]),
                        CommonMethods.safeToString(res[6]),
                        CommonMethods.safeToString(res[7]),
                        CommonMethods.safeToString(res[8])
                )).sorted(Comparator.comparing(RetrieveUsersResultModel::getUserName, String.CASE_INSENSITIVE_ORDER))
                .toList();
        return ResponseHandler.success(resultModel, "Success", "200");
    }



}
