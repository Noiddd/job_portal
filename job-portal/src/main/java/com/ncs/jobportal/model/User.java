package com.ncs.jobportal.model;

import jakarta.persistence.*;

import org.hibernate.annotations.NaturalId;

import java.io.Serializable;

@Entity
public class User implements Serializable {

    @NaturalId
    private String email;

    private String password;

    private UserType userType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;

    public User() {
    }

    public User(String email, UserType userType) {
        this.email = email;
        this.userType = userType;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Boolean login(String password) {
        return false;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
