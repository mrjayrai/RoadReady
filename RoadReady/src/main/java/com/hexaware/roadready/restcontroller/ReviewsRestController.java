package com.hexaware.roadready.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.entities.Reviews;
import com.hexaware.roadready.services.IReviewsService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewsRestController {
	
	@Autowired
	IReviewsService reviewService;
	
	@GetMapping("/all/reviews")
	private List<Reviews> getAllReviews(){
		return reviewService.getAllReviews();
	}
	
	@GetMapping("/review/{reviewId}")
	private List<Reviews> getReviewById(@PathVariable int reviewId){
		return reviewService.getReviewById(reviewId);
	}
	
	@GetMapping("/review/booking/{bookingId}")
	private List<Reviews> getReviewByBookingId(@PathVariable int bookingId){
		return reviewService.getReviewsByBookingId(bookingId);
	}
	
	@GetMapping("/review/user/{userId}")
	private List<Reviews> getReviewByUserId(@PathVariable int userId){
		return reviewService.getReviewsByUserId(userId);
	}
	
	@PostMapping("/add")
	private Reviews addReview(@RequestBody Reviews review) {
		return reviewService.addReview(review);
	}
	
	@PutMapping("/update")
	private Reviews updateReview(@RequestBody Reviews review) {
		return reviewService.updateReview(review);
	}
	
	@DeleteMapping("/delete/{reviewId}")
	private void deleteReview(@PathVariable int reviewId) {
		reviewService.deleteReview(reviewId);
	}
}
