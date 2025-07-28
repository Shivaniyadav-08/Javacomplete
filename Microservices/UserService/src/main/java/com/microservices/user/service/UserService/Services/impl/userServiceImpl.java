package com.microservices.user.service.UserService.Services.impl;

import com.microservices.user.service.UserService.Exception.ResourceNotFoundException;
import com.microservices.user.service.UserService.External.Service.Hotelservice;
import com.microservices.user.service.UserService.Repository.userRepo;
import com.microservices.user.service.UserService.Services.userService;
import com.microservices.user.service.UserService.entity.Hotel;
import com.microservices.user.service.UserService.entity.Rating;
import com.microservices.user.service.UserService.entity.UsersData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Hotelservice hotelservice;

    @Override
    public UsersData saveUser(UsersData users) {
        return userRepo.save(users);
    }

    @Override
    public List<UsersData> getAll() {
        return userRepo.findAll();
    }

    @Override
    public UsersData getByID(int id) {
        UsersData usersData = userRepo.findById(id).orElseThrow( ()-> new ResourceNotFoundException("User not Found!!! " + id));
         // from here we are calling rating service
        //fetch  rating   of above user from rating service with the help of rest template
        //localhost:8082/rating/users/2
        Rating[] ratingOfUsers = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/" + usersData.getId(), Rating[].class);

        List<Rating> ratings = Arrays.stream(ratingOfUsers).toList();/// converting rating arr into list

        List<Rating> ratingList = ratings.stream().map(rating-> {
            // api call to hotel service to get rating from restTemplate
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/get/" + rating.getRatingId(), Hotel.class);
           // Hotel hotel = forEntity.getBody();
            // now api call hotel service using feign client

            Hotel hotel = hotelservice.getHotel(rating.getHotelId());
            // set  hotel rating
            rating.setHotel(hotel);
            // return rating
            return rating;
        }).collect(Collectors.toList());


        usersData.setRatingList(ratingList);
        return usersData;
    }

    @Override
    public UsersData updateUser(UsersData users) {
        return userRepo.save(users);
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }
}
