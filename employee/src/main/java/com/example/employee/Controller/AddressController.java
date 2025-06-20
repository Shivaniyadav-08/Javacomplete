package com.example.employee.Controller;

import com.example.employee.Model.Address;
import com.example.employee.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class AddressController {

    @Autowired
    AddressService addressService;
    @GetMapping
    public ResponseEntity<?> listofAddress(@RequestParam("street") String street, @RequestParam("city") String city) {
        List<Address> addressByCityAndStree = addressService.getAddressByCityAndStree(street, city);
        if (addressByCityAndStree != null) {
            return ResponseEntity.ok(addressByCityAndStree);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
