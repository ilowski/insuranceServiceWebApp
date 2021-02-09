package com.entity.dto;

import com.entity.Policy;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class CustomerFullInfoForProfileDto {
    private Long id;

    private String firstName;

    private String secondName;

    private String pesel;

    private List<String> policies;

    public CustomerFullInfoForProfileDto(Long id, String firstName, String secondName, String pesel, List<String> policies) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.pesel = pesel;
        this.policies = policies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public List<String> getPolicies() {
        return policies;
    }

    public void setPolicies(List<String> policies) {
        this.policies = policies;
    }
}
