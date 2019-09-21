package com.monitor.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.monitor.management.model.Machine;
import com.monitor.management.model.MachineRepository;
import com.monitor.management.model.Worker;
import com.monitor.management.model.WorkerRepository;

@SpringBootApplication
public class Application  implements CommandLineRunner{

	@Autowired
	WorkerRepository workerRepository;
	@Autowired
	MachineRepository machineRepository;
		
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
	
		workerRepository.findAll();		
		
		workerRepository.save(new Worker(2,"Frank Lake","engineer"));
		workerRepository.save(new Worker(3,"John Parker","driver"));
		workerRepository.save(new Worker(4,"Peter Baker","engineer"));
		workerRepository.save(new Worker(5,"Mike Smith","driver"));
		workerRepository.save(new Worker(6,"Tim Parker","engineer"));
		
		
		machineRepository.findAll();
		
		machineRepository.save(new Machine(1,"machine 1,factory 6 ,room 33", 11));
		machineRepository.save(new Machine(2,"machine 2,factory 4 ,room 55", 22));
		machineRepository.save(new Machine(3,"machine 3,factory 5 ,room 66", 11));
		machineRepository.save(new Machine(4,"machine 4,factory 8 ,room 88", 22));
		machineRepository.save(new Machine(5,"machine 5,factory 9, room 44", 11));
		
	}
}
