package com.hexaware.roadready.repositories;
/*
 * Author:Rajeshwari
 * Description: Reviews Repository
 * Date:14-11-2024
 */
import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.roadready.entities.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews,Integer>  {

}
