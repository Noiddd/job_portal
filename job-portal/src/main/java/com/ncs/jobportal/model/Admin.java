package com.ncs.jobportal.model;

import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Admin extends User{

    private String username;


    public Admin(String email,  String username) {
        super(email, UserType.Admin);
        this.username = username;
    }

    public Admin() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId(){
        return super.getId();
    }
}
