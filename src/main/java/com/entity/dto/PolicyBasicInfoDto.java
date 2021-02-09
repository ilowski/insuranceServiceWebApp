package com.entity.dto;


import java.sql.Date;

public class PolicyBasicInfoDto {

    private String numberOfPolicy;
    private String typeOfPolicy;
    private String insuranceCompany;
    private java.sql.Date dateOfStartPolicy;
    private java.sql.Date dateOfEndPolicy;
    private CustomerBasicInfoForPolicyDto customer;

    public PolicyBasicInfoDto() {
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

    public Date getDateOfStartPolicy() {
        return dateOfStartPolicy;
    }

    public void setDateOfStartPolicy(Date dateOfStartPolicy) {
        this.dateOfStartPolicy = dateOfStartPolicy;
    }

    public Date getDateOfEndPolicy() {
        return dateOfEndPolicy;
    }

    public void setDateOfEndPolicy(Date dateOfEndPolicy) {
        this.dateOfEndPolicy = dateOfEndPolicy;
    }

    public CustomerBasicInfoForPolicyDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerBasicInfoForPolicyDto customer) {
        this.customer = customer;
    }

    public PolicyBasicInfoDto(String numberOfPolicy, String typeOfPolicy, String insuranceCompany, Date dateOfStartPolicy, Date dateOfEndPolicy, CustomerBasicInfoForPolicyDto customer) {
        this.numberOfPolicy = numberOfPolicy;
        this.typeOfPolicy = typeOfPolicy;
        this.insuranceCompany = insuranceCompany;
        this.dateOfStartPolicy = dateOfStartPolicy;
        this.dateOfEndPolicy = dateOfEndPolicy;
        this.customer = customer;
    }
}
