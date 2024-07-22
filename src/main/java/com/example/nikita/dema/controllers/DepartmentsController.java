package com.example.nikita.dema.controllers;

import com.example.nikita.dema.models.Department;
import com.example.nikita.dema.models.Employee;
import com.example.nikita.dema.services.DepartmentsService;
import com.example.nikita.dema.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepartmentsController {

    @Autowired
    private DepartmentsService departmentsService;
    @Autowired
    private EmployeeService employeeService;

    public DepartmentsController() {
    }


    @GetMapping("/")
    public String homePage(Model model) {
        List<Department> allDepartments = departmentsService.getAllDepartments();
        model.addAttribute("departments", allDepartments);
        return "departments";
    }

    @GetMapping("/show-employees/{depId}")
    public String showEmployees(@PathVariable Integer depId, Model model) {
        List<Employee> allEmployess = employeeService.getEmployeesByDepartment(depId);
        model.addAttribute("employees", allEmployess);
        return "employees";
    }


    @GetMapping("/edit-department/{id}")
    public String goToEditDepartment(@PathVariable String id, Model model) {
        model.addAttribute("department", departmentsService.getDepartmentById(id));
        return "editDepartment";

    }
    @GetMapping("/add-department")
    public String goToAddDepartment(Model model) {
        model.addAttribute("department", new Department());
        return "addDepartment";
    }
    @GetMapping("/add-employee")
    public String goToAddEmployee(Model model){
        Employee employee = new Employee();
        employee.setDepartmentId(1);
        model.addAttribute("employee", employee);
        return "addEmployee";
    }


    @PostMapping("/save-department")
    public String updateDepartment(Department department, Model model) {
        if (department.getId()==0){
            departmentsService.addDepartment(department);

        }
        else{
            departmentsService.updateDepartment(department);


        }

        List<Department> allDepartments = departmentsService.getAllDepartments();
        model.addAttribute("departments", allDepartments);
        return "departments";
    }
    @PostMapping("/save-employee")
    public String updateDepartment(@ModelAttribute Employee employee, Model model) {
       employeeService.addEmployee(employee);

        List<Department> allDepartments = departmentsService.getAllDepartments();
        model.addAttribute("departments", allDepartments);
        return "departments";
    }

    @GetMapping  ("/delete-department/{id}")
    public String deleteDepartment(@PathVariable int id, Model model) {
        departmentsService.deleteDepartment(id);
        List<Department> allDepartments = departmentsService.getAllDepartments();
        model.addAttribute("departments", allDepartments);
        return "departments";
    }

    @GetMapping  ("/departments/{id}")
    public String showDepartment(@PathVariable String id, Model model) {
        model.addAttribute("department", departmentsService.getDepartmentById(id));
        return "editDepartment";
    }


}