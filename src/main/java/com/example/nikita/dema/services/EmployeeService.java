package com.example.nikita.dema.services;



import com.example.nikita.dema.models.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private Map<Integer,List<Employee>> employeeMap = new HashMap<>();

    public EmployeeService() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Budda", "Ragna", "info1", 1));
        employeeList.add(new Employee(2, "Nikita", "Bilyk", "info2", 1));

        employeeMap.put(1, employeeList);
        employeeMap.put(2, Arrays.asList(new Employee(3, "Invoker", "GERAs", "info3", 2)));
    }
    public void addEmployee(Employee employee) {
        Integer departmentId = employee.getDepartmentId();
        List<Employee> employeeList = employeeMap.get(departmentId);

        if (employeeList == null) {
            employeeList = new ArrayList<>(); // Initialize the list if it does not exist
            employeeMap.put(departmentId, employeeList);
        } else if (!(employeeList instanceof ArrayList)) {
            employeeList = new ArrayList<>(employeeList); // Ensure the list is modifiable
            employeeMap.put(departmentId, employeeList);
        }

        int maxId = employeeList.stream()
                .map(Employee::getId)
                .max(Integer::compareTo)
                .orElse(0); // Handle empty list case
        employee.setId(maxId + 1);
        employeeList.add(employee);
    }

    public Employee getEmployeeById(Integer id) {
        for (Map.Entry<Integer, List<Employee>> entry : employeeMap.entrySet()) {
            List<Employee> employees = entry.getValue();
            for (Employee employee : employees) {
                if (employee.getId()==(id)) {
                    return employee;
                }
            }
        }
        return null;
    }
//        return employeeMap.values().stream()  // Stream of List<Employee>
//                .flatMap(List::stream)            // Stream of Employee
//                .filter(employee -> employee.getId()==id)  // Filter by employeeId
//                .findFirst().get();
//
//    }
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

    public void updateEmployee(Employee employeeToUpdate) {
        for (Map.Entry<Integer, List<Employee>> entry : employeeMap.entrySet()) {
            List<Employee> employees = entry.getValue();
            for (Employee employee : employees) {
                if (employee.getId()==(employeeToUpdate.getId())) {
                 employee.setFirstName(employeeToUpdate.getFirstName());
                 employee.setLastName(employeeToUpdate.getLastName());
                 employee.setInfo(employeeToUpdate.getInfo());
                }
            }
        }

    }

    public void deleteEmployee(int id) {
        for (Map.Entry<Integer, List<Employee>> entry : employeeMap.entrySet()) {
            List<Employee> employees = entry.getValue();

            // Check if the list is modifiable, if not, create a modifiable copy
            if (!(employees instanceof ArrayList)) {
                employees = new ArrayList<>(employees);
                entry.setValue(employees);
            }

            Iterator<Employee> iterator = employees.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getId() == id) {
                    iterator.remove();
                }
            }
        }
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
