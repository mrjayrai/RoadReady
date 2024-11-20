package com.hexaware.roadready.services;
/*
 * Author : Rajeshwari
 * Description : Rest Controller for Payment
 * Date: 17-11-2024
 */
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.entities.Bookings;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Role;
import com.hexaware.roadready.entities.Users;
import com.hexaware.roadready.exceptions.InvalidDataException;
import com.hexaware.roadready.exceptions.NotFoundException;
import com.hexaware.roadready.entities.Payments.PaymentMethod;
import com.hexaware.roadready.entities.Payments.PaymentStatus;
import com.hexaware.roadready.repositories.PaymentRepository;
//import com.hexaware.springrestjpa.service.EmployeeServiceImp;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
@Service
public class PaymentServiceImp implements IPaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;
	Logger logger =	   LoggerFactory.getLogger(PaymentServiceImp.class);

	@Modifying
	@Override
	public Payments addPayment(Payments payment) {
		// TODO Auto-generated method stub

		Payments addPayment= paymentRepository.save(payment);
		if(addPayment!=null) {
			logger.info("New Payment Details added");
			return addPayment;
		}
		else {
			logger.error("Problem with add payments");
			throw new InvalidDataException(HttpStatus.BAD_REQUEST,"Given data for payment is not valid");
		}
	}

	@Override
	public Payments getPaymentById(int paymentId) {
		// TODO Auto-generated method stub
		Payments payment=null;

		logger.info("Payment get by paymentId"+paymentId);

		payment=paymentRepository.findByPaymentId(paymentId);
		if(payment != null) {
			return payment;
		}
		else {
			logger.error("Given paymentId is not exist");
			throw new NotFoundException("No Payments found for paymentId: " + paymentId);
		}
	}

	@Override
	public List<Payments> getPaymentsByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Payments> payments= paymentRepository.findByUser_UserId(userId);
		logger.info("Payment get by userId");
		if(payments.isEmpty()) {
			logger.error("Payment is not exist for given user id");
			throw  new NotFoundException("No Payments found for userId: " + userId);
		}
		return payments;
	}
	
	@Modifying
	@Override
	public boolean updatePaymentStatus(Integer paymentId, PaymentStatus status) {
		// TODO Auto-generated method stub
		int row =  paymentRepository.updatePaymentStatus(paymentId, status);
		logger.info("Payment details updated");
		return row>0;
	}

//
//	@Override
//	public boolean isPaymentCompleted(int paymentId) {
//		// TODO Auto-generated method stub
//		
//		return paymentRepository.existsByStatusAndBooking_BookingId( PaymentStatus.PAID,paymentId);
//	}

	@Override
	public List<Payments> getAllPayments() {
		// TODO Auto-generated method stub
		logger.info("All Payment get ");
		  return paymentRepository.findAll();
	}

	@Override
	public String paymentStatus(int paymentId) {
		// TODO Auto-generated method stub
		logger.info("Payment status updated");
		if(paymentId<0) {
			return "Enter valid paymentId";
		}
		return paymentRepository.findPaymentStatusByPaymentId(paymentId);
	}

}
