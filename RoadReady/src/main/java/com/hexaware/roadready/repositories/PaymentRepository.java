package com.hexaware.roadready.repositories;
/*
 * Author:Rajeshwari
 * Description: Payement Repository
 * Date:14-11-2024
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.roadready.entities.Payments;
@Repository
public interface PaymentRepository extends JpaRepository<Payments,Integer> {

}
