package com.example.starter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    private String name;

    @JsonProperty("id")
    private int employee_id;

    public Employee() {}

    public Employee(int employee_id, String name){
        this.employee_id = employee_id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }
}
