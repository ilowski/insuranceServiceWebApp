package com.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "policies")
public class Policy {
    @Id
    private String numberOfPolicy;
    private String typeOfPolicy;
    private String insuranceCompany;
    private java.sql.Date dateOfStartPolicy;
    private java.sql.Date dateOfEndPolicy;
    private Long customerId;


    public Policy() {
    }

    public Policy(String numberOfPolicy, String typeOfPolicy, String insuranceCompany, java.sql.Date dateOfStartPolicy, java.sql.Date dateOfEndPolicy, Long customerId) {
        this.numberOfPolicy = numberOfPolicy;
        this.typeOfPolicy = typeOfPolicy;
        this.insuranceCompany = insuranceCompany;
        this.dateOfStartPolicy = dateOfStartPolicy;
        this.dateOfEndPolicy = dateOfEndPolicy;
        this.customerId = customerId;
    }


    @Override
    public String toString() {
        return "Policy{" +
                ", numberOfPolicy=" + numberOfPolicy +
                ", typeOfPolicy='" + typeOfPolicy + '\'' +
                ", insuranceCompany='" + insuranceCompany + '\'' +
                ", dateOfStartPolicy=" + dateOfStartPolicy +
                ", dateOfEndPolicy=" + dateOfEndPolicy +
                ", customerId=" + customerId +
                '}';
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getNumberOfPolicy() {
        return numberOfPolicy;
    }

    public void setNumberOfPolicy(String numberOfPolicy) {
        this.numberOfPolicy = numberOfPolicy;
    }

    public String getTypeOfPolicy() {
        return typeOfPolicy;
    }

    public void setTypeOfPolicy(String typeOfPolicy) {
        this.typeOfPolicy = typeOfPolicy;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public java.sql.Date getDateOfStartPolicy() {
        return dateOfStartPolicy;
    }

    public void setDateOfStartPolicy(java.sql.Date dateOfStartPolicy) {
        this.dateOfStartPolicy = dateOfStartPolicy;
    }

    public java.sql.Date getDateOfEndPolicy() {
        return dateOfEndPolicy;
    }

    public void setDateOfEndPolicy(java.sql.Date dateOfEndPolicy) {
        this.dateOfEndPolicy = dateOfEndPolicy;
    }
}
