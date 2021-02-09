package com.entity.dto;

import java.util.ArrayList;
import java.util.List;

public class PolicyForProfileDto {
    List<String> numberOfPolicy;

    public PolicyForProfileDto() {
        this.numberOfPolicy = new ArrayList<>();
    }

    public List<String> getNumberOfPolicy() {
        return numberOfPolicy;
    }

    public void setNumberOfPolicy(List<String> numberOfPolicy) {
        this.numberOfPolicy = numberOfPolicy;
    }
}
