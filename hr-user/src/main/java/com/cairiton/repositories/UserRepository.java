package com.cairiton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cairiton.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
