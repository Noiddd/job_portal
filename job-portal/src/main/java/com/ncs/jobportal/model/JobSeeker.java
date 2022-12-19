package com.ncs.jobportal.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class JobSeeker extends User{

    private String firstName;

    private String lastName;

    private String phone;

    @OneToMany(mappedBy = "jobSeeker", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<UserCredential> credentials;

    public JobSeeker(String email, String firstName, String lastName, String phone, List<UserCredential> credentials) {
        super(email, UserType.JobSeeker);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;

    }

    public JobSeeker() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId(){
        return super.getId();
    }
}
