package com.hexaware.roadready.dto;
/*
 * Author : Pritesh Rai
 * Description : DTO classes for car
 * Date: 24-11-2024
 */
import java.math.BigDecimal;

public class CarDTO {
	
	private long carId;
    private String carCompany;
    private String carModel;
    private int carYear;
    private String licensePlate;
    private String carType;
    private BigDecimal pricePerDay;
    
	public CarDTO() {
		super();
	}

	public CarDTO(long carId, String carCompany, String carModel, int carYear, String licensePlate, String carType,
			BigDecimal pricePerDay) {
		super();
		this.carId = carId;
		this.carCompany = carCompany;
		this.carModel = carModel;
		this.carYear = carYear;
		this.licensePlate = licensePlate;
		this.carType = carType;
		this.pricePerDay = pricePerDay;
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public String getCarCompany() {
		return carCompany;
	}

	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getCarYear() {
		return carYear;
	}

	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public BigDecimal getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(BigDecimal pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
    
    
}
