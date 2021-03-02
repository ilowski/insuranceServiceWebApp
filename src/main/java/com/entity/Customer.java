package com.entity;

import com.validator.PeselConstraint;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String secondName;
    @PESEL
    @PeselConstraint
    private String pesel;
    private String phoneNumber;
    private String address;
    private String additionalInformation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private final List<Policy> policies = new ArrayList<>();

    public Customer() {

    }

    public Customer(String firstName, String secondName, String pesel) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.pesel = pesel;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", numberPhone='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", policies=" + policies +
                '}';
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
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

    public Customer(Long id, String firstName, String secondName, String pesel) {
        super();
        this.firstName = firstName;
        this.secondName = secondName;
        this.id = id;
        this.pesel = pesel;
    }

    public Long getId() {
        return id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
