package com.hexaware.roadready.entities;
/*
 * Author : Rajeshwari
 * Description : Entity for Payments
 * Date: 16-11-2024
 */
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "payments")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    @NotNull(message = "Amount is required.")
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero.")
    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "payment_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false)
    @NotNull(message = "Payment method is required.")
    // @Pattern(regexp = "^(CASH|CREDIT_CARD|DEBIT_CARD|ONLINE)$", message = "Paymentmethod must be CASH, CREDIT_CARD, DEBIT_CARD, ONLINE.")
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
   // @Pattern(regexp = "^(PENDING|PAID|FAILED)$", message = "Status must be PENDING, PAID, or FAILED.")
    @Column(name = "status", columnDefinition = "ENUM('PENDING', 'PAID', 'FAILED') DEFAULT 'PENDING'")
    private PaymentStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User ID is required.")
    private Users user; // Reference to the Users entity

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "booking_id", nullable = false)
    @NotNull(message = "Booking ID is required.")
    private Bookings booking; // Reference to the Bookings entity

    // Getters and Setters

    // Enum for Payment Method
    public enum PaymentMethod {
        CASH, CREDIT_CARD, DEBIT_CARD, ONLINE
    }

    // Enum for Payment Status
    public enum PaymentStatus {
        PENDING, PAID, FAILED
    }

    public Payments(int i, double d, LocalDateTime localDateTime, PaymentMethod cash, PaymentStatus pending, Bookings booking2, Users user2) {
        super();
    }

    

    public Payments(int paymentId, BigDecimal amount, LocalDateTime paymentDate, PaymentMethod paymentMethod,
			PaymentStatus status, Users user, Bookings booking) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.user = user;
		this.booking = booking;
	}



	public Payments() {
		// TODO Auto-generated constructor stub
	}



	// Getters and Setters for each field
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Bookings getBooking() {
        return booking;
    }

    public void setBooking(Bookings booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Payments [paymentId=" + paymentId + ", amount=" + amount + ", paymentDate=" + paymentDate
                + ", paymentMethod=" + paymentMethod + ", status=" + status + ", user=" + user + ", booking=" + booking
                + "]";
    }

}
