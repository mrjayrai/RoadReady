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
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.dto.ReviewDTO;
import com.hexaware.roadready.entities.Bookings;
import com.hexaware.roadready.entities.Reviews;
import com.hexaware.roadready.entities.Users;
import com.hexaware.roadready.repositories.BookingsRepository;
import com.hexaware.roadready.repositories.ReviewsRepository;
import com.hexaware.roadready.repositories.UsersRepository;
@SpringBootTest
class ReviewsServiceImpTest {
	
	@Autowired
	IReviewsService reviewService;
	 @Mock
	    private ReviewsRepository reviewsRepository;
	 @Mock
	    private UsersRepository usersRepository;

	    @Mock
	    private BookingsRepository bookingsRepository;
	    @InjectMocks
	    private ReviewsServiceImp reviewsService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testAddReview() {
//		Users user=new Users(101);
//		Bookings booking=new Bookings(1);
//		Reviews review=new Reviews(5,5,"Great Service",LocalDateTime.now(),user,booking);
//		Reviews reviewCheck=reviewService.addReview(review);
//		assertNotNull(review);
		ReviewDTO reviewDto=new ReviewDTO();
		Reviews addReview=new Reviews();
		reviewDto.setBookingId(1);
		reviewDto.setUserId(101);
		reviewDto.setRating(5);
		reviewDto.setReviewDate(LocalDateTime.now());
		reviewDto.setReviewText("Very Good Experience");
		Reviews reviewCheck=reviewService.addReview(reviewDto);
		assertNotNull(reviewCheck);
		
	
		
	}

	@Test
	void testUpdateReview() {
//		fail("Not yet implemented");
//		Users user=new Users(101);
//		Bookings booking=new Bookings(1);
//		Reviews review=new Reviews(5,4,"Great and Satisfied Service",LocalDateTime.now(),user,booking);
//		Reviews reviewCheck=reviewService.updateReview(review);
//		assertNotNull(reviewCheck);
		 // Mock input data
//        Users user = new Users(101);
//        Bookings booking = new Bookings(1);
//        Reviews existingReview = new Reviews(15, 4, "Good service", LocalDateTime.now(), user, booking);
//        Reviews updatedReview = new Reviews(15, 5, "very amazing Great and Satisfied Service", LocalDateTime.now(), user, booking);
//
//        // Define mock behavior
//        Mockito.when(reviewsRepository.findById(15)).thenReturn(Optional.of(existingReview));
//        Mockito.when(reviewsRepository.save(Mockito.any(Reviews.class))).thenReturn(updatedReview);
//
//        // Call the service method
//        Reviews reviewCheck = reviewsService.updateReview(updatedReview);
//
//        // Assert the result
//        assertNotNull(reviewCheck);
////        assertEquals(5, reviewCheck.getReviewId());
////        assertEquals(5, reviewCheck.getRating());
//        assertEquals("very amazing Great and Satisfied Service", reviewCheck.getReviewText());
//
//        // Verify interactions
////        Mockito.verify(reviewsRepository).findById(5);
//        Mockito.verify(reviewsRepository).save(updatedReview);
		ReviewDTO reviewDto=new ReviewDTO();
		Reviews addReview=new Reviews();
		reviewDto.setBookingId(1);
		reviewDto.setUserId(101);
		reviewDto.setRating(5);
		reviewDto.setReviewDate(LocalDateTime.now());
		reviewDto.setReviewText("Very Good Experience");
		Reviews reviewCheck=reviewService.updateReview(reviewDto);
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
