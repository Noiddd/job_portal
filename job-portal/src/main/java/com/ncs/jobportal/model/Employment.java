package com.ncs.jobportal.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employment extends UserCredential {

    private String companyName;

    private Date startDate;

    private Date endDate;

    private String jobDesc;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    public Employment(String credentialName, String companyName, Date startDate, Date endDate, String jobDesc, JobSeeker jobSeeker) {
        super(credentialName, jobSeeker);
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobDesc = jobDesc;
        this.jobSeeker = jobSeeker;
    }

    public Employment() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }
}
