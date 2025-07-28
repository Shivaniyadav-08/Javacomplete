package com.microservices.hotel.services.HotelService.Controller;


import com.microservices.hotel.services.HotelService.Entity.Hotel;
import com.microservices.hotel.services.HotelService.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/hotels")
public class hotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/save")
    public ResponseEntity<Hotel> save(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.create(hotel);
      return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List> getAll(){
        List<Hotel> hotels = hotelService.getAll();
        return  ResponseEntity.ok(hotels);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Hotel> getByID(@PathVariable int id){
        Hotel hotel = hotelService.getBYId(id);
        return  ResponseEntity.ok(hotel);
    }
}
