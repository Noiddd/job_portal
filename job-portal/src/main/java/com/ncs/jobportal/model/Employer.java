package com.ncs.jobportal.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employer extends User{

    private String companyName;

    public Employer(String email, String companyName) {
        super(email, UserType.Employer);
        this.companyName = companyName;
    }

    public Employer() {

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getId() {
        return super.getId();
    }
}
