/*
 * Author : Rajeshwari
 * Description : Unit testing for Payment service Implementation
 * Date: 17-11-2024
 */
package com.hexaware.roadready.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.math.BigDecimal;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.entities.Bookings;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Payments.PaymentMethod;
import com.hexaware.roadready.entities.Payments.PaymentStatus;
import com.hexaware.roadready.entities.Users;
@SpringBootTest
class PaymentServiceImpTest {
	
	@Autowired
	IPaymentService paymentService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testAddPayment() {
		Bookings booking=new Bookings(1);

		Users user=new Users(1);
		Payments payment=new Payments();
		PaymentStatus status=Payments.PaymentStatus.PAID;
		PaymentMethod method=Payments.PaymentMethod.CASH;
//		payment=new Payments(8,1000.00,LocalDateTime.now(),method.CASH,status.PENDING,booking,user);
		BigDecimal amount = new BigDecimal("1000.00");
		payment.setAmount(amount);
		payment.setBooking(booking);
		payment.setPaymentDate(LocalDateTime.now());
		payment.setPaymentMethod(method);
		payment.setStatus(status);
		payment.setUser(user);

		Payments paymentCheck=paymentService.addPayment(payment);
		assertNotNull(paymentCheck);
	}

	@Test
	void testGetPaymentById() {
//		fail("Not yet implemented");
    	int paymentId=1;
    	Payments paymentCheck=paymentService.getPaymentById(1);
    	assertEquals(paymentCheck.getPaymentId(),1);
	}

	@Test
	void testGetPaymentsByUserId() {
//		fail("Not yet implemented");

		int userId=1;

		List<Payments> paymentList=null;
		 paymentList=paymentService.getPaymentsByUserId(userId);
		 assertNotNull(paymentList);
	
	}

	@Test
	void testUpdatePaymentStatus() {
		PaymentStatus status=null;
		status=status.FAILED;
		Integer paymentId=1;
		boolean updateStatus=paymentService.updatePaymentStatus(1, status);
		assertEquals(true,updateStatus);	 
		
	}


	@Test
	void testGetAllPayments() {
		List<Payments> paymentList=null;
		paymentList=paymentService.getAllPayments();
		assertNotNull(paymentList);
	}

	@Test
	void testPaymentStatus() {
	  int paymentId=1;
	  String status=" ";
	  status=paymentService.paymentStatus(paymentId);
	  assertNotEquals(" ",status);
	}

}
