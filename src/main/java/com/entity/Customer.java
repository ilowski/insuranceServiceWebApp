package com.entity;

import org.springframework.lang.NonNull;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Customer {
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String secondName;

    public Customer() {
        super();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) &&
                firstName.equals(customer.firstName) &&
                secondName.equals(customer.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName);
    }

    public Customer(Long id, String firstName, String secondName) {
        super();
        this.firstName = firstName;
        this.secondName = secondName;
        this.id = id;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

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

}
