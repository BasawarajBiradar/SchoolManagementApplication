package com.example.demo.controller.loginController;

import com.example.demo.facade.login.UserLoginFacade;
import com.example.demo.model.login.LoginRequestRequestModel;
import com.example.demo.repository.userManagement.RoleMstRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.login.UserLoginService;
import com.example.demo.utils.response.ResponseHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.mockito.Mockito.*;

@WebMvcTest(UserLoginController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserLoginTestController {

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
        ResponseEntity fakeToken = ResponseHandler.success("fake_token.for.testng", "Success", "200");
        when(userLoginFacade.facadeEntryPointForLogin(new LoginRequestRequestModel("admin", "admin@123")))
                .thenReturn(fakeToken);

        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"admin\",\"password\":\"admin@123\"}"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.data").value("fake_token.for.testng"));
    }

}
