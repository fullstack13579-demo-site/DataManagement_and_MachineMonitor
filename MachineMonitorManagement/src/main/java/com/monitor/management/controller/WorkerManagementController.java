package com.monitor.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.monitor.management.model.Worker;
import com.monitor.management.model.WorkerRepository;

@Controller
@RequestMapping("/management")
public class WorkerManagementController {
	
	
	@Autowired
	WorkerRepository workerRepository;
	
	
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String ListAllWorkerData(Model model) {	
		
		 model.addAttribute("workerRepository",workerRepository.findAll());
		 return "viewManagement/workerList";		
	}
	
	
	
	@RequestMapping(value="/addNewWorker",method=RequestMethod.GET)
	public String addWorker() {		
		
		 return "viewManagement/addWorkerPage";		
	}
		
	
	
	@RequestMapping(value="/addIntoDatabase",method=RequestMethod.POST)
	public String addWorkerIntoDatabase(@RequestParam("workerName")String workerName ,
			                                                       @RequestParam("workerTitle")String workerTitle) {	
		
		 workerRepository.save(new Worker(workerName,workerTitle));		
	     return "redirect:/management";		
    }
	
	
	
	
	
	@RequestMapping(value="/{id}/modify",method=RequestMethod.GET)
	public String modifyWorkerData(@PathVariable int id, Model model) {		
		
		 Worker singleWorker=workerRepository.findById(id).orElse(null);		
		 model.addAttribute("singleWorker",singleWorker);		
		 return "viewManagement/modifyWorkerPage";
	}
	
	
	
	@RequestMapping(value="/updateWorkerData",method=RequestMethod.POST)
	 public String updateData(@RequestParam("singleWorkerId")int singleWorkerId ,
			                                  @RequestParam("singleWorkerName")String singleWorkerName,
			                                  @RequestParam("singleWorkerTitle")String singleWorkerTitle){	
		
		 Worker updatedWorker=workerRepository.findById(singleWorkerId).orElse(null);		 
		 updatedWorker.setTitle(singleWorkerTitle);
		 updatedWorker.setName(singleWorkerName);		 
		 workerRepository.save(updatedWorker);
		
		 return "redirect:/management";	
 }
	

	
	@RequestMapping(value="/{id}/remove",method=RequestMethod.GET)
	public String removeWorker(@PathVariable int id) {		
		
		 workerRepository.deleteById(id);	
		 return "redirect:/management";
	}
}
