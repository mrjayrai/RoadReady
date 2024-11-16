package com.hexaware.roadready.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.roadready.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

}
