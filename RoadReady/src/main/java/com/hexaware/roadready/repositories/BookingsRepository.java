package com.hexaware.roadready.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.roadready.entities.Bookings;

public interface BookingsRepository extends JpaRepository<Bookings,Integer> {

}
