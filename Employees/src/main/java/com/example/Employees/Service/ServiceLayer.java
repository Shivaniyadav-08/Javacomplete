package com.example.Employees.Service;

import com.example.Employees.Model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLayer {

    @Autowired
    RedisTemplate redisTemplate;


    public static final String HashKey = "Employees";

    public Employees saveEmp(Employees employees){

       // employeeRepo.save(employees);
         redisTemplate.opsForHash().put(HashKey, employees.getEmp_id(),employees);
         return employees;
    }

    public List<Employees> getAll(){
        return redisTemplate.opsForHash().values(HashKey);
    }

    public Employees getById(int id){
        System.out.println("Hello I'm getting employee id");
        Object o= redisTemplate.opsForHash().get(HashKey,id);
        return (Employees) o;
    }

    public Employees updateData(Employees employees){
        redisTemplate.opsForHash().put(HashKey,employees.getEmp_id(),employees);
        return employees;
    }

    public String deleteEmp (int id){
        redisTemplate.opsForHash().delete(HashKey,id);
        return "Delete User of given Id";
    }
}
