package com.hexaware.roadready.services;
/*
 * Author : Shreyasi
 * Description : Service interface for business logic for bookings
 * Date: 18-11-2024
 */
import java.util.List;

import com.hexaware.roadready.dto.BookingDTO;
import com.hexaware.roadready.entities.Bookings;


public interface IBookingService {
	List<Bookings> getBookingById(int bookingId);
    List<Bookings> getAllBookings();
    Bookings createBooking(BookingDTO booking);
    Bookings updateBooking( BookingDTO updateBooking);
    void cancelBooking(int bookingId);
}
