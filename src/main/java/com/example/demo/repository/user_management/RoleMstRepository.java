package com.example.demo.repository.user_management;

import com.example.demo.entity.user_management.RoleMst;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleMstRepository extends JpaRepository<RoleMst, Integer> {
    RoleMst findByRole(String role);
}
