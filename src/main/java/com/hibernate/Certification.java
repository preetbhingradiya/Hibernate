package com.hibernate;

import jakarta.persistence.Embeddable;

@Embeddable   //embeddable menas this class all property set where use of this class
public class Certification {

	private String course;
	private String duration;

	public Certification(String course, String duration) {
		super();
		this.course = course;
		this.duration = duration;
	}

	public Certification() {
		super();
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Certification [course=" + course + ", duration=" + duration + "]";
	}

}
