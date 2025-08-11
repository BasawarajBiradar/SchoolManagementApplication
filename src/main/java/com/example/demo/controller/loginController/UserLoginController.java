package com.example.demo.controller.loginController;

import com.example.demo.entity.UserMst;
import com.example.demo.model.admin.userManagement.login.LoginRequestRequestModel;
import com.example.demo.repository.UserMstRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api")
public class UserLoginController {

    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserMstRepository userRepository;

    public UserLoginController(UserMstRepository userMstRepository,
                               PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userMstRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestRequestModel request) {
        UserMst user = userRepository.findByUserName(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getUserName(), user.getRole().getRole());

        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }
}
