package com.example.employee.Repository;

import com.example.employee.Model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer>{

    Product findByName(String name);
}



