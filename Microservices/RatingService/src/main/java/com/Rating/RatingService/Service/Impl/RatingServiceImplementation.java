package com.Rating.RatingService.Service.Impl;

import com.Rating.RatingService.Entity.Rating;
import com.Rating.RatingService.RatingRepository.RatingRepo;
import com.Rating.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImplementation implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating save(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getByUserid(int userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getByHotelID(int hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }
}
