package com.Rating.RatingService.Service;

import com.Rating.RatingService.Entity.Rating;

import java.util.List;

public interface RatingService {

    Rating save(Rating rating);

    List<Rating> getAll();

    List<Rating> getByUserid(int userId);

    List<Rating> getByHotelID(int hotelId);
}
