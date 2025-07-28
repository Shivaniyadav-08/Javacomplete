package com.Rating.RatingService.Controller;

import com.Rating.RatingService.Entity.Rating;
import com.Rating.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class controller {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/save")
    public ResponseEntity<Rating> save(@RequestBody Rating rating){
        Rating rating1 = ratingService.save(rating);
        return  ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    @GetMapping("/get")
    public ResponseEntity<List> getAll(){
        return ResponseEntity.ok(ratingService.getAll());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List> getByuserId(@PathVariable int userId){
        return ResponseEntity.ok(ratingService.getByUserid(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List> getByHotelId(@PathVariable int hotelId){
        return ResponseEntity.ok(ratingService.getByHotelID(hotelId));
    }
}
