package com.hexaware.roadready.repositories;
/*
 * Author : Rajeshwari
 * Description : Repository/DAO Interface for Payments
 * Date: 18-11-2024
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Payments.PaymentStatus;
import com.hexaware.roadready.entities.Users;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payments,Integer> {

	
	@Modifying
	@Transactional
    @Query("UPDATE Payments p SET p.status = :status WHERE p.paymentId = :paymentId")
    int updatePaymentStatus(@Param("paymentId") int paymentId, @Param("status") PaymentStatus status);
	
	Payments findByPaymentId(int paymentId);
	
	List<Payments> findByUser_UserId(int userId);
	
//	boolean existsByStatusAndBooking_BookingId(Payments.PaymentStatus status,int paymentId);
	
	
	@Query("SELECT p.status from Payments p where p.paymentId=?1")
	String findPaymentStatusByPaymentId(int paymentId);
	
}
