package com.microservices.user.service.UserService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private  int hotelId;
    private String hotelName;
    private String address;
    private String about;
}
