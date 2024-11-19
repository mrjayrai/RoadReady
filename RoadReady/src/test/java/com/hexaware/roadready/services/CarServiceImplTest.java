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
		String carType="Power Engine";
		cars=carService.findCarsByType(carType);
		assertNotNull(cars);
		
	}

	@Test
	void testFindCarsByCompany() {
//		fail("Not yet implemented");
		List<Car> cars=null;
		String carCompany="Benz";
		cars=carService.findCarsByType(carCompany);
		assertNotNull(cars);
	}

	@Test
	void testFindCarsByModel() {
//		fail("Not yet implemented");
		List<Car> cars=null;
		String carModel="Rock";
		cars=carService.findCarsByType(carModel);
		assertNotNull(cars);
	}

	@Test
	void testFindCarsByYear() {
//		fail("Not yet implemented");
	   int year=2021;
	   List<Car> cars=null;
		cars=carService.findCarsByYear(year);
		assertNotNull(cars);
	   
	}

	@Test
//	@Disabled
	void testAddCar() {
//		fail("Not yet implemented");
		long id=302;
		BigDecimal amount=new BigDecimal("40.00");
		Car cars=new Car(id,"Tata","Amaze","High Power",2011,"786789",amount);
//		Car car=new Car();
//		car.setCarId(302);
//		car.setCarCompany("Tata");
//		car.setCarModel("High Power");
//		car.setCarType("Amaze");
//		car.setCarYear(2022);
//		car.setLicensePlate("786789");
//		car.setPricePerDay(0.01);
		Car addCar=null;
		addCar=carService.addCar(addCar);
		assertEquals(cars.getCarId(),302);
		
	}

	@Test
	void testUpdateCar() {
//		fail("Not yet implemented");
		long id=302;
		BigDecimal amount=new BigDecimal("50.00");
		Car cars=new Car(id,"Tata","Amaze","High Power",2011,"786789",amount);
		Car addCar=null;
		addCar=carService.updateCar(id, addCar);
		assertEquals(cars.getCarId(),302);
	}

	@Test
	void testDeleteCar() {
		int carId=2;
		String deleteDetail=carService.deleteCar(carId);
		assertEquals("Record Deleted Successfully",deleteDetail);
		
	}

	@Test
	void testIsCarAvailable() {
		fail("Not yet implemented");
		  int carId=301;
		  String startDateString = "10/12/2024";
	        LocalDate startDate = LocalDate.parse(startDateString);
	  	  String endDateString = "10/12/2024";
	        LocalDate endDate = LocalDate.parse(endDateString);
	        boolean availability=carService.isCarAvailable(carId, startDate, endDate);
	        assertTrue(availability);
	}

}
