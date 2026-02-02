package com.example.demo.service.admin_service.user_management;

import com.example.demo.model.admin.user_management.retrieve_user.RetrieveUsersRequestBody;
import com.example.demo.model.admin.user_management.retrieve_user.RetrieveUsersResultModel;
import com.example.demo.repository.user_management.UserMstRepository;
import com.example.demo.service.admin_service.user_management.impl.UserManagementServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class UserManagementServiceTest {

    @Mock
    UserMstRepository userRepository;

    @InjectMocks
    UserManagementServiceImpl service;

    @Test
    void shouldReturnSortedUsersList() {
        Object[] user1 = {"alice", "pass", "ADMIN", "a@mail.com", null, null, null, null, "true"};
        Object[] user2 = {"bob", "pass", "USER", "b@mail.com", null, null, null, null, "true"};
        when(userRepository.retrieveUsersData(null)).thenReturn(List.of(user1, user2)); // unsorted
        List<RetrieveUsersResultModel> result = service.serviceEntryPointForRetrieveUsers(new RetrieveUsersRequestBody()); // cast carefully
        assertEquals(2, result.size());
        assertEquals("alice", result.get(0).getUserName()); // sorted by username
        assertEquals("bob", result.get(1).getUserName());

    }
}
