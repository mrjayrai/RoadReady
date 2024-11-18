package com.hexaware.roadready.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.entities.Reviews;
import com.hexaware.roadready.services.IReviewsService;

import jakarta.validation.Valid;

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
	private Reviews getReviewById(@PathVariable int reviewId){
//		Reviews review= null;
//		review=reviewService.getReviewById(reviewId);
//		if(review != null) {
//			return review;
//		}
//		else {
//			throw new NullPointerException();
//		}
		return reviewService.getReviewById(reviewId);
		
	}
//	@ExceptionHandler(NullPointerException.class)
//	@ResponseStatus(reason="Reviews not Found for the particular Id",code=HttpStatus.BAD_REQUEST)
//	
//	public void handleExp1() {//alternate of catch block
//		
//	}
//	
	@GetMapping("/review/booking/{bookingId}")
	private List<Reviews> getReviewByBookingId(@PathVariable int bookingId){
//		List<Reviews> review=new ArrayList<Reviews>();
//		review=reviewService.getReviewsByBookingId(bookingId);
//		if(review.size()!=0) {
//			return review;
//			
//		}
//		else {
//			throw new NullPointerException();
//		}
		return reviewService.getReviewsByBookingId(bookingId);
		
	}
	
	@GetMapping("/review/user/{userId}")
	private List<Reviews> getReviewByUserId(@PathVariable int userId){
//		List<Reviews> review=new ArrayList<Reviews>();
//		review=reviewService.getReviewsByUserId(userId);
//		if(review.size()!=0) {
//			return review;
//			
//		}
//		else {
//			throw new NullPointerException();
//		}
		return reviewService.getReviewsByUserId(userId);
		
	}
	
	@PostMapping("/add")
	private Reviews addReview( @RequestBody @Valid Reviews review) {
		return reviewService.addReview(review);
	}
	
	@PutMapping("/update")
	private Reviews updateReview(@Valid @RequestBody Reviews review) {
		return reviewService.updateReview(review);
	}
	
	@DeleteMapping("/delete/{reviewId}")
	private void deleteReview(@Valid @PathVariable int reviewId) {
		reviewService.deleteReview(reviewId);
	}
}
