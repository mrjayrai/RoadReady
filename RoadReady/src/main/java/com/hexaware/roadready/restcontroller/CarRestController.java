package com.hexaware.roadready.restcontroller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.entities.Car;
import com.hexaware.roadready.entities.CarAvailabilityRequest;
import com.hexaware.roadready.services.ICarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cars/")
public class CarRestController {

	@Autowired
	private ICarService carService;

	@GetMapping("getcars")
	private List<Car> getCars() {

		return carService.getAllCars();
	}
	
	@GetMapping("year/{year}")
	private List<Car> getCarsByYear(@PathVariable int year){
		return carService.findCarsByYear(year);
	}
	
	@GetMapping("model/{model}")
	private List<Car> getCarsByModel(@PathVariable String model){
		return carService.findCarsByModel(model);
	}
	
	@GetMapping("company/{company}")
	private List<Car> getCarsByCompany(@PathVariable String company){
		return carService.findCarsByCompany(company);
	}
	
	@GetMapping("type/{type}")
	private List<Car> getCarsByType(@PathVariable String type){
		return carService.findCarsByType(type);
	}
	
	@PostMapping("add")
	private ResponseEntity<Car> addCar( @RequestBody @Valid Car car) {
		 Car savedCar = carService.addCar(car);
	        return ResponseEntity.ok(savedCar);
	}
	
	
//	@PostMapping("isavailable")
//	private boolean isCarAvailable(@RequestBody int carId,LocalDateTime startDate,LocalDateTime endDate) {
//		return carService.isCarAvailable(carId, startDate, endDate);
//	}
	
	@PostMapping("isavailable")
	private boolean isCarAvailable(@RequestBody CarAvailabilityRequest car) {
		return carService.isCarAvailable(car.getCarId(), car.getStartDate(), car.getEndDate());
	}
	
	@PutMapping("update")
	private Car updateCar(@RequestBody @Valid Car car) {
		return carService.updateCar(car.getCarId(), car);
	}

	@DeleteMapping("delete/{carId}")
	private String deleteCar(@PathVariable int carId) {
		return carService.deleteCar(carId);
	}
}
