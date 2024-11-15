package com.hexaware.roadready.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.roadready.entities.Payments;

public interface PaymentRepository extends JpaRepository<Payments,Integer> {

}
