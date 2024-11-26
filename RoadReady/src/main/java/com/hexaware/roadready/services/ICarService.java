package com.hexaware.roadready.services;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.entities.Car;

public interface ICarService {
	List<Car> getAllCars();

	List<Car> findCarsByType(String carType);

	List<Car> findCarsByCompany(String carCompany);

	List<Car> findCarsByModel(String carModel);

	List<Car> findCarsByYear(int year);

	Car addCar(CarDTO car);

	Car updateCar(long carId, CarDTO updatedCar);

	String deleteCar(int carId);

	boolean isCarAvailable(int carId, LocalDate startDate,LocalDate endDate);
}
