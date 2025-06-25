package com.example.employee.Service;


import com.example.employee.Logger.CustomLogger;
import com.example.employee.Logger.CustomLoggerFactory;
import com.example.employee.Model.Address;
import com.example.employee.Model.Employee;
import com.example.employee.Repository.Addressrepo;
import com.example.employee.Repository.CustomEmployeeRepository;
import com.example.employee.Repository.EmpRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    private  static final Logger logger = (Logger) LoggerFactory.getLogger(EmpService.class);
    private static final CustomLogger logger1 = CustomLoggerFactory.getLogger(EmpService.class);

    public void example(){
        logger1.info("Custom logger Createdd");
    }

    @Autowired
    EmpRepository empRepository;


    public  Employee saveEmpDetails(Employee employee){
        logger1.info("Saving employee to DB: {}ssssssssssssssssssssssssssssssssssss------------------");
        return empRepository.save(employee);
    }

    public List<Employee> getAllEmp (){
        logger.debug("Fetching data");

        return (List<Employee> )empRepository.findAll();
    }

    public Employee getByID(int id){
        return empRepository.findById(id);
    }

    public Employee updateDetail (Employee employee){
        return empRepository.save(employee);
    }

    public void deleteEmp(int id){
        logger.warn("Deleting employee from DB with ID: {}", id);
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
