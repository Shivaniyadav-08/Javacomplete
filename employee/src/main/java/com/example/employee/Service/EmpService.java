package com.example.employee.Service;


import com.example.employee.Model.Employee;
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




}
