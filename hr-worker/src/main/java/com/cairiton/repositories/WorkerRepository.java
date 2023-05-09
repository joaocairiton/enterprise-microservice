package com.cairiton.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cairiton.entities.Worker;


public interface WorkerRepository extends JpaRepository<Worker, Long> {
	
	List<Worker> findByName(String name);
	List<Worker> findByNameContaining(String name);
}
