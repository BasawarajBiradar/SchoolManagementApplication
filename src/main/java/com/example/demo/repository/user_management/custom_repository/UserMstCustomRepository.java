package com.example.demo.repository.user_management.custom_repository;

import java.util.List;

public interface UserMstCustomRepository {

    List<Object[]> retrieveUsersData(String userId);
}
