package com.hexaware.roadready.restcontroller;
/*
 * Author : Shreyasi 
 * Description : Rest COntrollers for bookings
 * Date: 16-11-2024
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.BookingDTO;
import com.hexaware.roadready.entities.Bookings;
import com.hexaware.roadready.services.IBookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/booking/")
public class BookingRestController {
	
	@Autowired
	private IBookingService service;
	
	@GetMapping("allbookings")
	private List<Bookings> getAllBookings() {
		return service.getAllBookings();
	}
	
	@GetMapping("bookingId/{bookingId}")
	private List<Bookings> getBookingByBookingId(@PathVariable int bookingId){
		return service.getBookingById(bookingId);
	}
	
	@PutMapping("update")
	private Bookings updateBooking(@RequestBody BookingDTO updateBooking) {
		return service.updateBooking(updateBooking);
	}
	
	@DeleteMapping("delete/{bookingId}")
	private void deleteBooking(@PathVariable int bookingId) {
		service.cancelBooking(bookingId);
	}
	
	@PostMapping("add")
	private Bookings addBooking(@Valid @RequestBody BookingDTO booking) {
		return service.createBooking(booking);
	}

}
