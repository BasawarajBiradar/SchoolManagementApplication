package com.example.demo.service.adminService.userManagement;

import com.example.demo.model.admin.userManagement.retrieveUser.RetrieveUsersRequestBody;
import com.example.demo.model.admin.userManagement.retrieveUser.RetrieveUsersResultModel;
import com.example.demo.repository.userManagement.UserMstRepository;
import com.example.demo.service.adminService.userManagement.impl.UserManagementServiceImpl;
import com.example.demo.utils.response.ApiResponse;
import com.example.demo.utils.response.ResponseHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserManagementTestService {


    @Mock
    UserMstRepository userRepository;

    @InjectMocks
    UserManagementServiceImpl service;

    @Test
    void shouldReturnSortedUsersList() {
        Object[] user1 = {"alice", "pass", "ADMIN", "a@mail.com", null, null, null, null, "true"};
        Object[] user2 = {"bob", "pass", "USER", "b@mail.com", null, null, null, null, "true"};

        when(userRepository.retrieveUsersData(null)).thenReturn(List.of(user1, user2)); // unsorted

        ResponseEntity<?> response = service.serviceEntryPointForRetrieveUsers(new RetrieveUsersRequestBody());

        ApiResponse<List<RetrieveUsersResultModel>> responseBody = (ApiResponse<List<RetrieveUsersResultModel>>) (response.getBody()); // cast carefully
        List<RetrieveUsersResultModel> result = responseBody.getData();
        assertEquals(2, result.size());
        assertEquals("alice", result.get(0).getUserName()); // sorted by username
        assertEquals("bob", result.get(1).getUserName());

    }
}
