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
	public Payments getPaymentById(int paymentId) {
		// TODO Auto-generated method stub
		return paymentRepository.findByPaymentId(paymentId);
	}

	@Override
	public List<Payments> getPaymentsByUserId(int userId) {
		// TODO Auto-generated method stub
		return paymentRepository.findByUser_UserId(userId);
	}
	
	@Modifying
	@Override
	public boolean updatePaymentStatus(Integer paymentId, PaymentStatus status) {
		// TODO Auto-generated method stub
		int row =  paymentRepository.updatePaymentStatus(paymentId, status);
		return row>0;
	}


	@Override
	public boolean isPaymentCompleted(int paymentId) {
		// TODO Auto-generated method stub
		
		return paymentRepository.existsByStatusAndBooking_BookingId( PaymentStatus.PAID,paymentId);
	}

	@Override
	public List<Payments> getAllPayments() {
		// TODO Auto-generated method stub
		
		  return paymentRepository.findAll();
	}

	@Override
	public String paymentStatus(int paymentId) {
		// TODO Auto-generated method stub
		if(paymentId<0) {
			return "Enter valid paymentId";
		}
		return paymentRepository.findPaymentStatusByPaymentId(paymentId);
	}

}
