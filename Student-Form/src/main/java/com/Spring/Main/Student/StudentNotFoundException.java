package com.Spring.Main.Student;

public class StudentNotFoundException extends Exception {
	Long id;
	public StudentNotFoundException(long id2) {
			System.out.println(id2 + " does not exist");
	}
	
	
}
