package com.mapping;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carId;
	
	@OneToOne()  //map for i10 object'
	@JoinColumn(name = "i_10")  //column name of i10 object
	private I10 i10;

	public Car(int carId, I10 i10) {
		super();
		this.carId = carId;
		this.i10 = i10;
	}
	
	public Car() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", i10=" + i10 + "]";
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public I10 getI10() {
		return i10;
	}

	public void setI10(I10 i10) {
		this.i10 = i10;
	}
	
	
}
