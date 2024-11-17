package com.hexaware.roadready.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.entities.Bookings;
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
		return bookingRepo.findByBookingId(bookingId);
	}

	@Override
	public List<Bookings> getAllBookings() {
		// TODO Auto-generated method stub
		return bookingRepo.findAll();
	}

	@Override
	public Bookings createBooking(Bookings booking) {
		// TODO Auto-generated method stub
		return bookingRepo.save(booking);
	}

	@Override
	public Bookings updateBooking(Bookings updateBooking) {
		// TODO Auto-generated method stub
		return bookingRepo.save(updateBooking);
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
