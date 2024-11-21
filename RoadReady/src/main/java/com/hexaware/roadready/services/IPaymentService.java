package com.hexaware.roadready.services;
/*
 * Author:Rajeshwari
 * Description: Service Interface for payment
 * Date:12-11-2024
 */
import java.util.List;
import java.util.Optional;

import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Payments.PaymentStatus;
import com.hexaware.roadready.entities.Users;

public interface IPaymentService {
	 // Method to process a new payment
    Payments addPayment(Payments payment);

    // Method to retrieve a payment by its ID
    Payments getPaymentById(int paymentId);

    // Method to fetch all payments made by a specific user
    List<Payments> getPaymentsByUserId(int userId) ;


    // Update the payment status (e.g., mark as PAID, FAILED)
    boolean updatePaymentStatus(Integer paymentId, PaymentStatus status);

    // Get the total amount paid for a specific booking
//    Double getTotalAmountPaid(Integer bookingId);

    // Check if payment is completed for a specific booking
//    boolean isPaymentCompleted(int paymentId);
    
    // Method to fetch all payment transactions (for admin use)
    List<Payments> getAllPayments();
    
    //getpayment status for payment id
    String paymentStatus(int paymentId);
	
}
