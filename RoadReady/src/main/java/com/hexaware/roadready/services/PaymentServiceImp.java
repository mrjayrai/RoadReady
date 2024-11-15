package com.hexaware.roadready.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.repositories.PaymentRepository;

public class PaymentServiceImp implements IPaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public Payments addPayment(int userId, int bookingId, double amount, String paymentMethod, String status) {
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

}
