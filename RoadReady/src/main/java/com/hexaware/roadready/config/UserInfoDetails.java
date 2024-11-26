package com.hexaware.roadready.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.entities.Users;
import com.hexaware.roadready.repositories.UsersRepository;

@Service
public class UserInfoDetails implements UserDetailsService {

	@Autowired
	UsersRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		List<Users> userInfoList = repository.findByEmail(username);
		
		if (userInfoList.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }

        Users userInfo = userInfoList.get(0);
        
        
        return User.builder()
                .username(userInfo.getEmail()) 
                .password(userInfo.getPassword())
                .build();
	}

}
