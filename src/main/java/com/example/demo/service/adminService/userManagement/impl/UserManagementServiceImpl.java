package com.example.demo.service.adminService.userManagement.impl;

import com.example.demo.entity.UserMst;
import com.example.demo.model.admin.userManagement.retrieveUser.RegisterUserRequestBody;
import com.example.demo.repository.UserMstRepository;
import com.example.demo.service.adminService.userManagement.UserManagementService;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    private final UserMstRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserManagementServiceImpl(UserMstRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public ResponseEntity<?> serviceEntryPointForRegisterUser(RegisterUserRequestBody requestBody) {
        UserMst user = new UserMst();
        user.setUserName(requestBody.getUserName());
        user.setPassword(passwordEncoder.encode(requestBody.getPassword())); // hash here
        userRepository.save(user);

        return null;
    }

}
