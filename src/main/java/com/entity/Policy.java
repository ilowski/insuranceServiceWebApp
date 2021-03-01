package com.entity;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "policies")
public class Policy {
    @Id
    @NotNull
    private String numberOfPolicy;
    @NotNull
    private String typeOfPolicy;
    @NotNull
    private String insuranceCompany;
    @NotNull
    private java.sql.Date dateOfStartPolicy;
    @NotNull
    @Future
    private java.sql.Date dateOfEndPolicy;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "customerId")
    private Customer customer;


    public Policy() {
    }

    public Policy(String numberOfPolicy, String typeOfPolicy, String insuranceCompany, java.sql.Date dateOfStartPolicy, java.sql.Date dateOfEndPolicy, Customer customer) {
        this.numberOfPolicy = numberOfPolicy;
        this.typeOfPolicy = typeOfPolicy;
        this.insuranceCompany = insuranceCompany;
        this.dateOfStartPolicy = dateOfStartPolicy;
        this.dateOfEndPolicy = dateOfEndPolicy;
        this.customer = customer;
    }


    @Override
    public String toString() {
        return "Policy{" +
                "numberOfPolicy='" + numberOfPolicy + '\'' +
                ", typeOfPolicy='" + typeOfPolicy + '\'' +
                ", insuranceCompany='" + insuranceCompany + '\'' +
                ", dateOfStartPolicy=" + dateOfStartPolicy +
                ", dateOfEndPolicy=" + dateOfEndPolicy +
                ", customer=" + customer +
                '}';
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
