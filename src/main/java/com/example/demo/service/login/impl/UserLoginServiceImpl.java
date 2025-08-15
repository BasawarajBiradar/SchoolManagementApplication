package com.example.demo.service.login.impl;

import com.example.demo.entity.userManagement.UserMst;
import com.example.demo.model.login.LoginRequestRequestModel;
import com.example.demo.model.login.retrieveUserProfile.RetrieveUserProfileRequestRequestModel;
import com.example.demo.repository.userManagement.UserMstRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.login.UserLoginService;
import com.example.demo.utils.CommonMethods;
import com.example.demo.utils.response.ResponseHandler;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserMstRepository userRepository;
    private final CommonMethods commonMethods;

    public UserLoginServiceImpl (UserMstRepository userMstRepository, CommonMethods commonMethods,
                                 PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userMstRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.commonMethods = commonMethods;
    }

    @Override
    public ResponseEntity<?> serviceEntryPointForLogin(LoginRequestRequestModel request) {
        UserMst user = userRepository.findByUserName(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseHandler.error("Invalid credentials", "Unauthorized", "401");
        }

        String token = jwtUtil.generateToken(user.getUserName(), user.getRole().getRole(), user.getId());

        return ResponseHandler.success(Collections.singletonMap("token", token), "Success", "200");
    }

    @Override
    public ResponseEntity<?> serviceEntryPointForRetrieveUserProfileData(HttpServletRequest request, RetrieveUserProfileRequestRequestModel requestModel) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseHandler.error("Missing or invalid token", "401");
        }

        String token = authHeader.substring(7);
        String userId = commonMethods.extractUserId(token);
        UserMst user = this.userRepository.findById(userId).orElseThrow();
        return ResponseHandler.success(user, "Success", "200");
    }
}
