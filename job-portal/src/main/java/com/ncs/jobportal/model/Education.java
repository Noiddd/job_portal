package com.ncs.jobportal.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Education extends UserCredential{

    private String institute;

    private Date startDate;

    private Date endDate;

    private String major;

    public Education() {
    }

    public Education(String cred, String institute, Date startDate, Date endDate, String major, JobSeeker jobSeeker) {
        super(cred, jobSeeker);
        this.institute = institute;
        this.startDate = startDate;
        this.endDate = endDate;
        this.major = major;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
