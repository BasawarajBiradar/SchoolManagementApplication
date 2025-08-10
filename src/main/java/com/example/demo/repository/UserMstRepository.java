package com.example.demo.repository;

import com.example.demo.entity.UserMst;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMstRepository extends JpaRepository<UserMst, String> {
}
