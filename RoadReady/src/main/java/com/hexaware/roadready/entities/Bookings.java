package com.hexaware.roadready.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User is required.")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    @NotNull(message = "Car is required.")
    private Car car;

    @Column(name = "start_date", nullable = false)
    @NotNull(message = "Start date is required.")
    @FutureOrPresent(message = "Start date must be today or in the future.")
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    @NotNull(message = "End date is required.")
    @Future(message = "End date must be in the future.")
    private LocalDate endDate;

    @Column(name = "total_price", nullable = false)
    @NotNull(message = "Total price is required.")
    private BigDecimal totalPrice;

    @NotNull(message = "Status is required.")
    // @Pattern(regexp = "^(PENDING|CONFIRMED|CANCELLED)$", message = "Status must be PENDING, CONFIRMED, or CANCELLED.")
    @Column(name = "status", nullable = false)
    private String status;

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public Bookings(int bookingId, Users user, Car car, LocalDate startDate, LocalDate endDate, BigDecimal totalPrice,
			String status) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.car = car;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
		this.status = status;
	}

	public Bookings() {
		super();
	}

	public Bookings(int bookingId) {
		super();
		this.bookingId = bookingId;
	}
    
}
