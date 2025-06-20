package com.example.employee.Service;


import com.example.employee.Model.Address;
import com.example.employee.Model.Employee;
import com.example.employee.Repository.Addressrepo;
import com.example.employee.Repository.CustomEmployeeRepository;
import com.example.employee.Repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    EmpRepository empRepository;


    public  Employee saveEmpDetails(Employee employee){
        return empRepository.save(employee);
    }

    public List<Employee> getAllEmp (){
            return (List<Employee> )empRepository.findAll();
    }

    public Employee getByID(int id){
        return empRepository.findById(id);
    }

    public Employee updateDetail (Employee employee){
        return empRepository.save(employee);
    }

    public void deleteEmp(int id){
         empRepository.deleteById(id);
    }

    public List<Employee> getByRole(String role){
        return empRepository.findByRole(role);
    }

    public List<Employee> getBySalaryGreaterThan(double salary){
        return empRepository.findEmployeeWithSalaryGreaterThan(salary);
    }

    public List<Employee> getByAgeLessThan(int age){
        return empRepository.findEmployeeWithAgeLessThanSomething(age);
    }

    public List<Employee> getByName(String name){
        return empRepository.findByName(name);
    }

    public List<Employee> getByMinSalary(double minSalary){
        return empRepository.getEmployeesByMinSalary(minSalary);
    }

}
