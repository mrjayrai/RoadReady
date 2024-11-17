package com.hexaware.roadready.services;

import java.util.List;


import com.hexaware.roadready.entities.Bookings;


public interface IBookingService {
	List<Bookings> getBookingById(int bookingId);
    List<Bookings> getAllBookings();
    Bookings createBooking(Bookings booking);
    Bookings updateBooking( Bookings updateBooking);
    void cancelBooking(int bookingId);
}
