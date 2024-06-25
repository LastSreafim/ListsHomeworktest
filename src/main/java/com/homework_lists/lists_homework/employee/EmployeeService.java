package com.homework_lists.lists_homework.employee;


import com.homework_lists.lists_homework.exceptions.EmployeeAlreadyAddedException;
import com.homework_lists.lists_homework.exceptions.EmployeeNotFoundException;
import com.homework_lists.lists_homework.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int MAX_EMPLOYEES = 10;
    private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(String firstName, String lastName) {
        //try {
            if (employees.size() >= MAX_EMPLOYEES) {
                throw new EmployeeStorageIsFullException();
            }
            Employee employee = new Employee(firstName, lastName);
            if (employees.contains(employee)) {
                throw new EmployeeAlreadyAddedException("Employee already added");
            }
            employees.add(employee);
      // } catch (EmployeeStorageIsFullException | EmployeeAlreadyAddedException e) {
      //     System.out.println(e.getMessage());
      // }
    }

    public void removeEmployee(String firstName, String lastName) {
        try {
            if (!employees.remove(new Employee(firstName, lastName))) {
                throw new EmployeeNotFoundException("Employee not found");
            }
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean findEmployee(String firstName, String lastName) {
        //try {
            if (!employees.contains(new Employee(firstName, lastName))) {
                throw new EmployeeNotFoundException("Employee not found");
            } else {
                return true;
            }
      // } catch (EmployeeNotFoundException e) {
      //     System.out.println(e.getMessage());
    //}
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}
