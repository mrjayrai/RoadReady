package com.hexaware.roadready.services;
/*
 * Author : Rajeshwari
 * Description : Service Implementation for Reviews
 * Date: 17-11-2024
 */
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.ReviewDTO;
import com.hexaware.roadready.entities.Bookings;
import com.hexaware.roadready.entities.Reviews;
import com.hexaware.roadready.entities.Users;
import com.hexaware.roadready.exceptions.NotFoundException;
import com.hexaware.roadready.repositories.ReviewsRepository;
@Service
public class ReviewsServiceImp implements IReviewsService {
	
	@Autowired
	ReviewsRepository reviewRepository;
	Logger logger =	   LoggerFactory.getLogger(ReviewsServiceImp.class);

	@Override
	public Reviews addReview(ReviewDTO review) {
		// TODO Auto-generated method stub
//		logger.info("New Review Details added");
//		return reviewRepository.save(review);
		Reviews addReview=new Reviews();
		int bookingId=review.getBookingId();
		Bookings booking=new Bookings(bookingId);
		addReview.setBooking(booking);
		int userId=review.getUserId();
		Users user=new Users(userId);
		addReview.setUser(user);
		addReview.setRating(review.getRating());
		addReview.setReviewText(review.getReviewText());
		addReview.setReviewDate(review.getReviewDate());
		return reviewRepository.save(addReview);
		
	}
	

	@Override
	public Reviews updateReview(ReviewDTO review) {
		// TODO Auto-generated method stub
		logger.info("Review Details Updated");
		Reviews addReview=new Reviews();
		int reviewId=review.getReviewId();
		int bookingId=review.getBookingId();
		Bookings booking=new Bookings(bookingId);
		addReview.setBooking(booking);
		int userId=review.getUserId();
		Users user=new Users(userId);
		addReview.setUser(user);
		addReview.setRating(review.getRating());
		addReview.setReviewText(review.getReviewText());
		addReview.setReviewDate(review.getReviewDate());
		return reviewRepository.save(addReview);
	}

	@Override
	public void deleteReview(int reviewId) {
		// TODO Auto-generated method stub
		logger.error("Review details deleted");
		reviewRepository.deleteByReviewId(reviewId);

	}

	@Override
	public Reviews getReviewById(int reviewId) {
		// TODO Auto-generated method stub
		Reviews review=reviewRepository.findByReviewId(reviewId);
		logger.info("Review get by review Id");
		if(review != null) {
			return review;
		}
		else {
			logger.error("Review not found for review id");
			throw new NotFoundException("No Review found for reviewId: " + reviewId);
		}
	}

	@Override
	public List<Reviews> getReviewsByBookingId(int bookingId) {
		// TODO Auto-generated method stub
		List<Reviews> review = reviewRepository.findByBooking_bookingId(bookingId);
		logger.info("Review get by booking Id");
		if(review.isEmpty()) {
			logger.error("Review not found for given booking id");

			throw new NotFoundException("No Review found for booking: " + bookingId);
		}
		return review;
	}

	@Override
	public List<Reviews> getReviewsByUserId(int userId) {
		// TODO Auto-generated method stub
		logger.info("Review get by user Id");
		List<Reviews> review = reviewRepository.findByUser_userId(userId);
		if(review.isEmpty()) {
			logger.error("Review not found for given user id");

			throw new NotFoundException("No Review found for User: " + userId);
		}
		return review;
	}

	@Override
	public List<Reviews> getAllReviews() {
		// TODO Auto-generated method stub
		logger.info("All review details received");
		return reviewRepository.findAll();
	}



}
