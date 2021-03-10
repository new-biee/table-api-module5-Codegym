package com.example.api.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigInteger;

@Entity
public class Employee {

    @Id
    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private BigInteger age;

    @ManyToOne
    @JoinColumn(name = "office_id")
    @JsonProperty
    private Office office;

    @ManyToOne
    @JoinColumn(name = "position_id")
    @JsonProperty
    private Position position;

    public Employee() {
    }

    public Employee(Long id, String name, BigInteger age, Office office, Position position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.office = office;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getAge() {
        return age;
    }

    public void setAge(BigInteger age) {
        this.age = age;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
