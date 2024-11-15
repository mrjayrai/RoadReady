package com.hexaware.roadready.services;

import java.util.List;
import java.util.Optional;

import com.hexaware.roadready.entities.Reviews;

public interface IReviewsService {
	// Add a new review for a booking
    Reviews addReview(Reviews review);

    // Update an existing review (by reviewId)
    Reviews updateReview(Integer reviewId, String reviewText, int rating);

    // Delete a review by its ID
    void deleteReview(Integer reviewId);

    // Fetch a review by its ID
    Optional<Reviews> getReviewById(Integer reviewId);

    // Fetch all reviews for a specific booking
    List<Reviews> getReviewsByBookingId(Integer bookingId);

    // Fetch all reviews made by a specific user
    List<Reviews> getReviewsByUserId(Integer userId);

    // Fetch all reviews in the system (for admin use)
    List<Reviews> getAllReviews();

    // Fetch average rating for a specific car (if linked via bookingId)
    double getAverageRatingByCarId(Integer carId);

    // Check if a user has already reviewed a booking
    boolean hasUserReviewedBooking(Integer userId, Integer bookingId);

    // Fetch top N recent reviews
    List<Reviews> getRecentReviews(int limit);
}
