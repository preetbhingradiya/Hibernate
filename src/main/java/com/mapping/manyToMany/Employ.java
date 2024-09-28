package com.mapping.manyToMany;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Employ {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	
	
	private String emp_name;
	
	@ManyToMany
	@JoinTable(name = "employ_project", joinColumns = {@JoinColumn(name = "emp_id")}, inverseJoinColumns = {@JoinColumn(name = "pro_id")})
	//change the name ob table and joincolum , inversejoinColumn name
	private List<Project> project;
	
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public Employ() {
		super();
	}

	
	@Override
	public String toString() {
		return "Employ [eid=" + eid + ", emp_name=" + emp_name + ", project=" + project + "]";
	}
	
	
}
