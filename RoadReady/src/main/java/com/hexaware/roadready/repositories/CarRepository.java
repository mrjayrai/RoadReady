package com.hexaware.roadready.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.roadready.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
