package com.cairiton.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cairiton.entities.Worker;
import com.cairiton.repositories.WorkerRepository;
import com.cairiton.service.WorkerService;

//@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	//private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

	/*
	 * @Value("${test.config}") private String testConfig;
	 */

	/*
	 * @Autowired private Environment env;
	 */

	@Autowired
	private WorkerRepository workerRepository;
	
	@Autowired
	private WorkerService workerService;

	/*
	 * @GetMapping(value= "/configs") public ResponseEntity<Void> getConfigs(){
	 * logger.info("CONFIG = " + testConfig); return
	 * ResponseEntity.noContent().build(); }
	 */

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = workerRepository.findAll();
		return ResponseEntity.ok(list);
	}
	/*
	 * @GetMapping(value = "/{id}") public ResponseEntity<Worker>
	 * findById(@PathVariable Long id){
	 * 
	 * 
	 * try { //Thread.sleep(3000L); } catch (InterruptedException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * logger.info("PORT = " + env.getProperty("local.server.port"));
	 * 
	 * Worker obj = workerRepository.findById(id).get(); return
	 * ResponseEntity.ok(obj); }
	 */
	
	@GetMapping("/{workerId}")
	public ResponseEntity<Worker> buscar(@PathVariable Long workerId) {
				
			  Worker obj = workerService.findById(workerId); return
			  ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Worker adicionar(@Valid @RequestBody Worker worker) {
		return workerRepository.save(worker);
		
	}
	
	
	

	
	
	
	

}
