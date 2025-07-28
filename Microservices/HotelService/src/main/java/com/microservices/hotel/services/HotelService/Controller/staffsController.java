package com.microservices.hotel.services.HotelService.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class staffsController {

    @GetMapping
    public ResponseEntity<List<String>> getstaffs(){
        List<String> list = Arrays.asList("Shivani", "Nishu", "Anu","Abhi");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
