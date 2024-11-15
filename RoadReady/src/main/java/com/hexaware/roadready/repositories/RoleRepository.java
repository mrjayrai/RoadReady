package com.hexaware.roadready.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.roadready.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {

}
