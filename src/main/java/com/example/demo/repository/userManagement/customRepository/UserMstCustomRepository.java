package com.example.demo.repository.userManagement.customRepository;

import java.util.List;

public interface UserMstCustomRepository {

    List<Object[]> retrieveUsersData(Integer userId);
}
