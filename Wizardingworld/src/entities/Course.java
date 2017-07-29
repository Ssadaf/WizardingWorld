package entities;

import java.util.*;

public class Course {
	private String name;
	private String professorName;
	private char minGrade;
	private int year;
	private Vector<String> studentNames;	
	
	public String getName(){
		return name;
	}
	public String getProfessorName(){
		return professorName; 
	}
	public char getMinGrade(){
		return minGrade;
	}
	public int getYear(){
		return year;
	}
	public Vector<String> getStudentNames(){
		return studentNames;
	}
	
	public void setName(String _name){
		name = _name;
	}
	public void setProfessorName(String _professorName){
		professorName = _professorName; 
	}
	public void setMinGrade(char _minGrade){
		minGrade = _minGrade;
	}
	public void setYear(int _year){
		year = _year;
	}
	public void setStudentNames(Vector<String> _studentNames){
		studentNames = _studentNames;
	}
	
	public Course(String _name , String _professorName ,char _minGrade , int _year , Vector<String> _studentNames){
		name = _name;
		professorName = _professorName;
		minGrade = _minGrade;
		studentNames = _studentNames;
	}
	public Course(String _name , String _professorName ,char _minGrade , int _year){
		this(_name , _professorName , _minGrade , _year , null);
	}
	public Course(String _name){
		this(_name , "" , '0' , 0 , null);
	}
	public Course(){
		this("" , "" , '0' , 0 , null);
	}
}