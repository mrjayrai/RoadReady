package com.hexaware.roadready.services;

import java.time.LocalDate;
import java.util.List;

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
	
	@Override
	public List<Car> getAllCars() {
		// TODO Auto-generated method stub
		return carRepository.findAll();
	}

	@Override
	public List<Car> findCarsByType(String carType) {
		// TODO Auto-generated method stub
		return carRepository.findByCarType(carType);
	}

	@Override
	public List<Car> findCarsByCompany(String carCompany) {
		// TODO Auto-generated method stub
		return carRepository.findByCarCompany(carCompany);
	}

	@Override
	public List<Car> findCarsByModel(String carModel) {
		// TODO Auto-generated method stub
//		return carRepository.findByCarModel(carModel);
		List<Car> cars = carRepository.findByCarModel(carModel);
        if (cars.isEmpty()) {
            throw new NotFoundException("No cars found for model: " + carModel);
        }
        return cars;
	}

	@Override
	public List<Car> findCarsByYear(int year) {
		// TODO Auto-generated method stub
		return carRepository.findByCarYear(year);
	}

	@Modifying
	@Override
	public Car addCar(Car car) {
		// TODO Auto-generated method stub
		return carRepository.save(car);
	}

	@Modifying
	@Override
	public Car updateCar(long carId, Car updatedCar) {
		// TODO Auto-generated method stub
		return carRepository.save(updatedCar);
	}

	@Modifying
	@Override
	public String deleteCar(int carId) {
		// TODO Auto-generated method stub
		carRepository.deleteById(carId);
		return "Record Deleted Successfully";
	}

	@Override
	public boolean isCarAvailable(int carId, LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return carRepository.isCarAvailable(carId, startDate, endDate) == 0;
	}

	

}
