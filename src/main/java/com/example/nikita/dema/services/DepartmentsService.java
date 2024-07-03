package com.example.nikita.dema.services;

import com.example.nikita.dema.models.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentsService {
    private List<Department> departments = new ArrayList<>();

    public DepartmentsService() {
        departments.add(new Department(1, "First Department", "First Department description"));
        departments.add(new Department(2, "Second Department", "Second Department description"));
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public List<Department> getAllDepartments() {
        return departments;
    }

    public Department getDepartmentById(String id) {
        for (Department departmentInList : departments) {
            if (departmentInList.getId() == Integer.parseInt(id)) {
                return departmentInList;
            }
        }
        return null;
//        return departments.stream()
//                .filter(department -> department.getId() == Integer.parseInt(id))
//                .findFirst().orElse(null);
    }

    public void updateDepartment(Department department) {
        for (Department departmentInList : departments) {
            if (departmentInList.getId() == department.getId()) {
               departmentInList.setName(department.getName());
               departmentInList.setDescription(department.getDescription());
            }
        }
    }
}