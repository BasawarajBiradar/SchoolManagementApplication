package com.example.demo.service.login.impl;

import com.example.demo.entity.userManagement.UserMst;
import com.example.demo.model.login.LoginRequestRequestModel;
import com.example.demo.repository.userManagement.UserMstRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.login.UserLoginService;
import com.example.demo.utils.response.ResponseHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserMstRepository userRepository;

    public UserLoginServiceImpl (UserMstRepository userMstRepository,
                                 PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userMstRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public ResponseEntity<?> serviceEntryPointForLogin(LoginRequestRequestModel request) {
        UserMst user = userRepository.findByUserName(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseHandler.error("Invalid credentials", "Unauthorized", "401");
        }

        String token = jwtUtil.generateToken(user.getUserName(), user.getRole().getRole());

        return ResponseHandler.success(Collections.singletonMap("token", token), "Success", "200");
    }
}
