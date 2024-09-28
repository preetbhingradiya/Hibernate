package com.mapping.manyToMany;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	private String project_name;
	
	
	//meppedBy menas this will not handele in table of extra it give all reposnsability for Employ class project varible
	@ManyToMany()
	List<Employ> employ;
	
	
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public List<Employ> getEmploy() {
		return employ;
	}

	public void setEmploy(List<Employ> employ) {
		this.employ = employ;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "Project [pid=" + pid + ", project_name=" + project_name + ", employ=" + employ + "]";
	}
	
}
