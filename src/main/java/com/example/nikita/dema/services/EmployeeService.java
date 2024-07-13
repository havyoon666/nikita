package com.example.nikita.dema.services;


import com.example.nikita.dema.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(new Employee(1, "Budda", "Ragna"));
        employees.add(new Employee(2, "Nikita", "Bilyk"));
        employees.add(new Employee(3, "Invoker", "GERAs"));
    }

    public void addDepartment(Employee employee) {
        int maxId = 0;
        for (Employee employeeInList : employees) {
            if (employeeInList.getId() > maxId) {
                maxId = employeeInList.getId();
            }
        }
        employee.setId(maxId + 1);
        employees.add(employee);
    }

    public List<Employee> getAllEmployess() {
        return employees;
    }

    public Employee getEmployeeById(String id) {
        for (Employee employeeInList : employees) {
            if (employeeInList.getId() == Integer.parseInt(id)) {
                return employeeInList;
            }
        }
        return null;
    }

    public void update(Employee employeeParam) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeParam.getId()) {
               employee.setFirstName(employee.getFirstName());
               employee.setLastName(employee.getLastName());
            }
        }
    }

    public void deleteEmployee(int id){
        Employee employee = null;
        for (Employee employeeInList : employees) {
            if (employeeInList.getId() == id) {
                employee = employeeInList;
            }
        }
        employees.remove(employee);
    }
}
