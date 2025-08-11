package com.example.demo.repository;

import com.example.demo.entity.UserMst;
import com.example.demo.repository.customRepository.UserMstCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMstRepository extends JpaRepository<UserMst, String>, UserMstCustomRepository {
}
