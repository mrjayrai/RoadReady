package com.hexaware.roadready.services;
/*
 * Author : Rajeshwari
 * Description : Service Implementation for payments
 * Date: 18-11-2024
 */
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hexaware.roadready.dto.PaymentDTO;
import com.hexaware.roadready.entities.Bookings;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reviews;
import com.hexaware.roadready.entities.Role;
import com.hexaware.roadready.entities.Users;
import com.hexaware.roadready.exceptions.InvalidDataException;
import com.hexaware.roadready.exceptions.NotFoundException;
import com.hexaware.roadready.entities.Payments.PaymentMethod;
import com.hexaware.roadready.entities.Payments.PaymentStatus;
import com.hexaware.roadready.repositories.BookingsRepository;
import com.hexaware.roadready.repositories.PaymentRepository;
//import com.hexaware.springrestjpa.service.EmployeeServiceImp;
import com.hexaware.roadready.repositories.UsersRepository;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
@Service
public class PaymentServiceImp implements IPaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;
	UsersRepository usersRepository;
	BookingsRepository bookingsRepository;
	@Autowired
	RestTemplate restTemplate;
	
	Logger logger =	   LoggerFactory.getLogger(PaymentServiceImp.class);

	@Modifying
//	@Override
//	public Payments addPayment(Payments payment) {
//		// TODO Auto-generated method stub
//
//		Payments addPayment= paymentRepository.save(payment);
//		if(addPayment!=null) {
//			logger.info("New Payment Details added");
//			return addPayment;
//		}
//		else {
//			logger.error("Problem with add payments");
//			throw new InvalidDataException(HttpStatus.BAD_REQUEST,"Given data for payment is not valid");
//		}
//	}

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
//		  return paymentRepository.findAll();
		String url = "http://localhost:8181/api/payments/getallpayments" ;
		List<Payments> paymentList = Arrays.asList(restTemplate.getForObject(url, Payments[].class));
		return paymentList;
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

	@Override
	public Payments addPayment(PaymentDTO paymentDto) {
		// TODO Auto-generated method stub
		Payments addPayment = new Payments();
		 addPayment.setAmount(paymentDto.getAmount());
		    addPayment.setPaymentDate(paymentDto.getPaymentDate());
		    addPayment.setPaymentMethod(Payments.PaymentMethod.valueOf(paymentDto.getPaymentMethod()));
		    addPayment.setStatus(Payments.PaymentStatus.valueOf(paymentDto.getStatus()));
//		    Users user = usersRepository.findById(paymentDto.getUserId())
//		            .orElseThrow(() -> new InvalidDataException(HttpStatus.BAD_REQUEST, "User not found with ID: " + paymentDto.getUserId()));
		   int userId=paymentDto.getUserId();
		    Users user=new Users(userId);
		    addPayment.setUser(user);
//		    Bookings booking = bookingsRepository.findById(paymentDto.getBookingId())
//		            .orElseThrow(() -> new InvalidDataException(HttpStatus.BAD_REQUEST, "Booking not found with ID: " + paymentDto.getBookingId()));
		    int bookingId=paymentDto.getBookingId();
		    Bookings booking=new Bookings(bookingId);
		    addPayment.setBooking(booking);
		    Payments savedPayment = paymentRepository.save(addPayment);
	
		        logger.info("New Payment Details added: {}", savedPayment);
		        return savedPayment;
	}

}
