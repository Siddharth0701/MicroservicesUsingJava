package com.redlabel.user.service.external.services;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.google.common.base.Objects;
import com.redlabel.user.service.entities.Rating;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    // get

    // post

    @PostMapping("api/rating")
    Rating createRating(Rating values);

    // delete
    @DeleteMapping("api/rating/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);

    // update
    @PutMapping("api/rating/{ratingId}")
    Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);
}
