package com.example.demo.controller.adminController;

import com.example.demo.facade.adminFacade.UserManagementFacade;
import com.example.demo.model.admin.userManagement.retrieveUser.RetrieveUsersRequestBody;
import com.example.demo.model.admin.userManagement.retrieveUser.RetrieveUsersResultModel;
import com.example.demo.repository.userManagement.RoleMstRepository;
import com.example.demo.repository.userManagement.UserMstRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.adminService.userManagement.UserManagementService;
import com.example.demo.utils.response.ResponseHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.MockMvc.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.security.test.context.support.WithMockUser;


@WebMvcTest(UserManagementController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserManagementTestController {

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
        RetrieveUsersResultModel user = new RetrieveUsersResultModel();
        user.setUserName("basawaraj.biradar");
        user.setRole("ADMIN");
        ResponseEntity result = ResponseHandler.success(List.of(user), "Success", "200");

        when(userManagementFacade.facadeEntryPointForRetrieveUsers(any(RetrieveUsersRequestBody.class)))
                .thenReturn(result);

        mockMvc.perform(post("/api/user-management/get-users")
                .contentType(MediaType.APPLICATION_JSON).content("{\"userId\" : null}"))
                .andExpect(jsonPath("$.data").isArray());
    }
}
