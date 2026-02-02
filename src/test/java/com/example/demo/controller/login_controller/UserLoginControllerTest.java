package com.example.demo.controller.login_controller;

import com.example.demo.facade.login.UserLoginFacade;
import com.example.demo.model.login.LoginRequestRequestModel;
import com.example.demo.repository.user_management.RoleMstRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.login.UserLoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.mockito.Mockito.*;

@WebMvcTest(UserLoginController.class)
@AutoConfigureMockMvc(addFilters = false)
 class UserLoginControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    UserLoginFacade userLoginFacade;

    @MockBean
    private UserLoginService authService;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private RoleMstRepository roleMstRepository;


    @Test
    void shouldReturnValidTokenIfLoginIsSuccessful() throws Exception{
        Map<String, String> fakeToken = new HashMap<>();
        fakeToken.put("Token", "fake_token.for.testng");
        when(userLoginFacade.facadeEntryPointForLogin(new LoginRequestRequestModel("admin", "admin@123")))
                .thenReturn(fakeToken);

        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"admin\",\"password\":\"admin@123\"}"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.data").value(fakeToken));
    }

}
