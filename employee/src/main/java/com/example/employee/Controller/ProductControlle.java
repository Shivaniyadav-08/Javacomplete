package com.example.employee.Controller;

import com.example.employee.Model.Product;
import com.example.employee.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductControlle {

    @Autowired
    ProductService productService;

    @PostMapping("/addData")
    public Product save(@RequestBody Product product){
        return  productService.save(product);
    }

    @GetMapping("/getData")
    public List<Object> getAll(){
        return  productService.findAll();
    }

    @GetMapping("/getData/{id}")
    public Product getById(@PathVariable int id){
        return productService.findByID(id);
    }





  /*  @PostMapping("/addData/{key}")
    public Product saveData(@PathVariable("key") String key, @RequestBody Product value){
      return    productService.saveProductDetails(key,value);

    }

    @GetMapping("/getData/{key}")
    public Object getData(@PathVariable("key") String key){
        return productService.getData(key);
    }*/

}
