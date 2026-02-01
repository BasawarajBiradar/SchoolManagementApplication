package com.example.demo.utils.custom_ids_generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        String prefix = "USR-";

        Long count = ((Number) session.createNativeQuery("SELECT COUNT(id) FROM user_mst")
                .getSingleResult()).longValue();

        return prefix + String.format("%04d", count + 1);
    }
}

