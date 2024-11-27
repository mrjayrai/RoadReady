package com.hexaware.roadready.dto;
/*
 * Author : Rajeshwari
 * Description : DTO class for payments
 * Date: 23-11-2024
 */

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentDTO {
//    private int paymentId;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private String paymentMethod; // Using String to avoid tight coupling with the Enum in the entity
    private String status; // Using String for the same reason
    private int userId; // Referencing only the ID of the user
    private int bookingId; // Referencing only the ID of the booking

    // Constructors
    public PaymentDTO() {
    }

    public PaymentDTO( BigDecimal amount, LocalDateTime paymentDate, String paymentMethod, String status,
                      int userId, int bookingId) {
//        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.userId = userId;
        this.bookingId = bookingId;
    }

    // Getters and Setters
//    public int getPaymentId() {
//        return paymentId;
//    }
//
//    public void setPaymentId(int paymentId) {
//        this.paymentId = paymentId;
//    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "paymentId=" +  
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                ", bookingId=" + bookingId +
                '}';
    }
}

