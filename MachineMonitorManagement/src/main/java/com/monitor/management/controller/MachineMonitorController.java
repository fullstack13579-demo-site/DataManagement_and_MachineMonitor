package com.monitor.management.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.monitor.management.model.Machine;
import com.monitor.management.model.MachineRepository;
import com.monitor.management.model.WorkOrderReport;
import com.monitor.management.model.WorkOrderReportRepository;
import com.monitor.management.model.Worker;
import com.monitor.management.model.WorkerRepository;

@Controller
public class MachineMonitorController {

	@Autowired
	private WorkerRepository workerRepository;
	@Autowired
	private MachineRepository machineRepository;
	@Autowired
	private WorkOrderReportRepository workOrderReportRepository;
	
	private Integer MachineSelected=0;
	private String selectedMachineName;
	
	
	

	@RequestMapping(value="/showMachineList",method=RequestMethod.GET)
	public String showAllMachines(Model model) {
		
		model.addAttribute("machineRepository",machineRepository.findAll());		
		return "viewMonitor/machineList";
	}
	
	
	
	
	@RequestMapping(value="/{id}/repair",method=RequestMethod.GET)
	public String selectWorker(@PathVariable int id) {		
		
		MachineSelected=id;		
		return "redirect:/generateDropDownList";
	}
	
	
	
	@RequestMapping(value="/generateDropDownList",method=RequestMethod.GET)
	public String build(Model model) {		
		
		ArrayList<String> combinationWorkerList=new ArrayList<String>();	
		ArrayList<Worker> workerList=(ArrayList<Worker>) workerRepository.findAll();
			
		String combination="";		
		for(Worker worker:workerList) {
	
			combination=worker.getName()+ "_________" +worker.getTitle();
			combinationWorkerList.add(combination);
		}
		
		model.addAttribute("combinationWorkerList",combinationWorkerList);		
		return "viewMonitor/selectWorkersList";
	}

	
	
	@RequestMapping(value="/createWorkOrderReport", method=RequestMethod.POST)
	public String buildWorkOrderReport(Model model, @RequestParam("selectedAllWorkers") String [] selectedAllWorkers) {	
		
		     Machine selectedMachine=   (Machine) machineRepository.findById(MachineSelected).orElse(null);		     
		     selectedMachineName=selectedMachine.getName();	
		     
		     WorkOrderReport projectReport=new WorkOrderReport();		     
		     projectReport.setNameOfSelectedMachine(selectedMachineName);
		     projectReport.setMachineSelected(MachineSelected);
		     projectReport.setSelectedWorkers(selectedAllWorkers);		   
		     workOrderReportRepository.save(projectReport);
		     
		     
	    model.addAttribute("projectReport",projectReport);
	    return "viewMonitor/workOrderReportForm";
	}
}



