package com.cairiton.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
 
  
 
	/*public Worker salvar(Worker worker) {

		boolean emailEmUso = workerRepository.findByEmail(worker.getEmail()).stream()
				.anyMatch(clienteExixtente -> !clienteExixtente.equals(cliente));

		if (emailEmUso) {
			throw new HrException("Já existe um cliente cadastrado com esse E-mail");
		}

		return workerRepository.save(worker);
	}*/
  @Transactional
	public Worker salvar(Worker worker) {

		boolean emailEmUso = workerRepository.findByName(worker.getName()).stream()
				.anyMatch(clienteExixtente -> !clienteExixtente.equals(worker));

		if (emailEmUso) {
			throw new HrException("Já existe um cliente cadastrado com esse E-mail");
		}

		return workerRepository.save(worker);
	}
 

}
