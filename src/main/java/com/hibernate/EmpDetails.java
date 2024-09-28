package com.hibernate;


import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "emp_datails")
public class EmpDetails {
	


	@Id
	@GeneratedValue
	@Column(name = "id")
	private int empDetailsId;
	
	@Column(name = "education", length = 20,  nullable = false)
	private String qualification;
	
	@Column(length = 30, nullable = false)
	private String street;
	
	@Column(length = 30, nullable = false)
	private String city;
	
	@Column(unique = false)
	private boolean profile;
	
	@Transient  //this column us ignore where create table 
	private double x;
		
	@Column(name = "createdAt")
	@Temporal(TemporalType.DATE)  //vlaue of only date
	private java.util.Date addDate;
	
	@Lob   // this image mey be large data or object
	@Column(name = "profileImage")
	private byte[] image;

	public EmpDetails(int empDetailsId, String qualification, String street, String city, boolean profile, double x,
			java.util.Date addDate, byte[] image) {
		super();
		this.empDetailsId = empDetailsId;
		this.qualification = qualification;
		this.street = street;
		this.city = city;
		this.profile = profile;
		this.x = x;
		this.addDate = addDate;
		this.image = image;
	}

	public EmpDetails() {
		super();
	}

	public int getEmpDetailsId() {
		return empDetailsId;
	}

	public void setEmpDetailsId(int empDetailsId) {
		this.empDetailsId = empDetailsId;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isProfile() {
		return profile;
	}

	public void setProfile(boolean profile) {
		this.profile = profile;
	}

	public java.util.Date getAddDate() {
		return addDate;
	}

 	public void setAddDate(java.util.Date addDate) {
		this.addDate = addDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}
	
	
	@Override
	public String toString() {
		return "EmpDetails [empDetailsId=" + empDetailsId + ", qualification=" + qualification + ", street=" + street
				+ ", city=" + city + ", profile=" + profile + ", x=" + x + ", addDate=" + addDate + ", image="
				+ Arrays.toString(image) + "]";
	}

}
