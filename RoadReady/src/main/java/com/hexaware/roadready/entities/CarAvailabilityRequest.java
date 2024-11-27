package com.hexaware.roadready.entities;
/*
 * Author : Pritesh Rai
 * Description : DTO object for a Rest API
 * Date: 16-11-2024
 */
import java.time.LocalDate;

public class CarAvailabilityRequest {
    private int carId;
    private LocalDate startDate;
    private LocalDate endDate;

    // Getters and setters
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
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

	public CarAvailabilityRequest() {
		super();
	}

	public CarAvailabilityRequest(int carId, LocalDate startDate, LocalDate endDate) {
		super();
		this.carId = carId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
    
    
}
