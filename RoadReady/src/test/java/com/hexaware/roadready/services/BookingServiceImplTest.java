package com.hexaware.roadready.services;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.entities.Bookings;
import com.hexaware.roadready.entities.Car;
import com.hexaware.roadready.entities.Users;
import com.hexaware.roadready.exceptions.NotFoundException;

@SpringBootTest
class BookingServiceImplTest {

	@Autowired
	IBookingService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	void testGetBookingById() {
		// fail("Not yet implemented");
		int id = 2;
		List<Bookings> book =null;
		book = service.getBookingById(id);
		assertNotNull(book);
	}

	@Test
	void testGetAllBookings() {
	//	 fail("Not yet implemented");
		List<Bookings> book = service.getAllBookings();
		assertNotNull(book);
	}

	@Test
	void testCreateBooking() {
		//fail("Not yet implemented");
		Bookings booking = new Bookings();
		Car car = new Car();
		car.setCarId(5);
		Users user = new Users(1);
		booking.setCar(car);
		booking.setUser(user);
		String start = "2024-11-19";
		LocalDate startDate = LocalDate.parse(start);
		booking.setStartDate(startDate);
		String end = "2024-11-21";
		LocalDate endDate = LocalDate.parse(end);
		booking.setEndDate(endDate);
		BigDecimal amount = new BigDecimal("2500.00");
		booking.setTotalPrice(amount);
		booking.setStatus("Confirmed");
		Bookings book = service.createBooking(booking);
		assertEquals(booking.getBookingId(), book.getBookingId());
	}

	@Test
	void testUpdateBooking() {
//	fail("Not yet implemented");
		Bookings booking = new Bookings();
		booking.setBookingId(3);
		Car car = new Car();
		car.setCarId(5);
		Users user = new Users(1);
		booking.setCar(car);
		booking.setUser(user);
		String start = "2024-11-19";
		LocalDate startDate = LocalDate.parse(start);
		booking.setStartDate(startDate);
		String end = "2024-11-21";
		LocalDate endDate = LocalDate.parse(end);
		booking.setEndDate(endDate);
		BigDecimal amount = new BigDecimal("2600.00");
		booking.setTotalPrice(amount);
		booking.setStatus("Confirmed");
		Bookings book = service.updateBooking(booking);
		assertEquals(booking.getBookingId(), book.getBookingId());
	}

	@Test
	void testCancelBooking() {
		 //fail("Not yet implemented");
		int id = 5;
		service.cancelBooking(id);
		
		List<Bookings> book =null;
		book = service.getBookingById(id);
		assertTrue(book.isEmpty());
	}

}
