package com.monitor.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class WorkOrderReport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int  id;
	
	private long machineSelected;	
	private String nameOfSelectedMachine;	
	private String [] selectedWorkers;
	
	

	public WorkOrderReport() {
		super();		
	}

	public WorkOrderReport(int id, long machineSelected, String nameOfSelectedMachine, String[] selectedWorkers) {
		super();
		this.id = id;
		this.machineSelected = machineSelected;
		this.nameOfSelectedMachine = nameOfSelectedMachine;
		this.selectedWorkers = selectedWorkers;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public long getMachineSelected() {
		return machineSelected;
	}



	public void setMachineSelected(long machineSelected) {
		this.machineSelected = machineSelected;
	}



	public String getNameOfSelectedMachine() {
		return nameOfSelectedMachine;
	}



	public void setNameOfSelectedMachine(String nameOfSelectedMachine) {
		this.nameOfSelectedMachine = nameOfSelectedMachine;
	}



	public String[] getSelectedWorkers() {
		return selectedWorkers;
	}



	public void setSelectedWorkers(String[] selectedWorkers) {
		this.selectedWorkers = selectedWorkers;
	}

}
