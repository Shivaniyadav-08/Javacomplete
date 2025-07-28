package com.microservices.user.service.UserService.Controller;


import com.microservices.user.service.UserService.Services.userService;
import com.microservices.user.service.UserService.entity.UsersData;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/api")
public class userController {

    @Autowired
    private  userService userService;
    // create user
    @PostMapping("/save")
    public ResponseEntity<UsersData> saveUser(@RequestBody UsersData users){
        UsersData users1 = userService.saveUser(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(users1);

    }

    @GetMapping("/getAll")
    public  ResponseEntity<List<UsersData>> getAll(){
      List  <UsersData> users = userService.getAll();
      return ResponseEntity.ok(users);

    }
//int retryCount=1;
    @GetMapping("/get/{id}")
    @CircuitBreaker(name = "ratingHotelService" , fallbackMethod = "ratingHotelfallback")
   // @Retry(name = "ratingHotelService" , fallbackMethod = "ratingHotelfallback")
    // @RateLimiter(name = "UserRateLimiter",fallbackMethod = "ratingHotelfallback")
    public ResponseEntity<UsersData> getById(@PathVariable int id){
        //retryCount++;
       // System.out.println(retryCount);
        UsersData users =  userService.getByID(id);
        return ResponseEntity.ok(users);
    }


// creating fallback method...if any service is down if will execute fall abck method
    public ResponseEntity<UsersData> ratingHotelfallback(int id, Exception ex){
        ex.printStackTrace();
        UsersData usersData = UsersData.builder()
                .email("dummy@gmail.com").about("I'm dummy Output , because some service is down")
                .name("dummy")
                .id(1111)
                .build();
        return new ResponseEntity<>(usersData, HttpStatus.BAD_REQUEST);
    }



}
