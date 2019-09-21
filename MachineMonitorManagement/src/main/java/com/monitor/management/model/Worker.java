package com.monitor.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Worker {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int  id;
	
	private String name;	
	private String title;

	
	
	public Worker() {
		super();	
	}

	public Worker(String name, String title) {
		super();
		this.name = name;
		this.title = title;
	}

	public Worker(int id, String name, String title) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
