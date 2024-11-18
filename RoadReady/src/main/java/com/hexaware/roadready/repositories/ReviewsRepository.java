package com.hexaware.roadready.repositories;
import java.util.List;

/*
 * Author:Rajeshwari
 * Description: Reviews Repository
 * Date:14-11-2024
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.roadready.entities.Reviews;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews,Integer>  {
	
	@Modifying
	@Transactional
	void deleteByReviewId(int reviewId);
	
	Reviews findByReviewId(int reviewId);
	
	List<Reviews> findByBooking_bookingId(int bookingId);
	
	List<Reviews> findByUser_userId(int userId);
	
	
	@Modifying
	@Transactional
	void deleteByBooking_bookingId(int bookingId);
}
