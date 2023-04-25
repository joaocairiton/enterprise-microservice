package com.cairiton.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cairiton.entities.Payment;
import com.cairiton.entities.Worker;
import com.cairiton.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
		
		
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		
		
		return new Payment(worker.getName(), worker.getDailyIcome(), days);
	}
	
	

}
