package com.example.employee.Controller;

import com.example.employee.Model.Address;
import com.example.employee.Model.Employee;
import com.example.employee.Repository.Addressrepo;
import com.example.employee.Service.EmpService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    EmpService empService;

    @PostMapping("/save/emp-details")
    public Employee saveEmpDetails( @RequestBody Employee employee){
        Employee emp = empService.saveEmpDetails(employee);
        return emp;
    }

    @GetMapping("/get/emp-details")
    public List<Employee> getAllEmp (){
        List<Employee> employeeList = empService.getAllEmp();
        return  employeeList;
    }

    @GetMapping("/get/emp-details/{id}")

    public Employee getByID(@PathVariable int id){
        Employee empId = empService.getByID(id);
        return empId;
    }

    @PutMapping("/update/emp-details")
    public Employee updateDetail(@RequestBody Employee employee){
        Employee emp1 = empService.updateDetail(employee);
        return emp1;
    }

    @DeleteMapping("/delete/emp-details/{id}")
    public void deleteEmp (@PathVariable int id){
        empService.deleteEmp(id);
    }

    @GetMapping("/get/emp-details/role/{role}")
    public ResponseEntity<List<Employee>> getByRole(@PathVariable String role){
        //return new ResponseEntity<>(empService.getByRole(role), HttpStatus.OK);
        return ResponseEntity.ok(empService.getByRole(role));
    }

    @GetMapping("/get/emp-details/salary/{salary}")
    public ResponseEntity<List<Employee>> getBySalaryEmployeeGreater(@PathVariable double salary){
        return ResponseEntity.ok (empService.getBySalaryGreaterThan(salary));
    }


    @GetMapping("/get/emp-details/age/{age}")
    public ResponseEntity<List<Employee>> getByAgeLessThan(@PathVariable int age) {
        return ResponseEntity.ok(empService.getByAgeLessThan(age));
    }

    @GetMapping("/get/emp-details/name/{name}")
    public ResponseEntity<List<Employee>> getByName(@PathVariable  String name){
        return ResponseEntity.ok(empService.getByName(name));
    }
    @GetMapping("/get/emp-details/minSalary/{minSalary}")
    public ResponseEntity<List<Employee>> getByMinSalary(@PathVariable double minSalary){
        return ResponseEntity.ok(empService.getByMinSalary(minSalary));
    }

}
