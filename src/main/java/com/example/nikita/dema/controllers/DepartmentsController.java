package com.example.nikita.dema.controllers;

import com.example.nikita.dema.models.Department;
import com.example.nikita.dema.models.Employee;
import com.example.nikita.dema.services.DepartmentsService;
import com.example.nikita.dema.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
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
        model.addAttribute("departmentId", depId);
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
    @GetMapping("/add-employee/{departmentId}")
    public String goToAddEmployee(@PathVariable Integer departmentId, Model model){
        Employee employee = new Employee();
        employee.setDepartmentId(departmentId);
        model.addAttribute("employee", employee);
        return "addEmployee";
    }


    @PostMapping("/save-department")
    public String saveEmpployee(Department department, Model model) {
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

    @GetMapping("/edit-employee/{id}")
    public String goToEditEmployee(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "editEmployee";

    }
    @PostMapping("/save-employee")
    public String updateEmployee(Employee employee, Model model) {
        if (employee.getId()==0){
           employeeService.addEmployee(employee);

        }
        else{
           employeeService.updateEmployee(employee);


        }

        List<Employee> allEmployees = employeeService.getEmployeesByDepartment(employee.getDepartmentId());
        model.addAttribute("departmentId", employee.getDepartmentId() );
        model.addAttribute("employees", allEmployees);
        return "employees";
    }
        @GetMapping  ("/delete-department/{id}")
    public String deleteDepartment(@PathVariable int id, Model model) {
        departmentsService.deleteDepartment(id);
        List<Department> allDepartments = departmentsService.getAllDepartments();
        model.addAttribute("departments", allDepartments);
        return "departments";
    }
    @GetMapping  ("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
       employeeService.deleteEmployee(id);
        List<Employee> allEmployees = employeeService.getEmployeesByDepartment(employee.getDepartmentId());
        model.addAttribute("employees", allEmployees);
        return "employees";
    }

    @GetMapping  ("/departments/{id}")
    public String showDepartment(@PathVariable String id, Model model) {
        model.addAttribute("department", departmentsService.getDepartmentById(id));
        return "editDepartment";
    }


}