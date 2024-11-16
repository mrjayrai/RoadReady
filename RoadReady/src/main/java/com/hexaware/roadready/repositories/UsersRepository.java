package com.hexaware.roadready.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.roadready.entities.Users;
@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

}
