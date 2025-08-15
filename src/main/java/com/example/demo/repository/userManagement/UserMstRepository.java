package com.example.demo.repository.userManagement;

import com.example.demo.entity.userManagement.UserMst;
import com.example.demo.repository.userManagement.customRepository.UserMstCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserMstRepository extends JpaRepository<UserMst, String>, UserMstCustomRepository {

    Optional<UserMst> findByUserName(String username);
}
