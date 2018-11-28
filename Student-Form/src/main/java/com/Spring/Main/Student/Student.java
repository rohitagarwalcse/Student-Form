package com.Spring.Main.Student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Student {
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long Id;
	private String name;
	private String addharNumber;
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddharNumber() {
		return addharNumber;
	}

	public void setAddharNumber(String addharNumber) {
		this.addharNumber = addharNumber;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

}
