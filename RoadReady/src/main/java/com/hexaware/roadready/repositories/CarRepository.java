package com.hexaware.roadready.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.roadready.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
	
	List<Car> findByCarId(long carId);
	List<Car> findByCarCompany(String carCompany);
	List<Car> findByCarYear(int carYear);
	List<Car> findByCarModel(String carModel);
	List<Car> findByCarType(String carType);
	
	@Query("SELECT COUNT(b) " +
		       "FROM Bookings b " +
		       "WHERE b.car.carId = :carId " +
		       "AND b.startDate <= :endTime " +
		       "AND b.endDate >= :startTime")
		long isCarAvailable(@Param("carId") int carId,@Param("startTime") LocalDate startTime, @Param("endTime") LocalDate endTime);

}
