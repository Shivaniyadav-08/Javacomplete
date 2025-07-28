package com.microservices.user.service.UserService.entity;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    private int ratingId;
    private  int userId;
    private int hotelId;
    private int rating;
    private String feedback;

    private Hotel hotel;
}
