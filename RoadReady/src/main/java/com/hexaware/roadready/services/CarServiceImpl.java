package com.hexaware.roadready.services;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.entities.Car;
import com.hexaware.roadready.exceptions.NotFoundException;
import com.hexaware.roadready.repositories.CarRepository;

@Service
public class CarServiceImpl implements ICarService {

	@Autowired
	private CarRepository carRepository;
	Logger logger =	   LoggerFactory.getLogger(CarServiceImpl.class);
	
	@Override
	public List<Car> getAllCars() {
		// TODO Auto-generated method stub
		logger.info("All car details received");
		return carRepository.findAll();
	}

	@Override
	public List<Car> findCarsByType(String carType) {
		// TODO Auto-generated method stub
		logger.info("Car details found by car type");
		return carRepository.findByCarType(carType);
	}

	@Override
	public List<Car> findCarsByCompany(String carCompany) {
		// TODO Auto-generated method stub
		logger.info("Car details found by car company");
		return carRepository.findByCarCompany(carCompany);
	}

	@Override
	public List<Car> findCarsByModel(String carModel) {
		// TODO Auto-generated method stub
//		return carRepository.findByCarModel(carModel);
		logger.info("Car details found by car model");
		List<Car> cars = carRepository.findByCarModel(carModel);
        if (cars.isEmpty()) {
            throw new NotFoundException("No cars found for model: " + carModel);
        }
        return cars;
	}

	@Override
	public List<Car> findCarsByYear(int year) {
		// TODO Auto-generated method stub
		logger.info("Car details found by made year");
		return carRepository.findByCarYear(year);
	}

	@Modifying
	@Override
	public Car addCar(Car car) {
		// TODO Auto-generated method stub
		logger.info("New Car Details Added");
		return carRepository.save(car);
	}

	@Modifying
	@Override
	public Car updateCar(long carId, Car updatedCar) {
		// TODO Auto-grated method stub
		logger.info("Exist Car Details Updated");
		return carRepository.save(updatedCar);
	}

	@Modifying
	@Override
	public String deleteCar(int carId) {
		// TODO Auto-generated method stub
		logger.error("Car details deleted");
		carRepository.deleteById(carId);
		return "Record Deleted Successfully";
	}

	@Override
	public boolean isCarAvailable(int carId, LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		logger.info("Car Availability checked using start and end date");
		return carRepository.isCarAvailable(carId, startDate, endDate) == 0;
	}

	

}
