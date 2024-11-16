package com.hexaware.roadready.services;
/*
 * Author:Rajeshwari
 * Description: Service Interface for payment
 * Date:12-11-2024
 */
import java.util.List;
import java.util.Optional;

import com.hexaware.roadready.entities.Payments;

public interface IPaymentService {
	 // Method to process a new payment
    Payments addPayment(Payments payment);

    // Method to retrieve a payment by its ID
    Optional<Payments> getPaymentById(int paymentId);

    // Method to fetch all payments made by a specific user
    List<Payments> getPaymentsByUserId(int userId);

    // Method to get payment history for a specific booking
    List<Payments> getPaymentHistoryByBookingId(int bookingId);

    // Method to save a new payment method for the user
    boolean savePaymentMethod(int userId, String paymentDetails);

    // Method to issue a refund for a payment
    boolean issueRefund(int paymentId, double refundAmount);

    // Method to validate if payment details are correct (e.g., card number validation)
    boolean validatePaymentDetails(String paymentDetails);
    
    // Update the payment status (e.g., mark as PAID, FAILED)
    boolean updatePaymentStatus(Integer paymentId, String status);

    // Get the total amount paid for a specific booking
    Double getTotalAmountPaid(Integer bookingId);

    // Check if payment is completed for a specific booking
    boolean isPaymentCompleted(Integer bookingId);
    
    // Method to fetch all payment transactions (for admin use)
    List<Payments> getAllPayments();
	
}
