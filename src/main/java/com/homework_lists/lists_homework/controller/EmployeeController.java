package com.homework_lists.lists_homework.controller;

import com.homework_lists.lists_homework.employee.Employee;
import com.homework_lists.lists_homework.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public void addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
         employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public void removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
         employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public void findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/list")
    public List<Employee> listEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping
    public String hello() {
        return "Hello, world!";
    }
}
