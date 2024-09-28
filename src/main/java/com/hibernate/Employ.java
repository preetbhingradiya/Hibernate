package com.hibernate;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "emp")   // change the name of table
public class Employ {
	

	@Id  //id treate as primary key of table
//	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment strategy 
	
	@GeneratedValue // Use UUID as the generated value
    @Column(columnDefinition = "UUID") 
    private UUID id;
	
	@Column(name = "name", length = 20, nullable = false)
	private String name;
	
	private double salary;
	
	@Column(name = "address", length = 200, nullable = false)
	private String address;
	
	@Column(name = "achievement")
	private Certification certi;
	
	public Employ(UUID id, String name, double salary, String address, Certification certi) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.address = address;
		this.certi = certi;
	}
	
	public Employ() {
		super();
	}


	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Certification getCerti() {
		return certi;
	}

	public void setCerti(Certification certi) {
		this.certi = certi;
	}

	
	
	
	@Override
	public String toString() {
		return "Employ [id=" + id + ", name=" + name + ", salary=" + salary + ", address=" + address + ", certi="
				+ certi + "]";
	}
}
