package com.example.demo.repository.customRepository;

import com.example.demo.entity.UserMst;

import java.util.List;

public interface UserMstCustomRepository {

    List<Object[]> retrieveUsersData(Integer userId);
}
