package com.hexaware.roadready.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.entities.Reviews;
import com.hexaware.roadready.exceptions.NotFoundException;
import com.hexaware.roadready.repositories.ReviewsRepository;
@Service
public class ReviewsServiceImp implements IReviewsService {
	
	@Autowired
	ReviewsRepository reviewRepository;

	@Override
	public Reviews addReview(Reviews review) {
		// TODO Auto-generated method stub
		return reviewRepository.save(review);
	}

	@Override
	public Reviews updateReview(Reviews review) {
		// TODO Auto-generated method stub
		return reviewRepository.save(review);
	}

	@Override
	public void deleteReview(int reviewId) {
		// TODO Auto-generated method stub
		reviewRepository.deleteByReviewId(reviewId);

	}

	@Override
	public Reviews getReviewById(int reviewId) {
		// TODO Auto-generated method stub
		
		return reviewRepository.findByReviewId(reviewId);
	}

	@Override
	public List<Reviews> getReviewsByBookingId(int bookingId) {
		// TODO Auto-generated method stub
		List<Reviews> review = reviewRepository.findByBooking_bookingId(bookingId);
		if(review.isEmpty()) {
			throw new NotFoundException("No Review found for booking: " + bookingId);
		}
		return review;
	}

	@Override
	public List<Reviews> getReviewsByUserId(int userId) {
		// TODO Auto-generated method stub
		return reviewRepository.findByUser_userId(userId);
	}

	@Override
	public List<Reviews> getAllReviews() {
		// TODO Auto-generated method stub
		return reviewRepository.findAll();
	}



}
