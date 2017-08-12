package entities;

import java.util.*;

public class FinishedCourse extends Course{
	private Grades grade; //Grade received 
	private Boolean passed; //Whether or not the student passed the course
	
	//getters and setters
	
	public Grades getGrade() {
		return grade;
	}
	public void setGrade(Grades _grade) {
		grade = _grade;
	}
	public Boolean getPassed() {
		return passed;
	}
	public void setPassed(Boolean _passed) {
		passed = _passed;
	}
	
	
	//constructor
	public FinishedCourse(String _name , String _professorName ,char _minGrade , int _year , Vector<String> _studentNames , Grades _grade , Boolean _passed)
	{
		super(_name , _professorName , _minGrade , _year , _studentNames);
		grade = _grade;
		passed = _passed;
	}
	public FinishedCourse(String _name , String _professorName ,char _minGrade , int _year, Grades _grade , Boolean _passed){
		this(_name , _professorName , _minGrade , _year , null , _grade , _passed);
	}
	public FinishedCourse(String _name, Grades _grade , Boolean _passed){
		this(_name , "" , '0' , 0 , null , _grade , _passed);
	}
	public FinishedCourse(Grades _grade , Boolean _passed){
		this("" , "" , '0' , 0 , null , _grade , _passed);
	}
	public FinishedCourse(){
		this("" , "" , '0' , 0 , null , Grades.T , false);
	}
}
