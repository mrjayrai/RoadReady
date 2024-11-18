package com.hexaware.roadready.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Cars")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id", nullable = false)
	private long carId;

	
	@NotNull(message = "Car company cannot be null")
	@NotBlank(message = "Car company cannot be blank")
	@Size(max = 20, message = "Car company must not exceed 20 characters")
	@Column(name = "car_company", nullable = false, length = 20)
	private String carCompany;

	
	@NotNull(message = "Car model cannot be null")
    @NotBlank(message = "Car model cannot be blank")
    @Size(max = 20, message = "Car model must not exceed 20 characters")
	@Column(name = "car_model", nullable = false, length = 20)
	private String carModel;

	
	@NotNull(message = "Car year cannot be null")
    @Min(value = 2010, message = "Car year must not be before 2010")
    @Max(value = 2100, message = "Car year must not be in the far future")
	@Column(name = "car_year", nullable = false)
	private int carYear;

	
	@NotNull(message = "License plate cannot be null")
    @NotBlank(message = "License plate cannot be blank")
    @Size(max = 15, message = "License plate must not exceed 15 characters")
	@Column(name = "license_plate", nullable = false, unique = true, length = 15)
	private String licensePlate;

	@NotNull(message = "Car type cannot be null")
    @NotBlank(message = "Car type cannot be blank")
    @Size(max = 15, message = "Car type must not exceed 15 characters")
	@Column(name = "car_type", nullable = false, length = 15)
	private String carType;

	@NotNull(message = "Price per day cannot be null")
	@Column(name = "price_per_day", nullable = false, precision = 10, scale = 2)
	private BigDecimal pricePerDay;

	public Car() {
		super();
	}
	

	public Car(long carId) {
		super();
		this.carId = carId;
	}


	public Car(long carId, String carCompany, String carModel, String licensePlate, int carYear, String carType,
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
