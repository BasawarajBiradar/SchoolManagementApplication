package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_mst")
public class UserMst {

    @Id
    @GeneratedValue(generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.example.demo.utils.CustomIdGenerator")
    private String id;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;
    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleMst role;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserMst createdBy;

    @Column(name = "last_updated_on")
    private LocalDateTime lastUpdateOn;

    @ManyToOne
    @JoinColumn(name = "last_updated_by")
    private UserMst lastUpdatedBy;

    @Column(name = "active_status")
    private boolean activeStatus;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
}
