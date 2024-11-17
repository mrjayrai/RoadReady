package com.hexaware.roadready.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.entities.Bookings;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Role;
import com.hexaware.roadready.entities.Users;
import com.hexaware.roadready.entities.Payments.PaymentMethod;
import com.hexaware.roadready.entities.Payments.PaymentStatus;
import com.hexaware.roadready.repositories.PaymentRepository;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
@Service
public class PaymentServiceImp implements IPaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;

	@Modifying
	@Override
	public Payments addPayment(Payments payment) {
		// TODO Auto-generated method stub
		return paymentRepository.save(payment);
	}

	@Override
	public List<Payments> getPaymentById(int paymentId) {
		// TODO Auto-generated method stub
		return paymentRepository.findByPaymentId(paymentId);
	}

	@Override
	public List<Payments> getPaymentsByUserId(int userId) {
		// TODO Auto-generated method stub
		return paymentRepository.findByUser_UserId(userId);
	}

	@Override
	public List<Payments> getPaymentHistoryByBookingId(int bookingId) {
		// TODO Auto-generated method stub
		// Unncessary
		return null;
	}

	@Override
	public boolean savePaymentMethod(int userId, String paymentDetails) {
		// TODO Auto-generated method stub
		// Unnecessary
		return false;
	}

	@Override
	public boolean issueRefund(int paymentId, double refundAmount) {
		// TODO Auto-generated method stub
		// unnecessary
		return false;
	}

	@Override
	public boolean validatePaymentDetails(String paymentDetails) {
		// TODO Auto-generated method stub
		// Validation not API
		return false;
	}
	
	@Modifying
	@Override
	public boolean updatePaymentStatus(Integer paymentId, PaymentStatus status) {
		// TODO Auto-generated method stub
		int row =  paymentRepository.updatePaymentStatus(paymentId, status);
		return row>0;
	}

	@Override
	public Double getTotalAmountPaid(Integer bookingId) {
		// TODO Auto-generated method stub
		// unneccesary
		return null;
	}

	@Override
	public boolean isPaymentCompleted(int bookingId) {
		// TODO Auto-generated method stub
		
		return paymentRepository.existsByStatusAndBooking_BookingId( PaymentStatus.PAID,bookingId);
	}

	@Override
	public List<Payments> getAllPayments() {
		// TODO Auto-generated method stub
		
		  return paymentRepository.findAll();
	}

}
