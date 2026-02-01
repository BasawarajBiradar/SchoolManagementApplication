package com.example.demo.repository.user_management;

import com.example.demo.entity.user_management.UserMst;
import com.example.demo.repository.user_management.custom_repository.UserMstCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserMstRepository extends JpaRepository<UserMst, String>, UserMstCustomRepository {

    Optional<UserMst> findByUserName(String username);
}
