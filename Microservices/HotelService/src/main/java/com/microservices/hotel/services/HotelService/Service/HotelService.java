package com.microservices.hotel.services.HotelService.Service;

import com.microservices.hotel.services.HotelService.Entity.Hotel;

import java.util.List;

public interface HotelService {

    // add
    Hotel create(Hotel hotel);

    //getall
    List<Hotel> getAll();

    //by id
    Hotel getBYId(int id);
}
