package com.hexaware.roadready.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.BookingDTO;
import com.hexaware.roadready.entities.Bookings;
import com.hexaware.roadready.exceptions.NotFoundException;
import com.hexaware.roadready.repositories.BookingsRepository;
import com.hexaware.roadready.repositories.ReviewsRepository;

@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private BookingsRepository bookingRepo;
	
	@Autowired
	private ReviewsRepository reviewRepo;
	
	@Override
	public List<Bookings> getBookingById(int bookingId) {
		// TODO Auto-generated method stub
		List<Bookings> bookings = bookingRepo.findByBookingId(bookingId);
//		if(bookings.isEmpty()) {
//			throw new NotFoundException("No booking found for Booking ID: " + bookingId);
//		}
		return bookings;
	}

	@Override
	public List<Bookings> getAllBookings() {
		// TODO Auto-generated method stub
		return bookingRepo.findAll();
	}

	@Override
	public Bookings createBooking(BookingDTO booking) {
		// TODO Auto-generated method stub
		Bookings bookEntity = new Bookings();
		bookEntity.setCar(booking.getCarId());
		bookEntity.setUser(booking.getUserId());
		bookEntity.setEndDate(booking.getEndDate());
		bookEntity.setStartDate(booking.getStartDate());
		bookEntity.setStatus(booking.getStatus());
		bookEntity.setTotalPrice(booking.getTotalPrice());
		
		return bookingRepo.save(bookEntity);
	}

	@Override
	public Bookings updateBooking(BookingDTO booking) {
		// TODO Auto-generated method stub
		Bookings bookEntity = new Bookings();
		bookEntity.setBookingId(booking.getBookingId());
		bookEntity.setCar(booking.getCarId());
		bookEntity.setUser(booking.getUserId());
		bookEntity.setEndDate(booking.getEndDate());
		bookEntity.setStartDate(booking.getStartDate());
		bookEntity.setStatus(booking.getStatus());
		bookEntity.setTotalPrice(booking.getTotalPrice());
		return bookingRepo.save(bookEntity);
	}

	@Override
	public void cancelBooking(int bookingId) {
		// TODO Auto-generated method stub
//		return false;
		// You would have to add a delete method for paymenttable also
		reviewRepo.deleteByBooking_bookingId(bookingId);
		bookingRepo.deleteByBookingId(bookingId);
	}

}
