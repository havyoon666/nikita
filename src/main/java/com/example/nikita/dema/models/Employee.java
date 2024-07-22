package com.example.nikita.dema.models;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String info;
    private Integer departmentId;
    public Employee(int id, String firstName, String lastName, String info, Integer departmentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.info = info;
        this.departmentId = departmentId;
    }
    public Employee(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getinfo(){return info;}
    public void setInfo(String info){this.info = info;}

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
