package com.example.demo.service.login.impl;

import com.example.demo.entity.user_management.UserMst;
import com.example.demo.model.login.LoginRequestRequestModel;
import com.example.demo.model.login.retrieve_user_profile.RetrieveUserProfileRequestRequestModel;
import com.example.demo.model.login.retrieve_user_profile.RetrieveUserProfileResultModel;
import com.example.demo.repository.user_management.UserMstRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.login.UserLoginService;
import com.example.demo.utils.common_methods.ExtractUserId;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserMstRepository userRepository;
    private final ExtractUserId extractUserId;

    public UserLoginServiceImpl (UserMstRepository userMstRepository, ExtractUserId extractUserId,
                                 PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userMstRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.extractUserId = extractUserId;
    }

    @Override
    public Map<String, String> serviceEntryPointForLogin(LoginRequestRequestModel request) {
        UserMst user = userRepository.findByUserName(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new AuthorizationDeniedException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getUserName(), user.getRole().getRole(), user.getId());

        return Collections.singletonMap("token", token);
    }

    @Override
    public RetrieveUserProfileResultModel serviceEntryPointForRetrieveUserProfileData(HttpServletRequest request, RetrieveUserProfileRequestRequestModel requestModel) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new AuthenticationCredentialsNotFoundException("Missing or invalid token");
        }

        String token = authHeader.substring(7);
        String userId = extractUserId.extractUserId(token);
        UserMst user = this.userRepository.findById(userId).orElseThrow();
        return new RetrieveUserProfileResultModel(user.getId(), user.getFirstName(), user.getLastName(),
                user.getRole().getId(), user.getRole().getRole(), user.getEmailId());
    }
}
