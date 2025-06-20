package com.example.employee.Repository;

import com.example.employee.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Addressrepo extends JpaRepository<Address,Integer> {
    List<Address> findByStreetAndCity(String street, String city);

}
