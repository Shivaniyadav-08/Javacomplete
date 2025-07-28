package com.microservices.hotel.services.HotelService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  int hotelId;
    private String hotelName;
    private String address;
    private String about;


}
