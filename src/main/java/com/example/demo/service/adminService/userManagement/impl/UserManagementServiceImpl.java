package com.example.demo.service.adminService.userManagement.impl;

import com.example.demo.entity.UserMst;
import com.example.demo.model.admin.userManagement.login.LoginRequestRequestModel;
import com.example.demo.model.admin.userManagement.registerUser.RegisterUserRequestBody;
import com.example.demo.model.admin.userManagement.retrieveUser.RetrieveUsersRequestBody;
import com.example.demo.model.admin.userManagement.retrieveUser.RetrieveUsersResultModel;
import com.example.demo.repository.UserMstRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.adminService.userManagement.UserManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    private final UserMstRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final JwtUtil jwtUtil;

    public UserManagementServiceImpl(UserMstRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }


    @Override
    public ResponseEntity<?> serviceEntryPointForRegisterUser(RegisterUserRequestBody requestBody) {
        UserMst user = new UserMst();
        user.setUserName(requestBody.getUserName());
        user.setPassword(passwordEncoder.encode(requestBody.getPassword())); // hash here
        userRepository.save(user);

        return null;
    }

    @Override
    public ResponseEntity<?> serviceEntryPointForRetrieveUsers(RetrieveUsersRequestBody requestBody) {
        List<Object[]> resultList = this.userRepository.retrieveUsersData(requestBody.getUserId());
        List<RetrieveUsersResultModel> resultModel = new ArrayList<>();
        for (Object[] res : resultList) {
            String userName = res[0] == null ? null : res[0].toString();
            String password = res[1] == null ? null : res[1].toString();
            String role = res[2] == null ? null : res[2].toString();
            String email = res[3] == null ? null : res[3].toString();
            String createdOn = res[4] == null ? null : res[4].toString();
            String createdBy = res[5] == null ? null : res[5].toString();
            String lastUpdatedOn = res[6] == null ? null : res[6].toString();
            String lastUpdatedBy = res[7] == null ? null : res[7].toString();
            String activeStatus = res[8] == null ? null : res[8].toString();

            resultModel.add(new RetrieveUsersResultModel(userName, password, role, email,
                    createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, activeStatus));
        }
        resultModel.sort((a,b) -> a.getUserName().compareToIgnoreCase(b.getUserName()));
        return ResponseEntity.ok(resultModel);
    }

    @Override
    public ResponseEntity<?> serviceEntryPointForLogin(LoginRequestRequestModel request) {
        UserMst user = userRepository.findByUserName(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getUserName(), user.getRole().getRole());

        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }

}
