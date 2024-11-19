package com.hexaware.roadready.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.entities.Car;
@SpringBootTest
class CarServiceImplTest {
	
	@Autowired
	ICarService carService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testGetAllCars() {
//		fail("Not yet implemented");
		List<Car> cars=null;
		cars=carService.getAllCars();
		assertNotNull(cars);
		
	}

	@Test
	void testFindCarsByType() {
//		fail("Not yet implemented");
		List<Car> cars=null;

		String carType="Petrol";

		cars=carService.findCarsByType(carType);
		assertNotNull(cars);
		
	}

	@Test
	void testFindCarsByCompany() {
//		fail("Not yet implemented");
		List<Car> cars=null;
		String carCompany="bmw";

// 		String carCompany="Benz";

		cars=carService.findCarsByType(carCompany);
		assertNotNull(cars);
	}

	@Test
	void testFindCarsByModel() {
//		fail("Not yet implemented");
		List<Car> cars=null;

		String carModel="m20";

	//	String carModel="Rock";

		cars=carService.findCarsByType(carModel);
		assertNotNull(cars);
	}

	@Test
	void testFindCarsByYear() {
//		fail("Not yet implemented");

	   int year=2022;

	  // int year=2021;

	   List<Car> cars=null;
		cars=carService.findCarsByYear(year);
		assertNotNull(cars);
	   
	}

	@Test

	//@Disabled
	void testAddCar() {
//		Car cars=new Car(id,"Tata","Amaze","High Power",2011,"786789",amount);
		BigDecimal amount=new BigDecimal("2000.00");
		Car car =new Car();
		car.setCarCompany("Audi");
		car.setCarModel("Q7");
		car.setCarType("Petrol");
		car.setCarYear(2022);
		car.setLicensePlate("RJ05AC4587");
		car.setPricePerDay(amount);
		Car addCar=null;
		addCar=carService.addCar(car);
		assertEquals(addCar.getCarYear(),car.getCarYear());

		
	}

	@Test
	void testUpdateCar() {
//		fail("Not yet implemented");
		long id=302;
		BigDecimal amount=new BigDecimal("2500.00");
		Car car =new Car();
		car.setCarId(1);
		car.setCarCompany("Jeep");
		car.setCarModel("JEEP");
		car.setCarType("Diesel");
		car.setCarYear(2022);
		car.setLicensePlate("GJ05AC4579");
		car.setPricePerDay(amount);
		Car addCar=null;
		addCar=carService.updateCar(car.getCarId(), car);
		assertEquals(car.getCarId(),addCar.getCarId());

	}

	@Test
	void testDeleteCar() {
		int carId=2;
		String deleteDetail=carService.deleteCar(carId);
		assertEquals("Record Deleted Successfully",deleteDetail);
		
	}

	@Test
	void testIsCarAvailable() {
		//fail("Not yet implemented");
		  int carId=1;
		  String startDateString = "2024-11-20";
	        LocalDate startDate = LocalDate.parse(startDateString);
	  	  String endDateString = "2024-11-21";

	        LocalDate endDate = LocalDate.parse(endDateString);
	        boolean availability=carService.isCarAvailable(carId, startDate, endDate);
	        assertTrue(availability);
	}

}
