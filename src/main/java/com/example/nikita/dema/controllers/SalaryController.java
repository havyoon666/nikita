package com.example.nikita.dema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/salary")  // Base path for this controller
public class SalaryController {

    @GetMapping("/calculate/{id}/{depId}/{age}")  // Path after /salary
    public String calculate(@PathVariable Integer id, @PathVariable Integer depId, @PathVariable Integer age) {
        // Add any calculation logic here if needed
        return "employees";  // View name to return
    }
}
