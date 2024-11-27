package com.hexaware.roadreay.repository;
/*
 * Author : Shreyasi
 * Description : Repository/DAO Interface for Bookings
 * Date: 18-11-2024
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.roadreay.enitity.Bookings;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings,Integer> {
	
	List<Bookings> findByBookingId(int bookingId);
	
	@Modifying
	@Transactional
	void deleteByBookingId(int bookingId);
}
