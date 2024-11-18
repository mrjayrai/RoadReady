package com.hexaware.roadready.services;
/*
 * Author : Rajeshwari
 * Description : Unit testing for Review service Implementation
 * Date: 17-11-2024
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.entities.Bookings;
import com.hexaware.roadready.entities.Reviews;
import com.hexaware.roadready.entities.Users;
@SpringBootTest
class ReviewsServiceImpTest {
	
	@Autowired
	IReviewsService reviewService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testAddReview() {
		Users user=new Users(101);
		Bookings booking=new Bookings(1);
		Reviews review=new Reviews(5,5,"Great Service",LocalDateTime.now(),user,booking);
		Reviews reviewCheck=reviewService.addReview(review);
		assertNotNull(review);
	}

	@Test
	void testUpdateReview() {
//		fail("Not yet implemented");
		Users user=new Users(101);
		Bookings booking=new Bookings(1);
		Reviews review=new Reviews(5,4,"Great and Satisfied Service",LocalDateTime.now(),user,booking);
		Reviews reviewCheck=reviewService.updateReview(review);
		assertNotNull(reviewCheck);
	}

	@Test
	void testDeleteReview() {
//		fail("Not yet implemented");
		Reviews review=new Reviews(11);
		int reviewId=11;
		review.setReviewId(reviewId);
		reviewService.deleteReview(reviewId);
		assertEquals(review.getReviewId(),11);
	}

	@Test
	void testGetReviewById() {
		List<Reviews> reviewList=null;
		reviewList=reviewService.getAllReviews();
		assertNotNull(reviewList);
	}

	@Test
	void testGetReviewsByBookingId() {
//		fail("Not yet implemented");
		int bookingId=1;
		Reviews review=new Reviews();
		List<Reviews> reviewList=null;
	    reviewList=reviewService.getReviewsByBookingId(bookingId);
	    assertNotNull(reviewList);
	}

	@Test
	void testGetReviewsByUserId() {
//		fail("Not yet implemented");
		int userId=101;
		Reviews review=new Reviews();
		List<Reviews> reviewList=null;
	    reviewList=reviewService.getReviewsByUserId(userId);
	    assertNotNull(reviewList);
	}

	@Test
	void testGetAllReviews() {
//		fail("Not yet implemented");
		List<Reviews> reviewList=null;
		reviewList=reviewService.getAllReviews();
		assertNotNull(reviewList);
		
	}

}
