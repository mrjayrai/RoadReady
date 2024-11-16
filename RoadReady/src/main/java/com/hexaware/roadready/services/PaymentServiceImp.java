package com.hexaware.roadready.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public Payments addPayment(Payments payment) {
		// TODO Auto-generated method stub
		return paymentRepository.save(payment);
	}

	@Override
	public Optional<Payments> getPaymentById(int paymentId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Payments> getPaymentsByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payments> getPaymentHistoryByBookingId(int bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean savePaymentMethod(int userId, String paymentDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean issueRefund(int paymentId, double refundAmount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validatePaymentDetails(String paymentDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePaymentStatus(Integer paymentId, String status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Double getTotalAmountPaid(Integer bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPaymentCompleted(Integer bookingId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Payments> getAllPayments() {
		// TODO Auto-generated method stub
		//return paymentRepository.findAll();
		  List<Payments> paymentsList = paymentRepository.findAll();
		  List<Payments> result = new ArrayList<Payments>();
//		  
		 // System.out.println(paymentsList);
		  //public Users(int userId, String email, String password, String phoneNumber, Role role, LocalDateTime createdAt)
		  for(Payments p: paymentsList) {
			  Users user = new Users(p.getUser().getUserId(),p.getUser().getEmail(),p.getUser().getPassword(),p.getUser().getPhoneNumber(),null,null);
//			  user.setUserId(p.getUser().getUserId());
			  Payments payment = new Payments(p.getPaymentId(),p.getAmount(),p.getPaymentDate(),p.getPaymentMethod(),p.getStatus(),user,null);
			  result.add(payment);
		  }
	        return result;
		  
//		  return null;
	}

}
