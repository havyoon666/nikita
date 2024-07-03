package com.example.nikita.dema.controllers;

import com.example.nikita.dema.models.Department;
import com.example.nikita.dema.services.DepartmentsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DepartmentsController {

    private DepartmentsService departmentsService;

    public DepartmentsController() {
        this.departmentsService = new DepartmentsService();
    }

    @GetMapping("/")
    public String homePage(Model model) {
        List<Department> allDepartments = departmentsService.getAllDepartments();
        model.addAttribute("departments", allDepartments);
        return "departments";
    }

    @GetMapping("/edit-department/{id}")
    public String goToEditDepartment(@PathVariable String id, Model model) {
        model.addAttribute("department", departmentsService.getDepartmentById(id));
        return "editDepartment";
    }

    @PostMapping("/save-department")
    public String updateDepartment(Department department) {
        departmentsService.updateDepartment(department);
        return "departments";
    }

}