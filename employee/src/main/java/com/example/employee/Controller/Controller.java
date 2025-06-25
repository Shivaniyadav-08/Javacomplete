package com.example.employee.Controller;

import com.example.employee.Model.Employee;
import com.example.employee.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    EmpService empService;

    @PostMapping("/save/emp-details")
    public Employee saveEmpDetails( Employee employee){
        Employee emp = empService.saveEmpDetails(employee);
        return emp;
    }

//    sdgdsgdfgfggdf

    @GetMapping("/get/emp-details")
    public List<Employee> getAllEmp (){
        List<Employee> employeeList = empService.getAllEmp();
        return  employeeList;
    }

    @GetMapping("/get/_EmpDetails/{id}")

    public Employee getByID(int id){
        Employee empId = empService.getByID(id);
        return empId;
    }

    @PutMapping("/update/_EmpDetails")
    public Employee updateDetail(Employee employee){
        Employee emp1 = empService.updateDetail(employee);
        return emp1;
    }

    @DeleteMapping("/delete/_EmpDetails")
    public void deleteEmp (int id){
        empService.deleteEmp(id);
    }
}
