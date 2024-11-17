package com.hexaware.roadready.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.roadready.entities.Users;
@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

	List<Users> findByUserId(int userId);
	
	List<Users> findByEmail(String email);
	
	boolean existsByEmailAndPassword(String email,String password);
	
	@Modifying
	@Transactional
	void deleteByUserId(int userId);
}
