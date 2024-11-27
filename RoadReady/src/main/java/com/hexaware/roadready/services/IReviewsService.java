package com.hexaware.roadready.services;
/*
 * Author:Rajeshwari
 * Description: Service Interface for Reviews
 * Date:12-11-2024
 */
import java.util.List;
import java.util.Optional;

import com.hexaware.roadready.dto.ReviewDTO;
import com.hexaware.roadready.entities.Reviews;

public interface IReviewsService {
	// Add a new review for a booking
    Reviews addReview(ReviewDTO reviewDto);

    // Update an existing review (by reviewId)
    Reviews updateReview(ReviewDTO review);

    // Delete a review by its ID
    void deleteReview(int reviewId);

    // Fetch a review by its ID
    Reviews getReviewById(int reviewId);

    // Fetch all reviews for a specific booking
    List<Reviews> getReviewsByBookingId(int bookingId);

    // Fetch all reviews made by a specific user
    List<Reviews> getReviewsByUserId(int userId);

    // Fetch all reviews in the system (for admin use)
    List<Reviews> getAllReviews();
    

}
