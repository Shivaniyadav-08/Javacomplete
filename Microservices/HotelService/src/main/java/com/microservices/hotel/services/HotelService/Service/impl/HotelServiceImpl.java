package com.microservices.hotel.services.HotelService.Service.impl;

import com.microservices.hotel.services.HotelService.Entity.Hotel;
import com.microservices.hotel.services.HotelService.Exception.ResourceNotFoundException;
import com.microservices.hotel.services.HotelService.Repository.HotelRepository;
import com.microservices.hotel.services.HotelService.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
   private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getBYId(int id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel not found"+  id));
    }
}
