package com.example.employee.Service;

import com.example.employee.Configuration.RedisConfig;
import com.example.employee.Model.Product;
import com.example.employee.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;


  //  public static final String Hash_key  = "Product";
    public Product save(Product product){
         redisTemplate.opsForHash().put("Product", product.getId(),product);
        // productRepository.save(product);
         return product;
    }

    public List<Object> findAll(){
        return redisTemplate.opsForHash().values("Product");

    }

    public Product findByID(int id){
        System.out.println("called findProductById() from DB");

        Object o= redisTemplate.opsForHash().get("Product",id);
        return (Product) o;
    }






   /* public Product saveProductDetails(String key, Product value){
         redisTemplate.opsForValue().set(key,value);
         return  productRepository.save(value);

    }

    public Product getData(String key){
        Object o = redisTemplate.opsForValue().get(key);
        if(o != null){
            return (Product)o;
        }
        return productRepository.findByName(key);
    }*/
}
