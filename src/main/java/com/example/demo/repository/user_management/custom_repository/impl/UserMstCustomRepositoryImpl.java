package com.example.demo.repository.user_management.custom_repository.impl;

import com.example.demo.repository.user_management.custom_repository.UserMstCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserMstCustomRepositoryImpl implements UserMstCustomRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Object[]> retrieveUsersData(Integer userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT user_name, password, role.role, email_id, created_on, ")
                        .append("created_by, last_updated_on, last_updated_by, active_status ");
        sql.append("FROM user_mst users LEFT JOIN role_mst role ON role.id = users.role_id WHERE 1 = 1 ");
        if (userId != null)
            sql.append("AND users.id = :userId ");
        Query query = em.createNativeQuery(sql.toString());
        if (userId != null)
            query.setParameter("userId", userId);
        return query.getResultList();
    }
}
