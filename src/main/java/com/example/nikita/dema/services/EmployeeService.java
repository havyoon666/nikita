package com.example.nikita.dema.services;


import com.example.nikita.dema.models.Department;
import com.example.nikita.dema.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private Map<Integer,List<Employee>> employeeMap = new HashMap<>();

    public EmployeeService() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Budda", "Ragna", "info1", 1));
        employeeList.add(new Employee(2, "Nikita", "Bilyk", "info2", 1));

        employeeMap.put(1, employeeList);
        employeeMap.put(2, List.of(new Employee(3, "Invoker", "GERAs", "info3", 2)));
    }
    public void addEmployee(Employee employee) {
        employeeMap.get(employee.getDepartmentId()).add(employee);
    }


//    public void addDepartment(Employee employee) {
//        int maxId = 0;
//        for (Employee employeeInList : employees) {
//            if (employeeInList.getId() > maxId) {
//                maxId = employeeInList.getId();
//            }
//        }
//        employee.setId(maxId + 1);
//        employees.add(employee);
//    }

    public List<Employee> getEmployeesByDepartment(Integer departmentId) {
        return employeeMap.get(departmentId);
    }
//
//    public Employee getEmployeeById(String id) {
//        for (Employee employeeInList : employees) {
//            if (employeeInList.getId() == Integer.parseInt(id)) {
//                return employeeInList;
//            }
//        }
//        return null;
//    }
//
//    public void update(Employee employeeParam) {
//        for (Employee employee : employees) {
//            if (employee.getId() == employeeParam.getId()) {
//               employee.setFirstName(employee.getFirstName());
//               employee.setLastName(employee.getLastName());
//            }
//        }
//    }

//    public void deleteEmployee(int id){
//        Employee employee = null;
//        for (Employee employeeInList : employees) {
//            if (employeeInList.getId() == id) {
//                employee = employeeInList;
//            }
//        }
//        employees.remove(employee);
//    }
}
