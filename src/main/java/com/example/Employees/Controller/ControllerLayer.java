package com.example.Employees.Controller;

import com.example.Employees.Model.Employees;
import com.example.Employees.Service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employees")
@EnableCaching
public class ControllerLayer {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping("/save")
    public Employees saveData(@RequestBody Employees employees){
        serviceLayer.saveEmp(employees);
        return employees;
    }

    @GetMapping("/getAllEmployees")
    public List<Employees> getAllEmp(){
        return serviceLayer.getAll();
    }


    @GetMapping("/getAllEmployees/{id}")
    @Cacheable(key = "#id", value = "Employees")
    public Employees getById(@PathVariable int id){
        return serviceLayer.getById(id);
    }

    @PutMapping("/updateEmployee")
    public Employees updateEmpData(@RequestBody  Employees employees){
        return serviceLayer.updateData(employees);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    @CacheEvict(key = "#id", value =  "Employees")
    public String remove(@PathVariable int id){
        return serviceLayer.deleteEmp(id);
    }
}
