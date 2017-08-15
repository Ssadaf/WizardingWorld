package services;

import entities.*;

public class StudentService {	
	private Student student;
	
	//getter
	public Student getStudent() {
		return student;
	}
	//setter
	public void setStudent(Student student) {
		this.student = student;
	}
	//constructor
	public StudentService(Student _student){
		student = _student;
	}
	public StudentService(){
		this(null);
	}
	//methods
	public void sortToHouse(House house){
		student.setHouse(house);
	}

}
