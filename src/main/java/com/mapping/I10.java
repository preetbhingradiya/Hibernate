package com.mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.validation.constraints.Size;

@Entity
public class I10 {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "model", length = 20)
	private String model;
	
	private String engine;
	
	@Size(min = 2, max = 8)
	private int seats;
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public I10(int id, String model, String engine, @Size(min = 2, max = 50) int seats) {
		super();
		this.id = id;
		this.model = model;
		this.engine = engine;
		this.seats = seats;
	}
	
	

	public I10() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "I10 [id=" + id + ", model=" + model + ", engine=" + engine + ", seats=" + seats + "]";
	}

	
}
