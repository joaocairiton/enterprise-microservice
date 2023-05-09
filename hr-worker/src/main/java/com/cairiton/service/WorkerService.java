package com.cairiton.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.cairiton.entities.Worker;
import com.cairiton.exception.HrException;
import com.cairiton.repositories.WorkerRepository;

@Service
public class WorkerService {
	
@Autowired	
private WorkerRepository workerRepository;





  public Worker findById(Long workerId) { return
  workerRepository.findById(workerId) .orElseThrow(() -> new
  HrException("Trabalhador não encontrado!")); }
 
  
  
 

}
