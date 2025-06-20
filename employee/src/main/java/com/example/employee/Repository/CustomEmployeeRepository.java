package com.example.employee.Repository;

import com.example.employee.Model.Employee;

import java.util.List;

public interface CustomEmployeeRepository {
    List<Employee> findByName(String name);
}
