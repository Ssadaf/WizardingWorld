package entities;

import java.util.*;

public class School {
	private String name;
	private ArrayList<String> houseNames;
	private ArrayList<String> courseNames;
	private ArrayList<Integer> years ;
	private Vector<String> studentNames;
	private Vector<String> professorNames;
	
	public String getName(){
		return name;
	}
	public ArrayList<String> getHouseNames(){
		return houseNames;
	}
	public ArrayList<String> getCourseNames(){
		return courseNames;
	}
	public ArrayList<Integer> getYears(){
		return years;
	}
	public Vector<String> getStudentNames(){
		return studentNames;
	}
	public Vector<String> getProfessorNames(){
		return professorNames;
	}
	
	public void setName(String _name){
		name=_name;
	}
	public void setHouseNames(ArrayList<String> _houseNames){
		houseNames=_houseNames;
	}
	public void setCourseNames(ArrayList<String> _courseNames){
		courseNames=_courseNames;
	}
	public void setYears(ArrayList<Integer> _years){
		years=_years;
	}
	public void setStudentNames(Vector<String> _studentNames){
		studentNames=_studentNames;
	}
	public void setProfessorNames(Vector<String> _professorNames){
		professorNames=_professorNames;
	}

	
	public School(String _name , ArrayList<String> _houseNames , ArrayList<String> _courseNames , ArrayList<Integer> _years , Vector<String> _studentNames , Vector<String> _professorNames){
		name = name;
		houseNames = _houseNames;
		courseNames = _courseNames;
		years = _years;
		studentNames = _studentNames;
		professorNames = _professorNames;
	}
	public School(String _name){
		this(_name , null , null , null , null , null);
	}
	public School(){
		this("" , null , null , null , null , null);
	}
}