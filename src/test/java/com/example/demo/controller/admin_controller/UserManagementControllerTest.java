package com.example.demo.controller.admin_controller;

import com.example.demo.facade.admin_facade.UserManagementFacade;
import com.example.demo.model.admin.user_management.retrieve_user.RetrieveUsersRequestBody;
import com.example.demo.model.admin.user_management.retrieve_user.RetrieveUsersResultModel;
import com.example.demo.repository.user_management.RoleMstRepository;
import com.example.demo.repository.user_management.UserMstRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.admin_service.user_management.UserManagementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.security.test.context.support.WithMockUser;


@WebMvcTest(UserManagementController.class)
@AutoConfigureMockMvc(addFilters = false)
 class UserManagementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserManagementFacade userManagementFacade;

    @MockBean
    UserManagementService userManagementService;

    @MockBean
    UserMstRepository userMstRepository;

    @MockBean
    JwtUtil jwtUtil;

    @MockBean
    RoleMstRepository roleMstRepository;

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    void shouldReturnListOfUsers() throws Exception{
        List<RetrieveUsersResultModel> result = new ArrayList<>();
        RetrieveUsersResultModel model = new RetrieveUsersResultModel();
        model.setUserName("basawaraj.biradar");
        model.setRole("ADMIN");
        when(userManagementFacade.facadeEntryPointForRetrieveUsers(any(RetrieveUsersRequestBody.class)))
                .thenReturn(result);

        mockMvc.perform(post("/api/user-management/get-users")
                .contentType(MediaType.APPLICATION_JSON).content("{\"userId\" : null}"))
                .andExpect(jsonPath("$.data").isArray());
    }
}
