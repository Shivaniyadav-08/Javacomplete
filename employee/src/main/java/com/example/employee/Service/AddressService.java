package com.example.employee.Service;

import com.example.employee.Model.Address;
import com.example.employee.Repository.Addressrepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressService {
    @Autowired
    Addressrepo addressrepo;
    public List<Address> getAddressByCityAndStree(String street, String city) {
        return addressrepo.findByStreetAndCity(street,city);
    }
}
