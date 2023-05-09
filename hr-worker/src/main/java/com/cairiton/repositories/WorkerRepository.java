package com.cairiton.repositories;



import org.springframework.data.jpa.repository.JpaRepository;


import com.cairiton.entities.Worker;


public interface WorkerRepository extends JpaRepository<Worker, Long> {
	
	
}
