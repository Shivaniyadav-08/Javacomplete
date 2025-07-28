package com.microservices.hotel.services.HotelService.Repository;

import com.microservices.hotel.services.HotelService.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
