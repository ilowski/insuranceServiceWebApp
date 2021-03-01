package com.entity.dto;

import com.validator.PeselConstraint;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.security.core.parameters.P;

import javax.validation.constraints.NotNull;

public class CustomerBasicInfoForPolicyDto {

    @NotNull
    String firstName;
    @NotNull
    String secondName;
    @PESEL
    @PeselConstraint
    String pesel;

    public CustomerBasicInfoForPolicyDto(String firstName, String secondName, String pesel) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public CustomerBasicInfoForPolicyDto() {
    }



    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
