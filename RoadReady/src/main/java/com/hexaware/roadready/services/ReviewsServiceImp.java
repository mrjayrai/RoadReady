package com.hexaware.roadready.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hexaware.roadready.entities.Reviews;
import com.hexaware.roadready.repositories.ReviewsRepository;

public class ReviewsServiceImp implements IReviewsService {
	
	@Autowired
	ReviewsRepository reviewRepository;

	@Override
	public Reviews addReview(Reviews review) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reviews updateReview(Integer reviewId, String reviewText, int rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReview(Integer reviewId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Reviews> getReviewById(Integer reviewId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Reviews> getReviewsByBookingId(Integer bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reviews> getReviewsByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reviews> getAllReviews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getAverageRatingByCarId(Integer carId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasUserReviewedBooking(Integer userId, Integer bookingId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Reviews> getRecentReviews(int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
