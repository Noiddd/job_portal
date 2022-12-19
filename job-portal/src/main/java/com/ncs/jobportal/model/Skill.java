package com.ncs.jobportal.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Skill extends UserCredential{

    private String certification;

    public Skill(String credentialName, String certification, JobSeeker jobSeeker) {
        super(credentialName, jobSeeker);
        this.certification = certification;
    }

    public Skill() {
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

}
