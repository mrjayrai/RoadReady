package com.hexaware.roadreay.service;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.hexaware.roadreay.dto.PaymentDTO;
import com.hexaware.roadreay.enitity.Bookings;
import com.hexaware.roadreay.enitity.Payments;
import com.hexaware.roadreay.enitity.Payments.PaymentStatus;
import com.hexaware.roadreay.enitity.Users;
import com.hexaware.roadreay.exception.NotFoundException;
import com.hexaware.roadreay.repository.BookingsRepository;
import com.hexaware.roadreay.repository.PaymentRepository;
import com.hexaware.roadreay.repository.UsersRepository;
@Service
public class PaymentServiceImp implements IPaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;
	UsersRepository usersRepository;
	BookingsRepository bookingsRepository;
	
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
