package com.example.demo.repository.customRepository.impl;

import com.example.demo.repository.customRepository.UserMstCustomRepository;
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
        sql.append("SELECT user_name, password, role_id, email_id, created_on, ")
                        .append("created_by, last_updated_on, last_updated_by, active_status ");
        sql.append("FROM user_mst users WHERE 1 = 1 ");
        if (userId != null)
            sql.append("AND users.id = :userId ");
        Query query = em.createNativeQuery(sql.toString());
        if (userId != null)
            query.setParameter("userId", userId);
        return query.getResultList();
    }
}
