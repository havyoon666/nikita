package com.example.nikita.dema.models;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String info;
    private Integer departmentId;
    private Integer age;
    private Integer salary;

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Employee(int id, String firstName, String lastName, String info, Integer departmentId,Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.info = info;
        this.departmentId = departmentId;
        this.age = age;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
