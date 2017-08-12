package entities;

import java.util.*;

public class House {
	private String name; //House name
	private School school; //the school that has this house
	private Vector<Student> students; //List of students in the house
	private Professor headTeacher; //the house’s head teacher
	private ArrayList<String> qualities; //List of qualities that are required to be in the house
	private Map<Integer,Student> prefects; //the list of prefects of the house per year
	
	//setters and getters
	public String getName() {
		return name;
	}
	public void setName(String _name) {
		name = _name;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School _school) {
		school = _school;
	}
	public Vector<Student> getStudents() {
		return students;
	}
	public void setStudents(Vector<Student> _students) {
		students = _students;
	}
	public Professor getHeadTeacher() {
		return headTeacher;
	}
	public void setHeadTeacher(Professor _headTeacher) {
		headTeacher = _headTeacher;
	}
	public ArrayList<String> getQualities() {
		return qualities;
	}
	public void setQualities(ArrayList<String> _qualities) {
		qualities = _qualities;
	}
	public Map<Integer, Student> getPrefects() {
		return prefects;
	}
	public void setPrefects(Map<Integer, Student> _prefects) {
		prefects = prefects;
	}

	//constructor
	public House(String _name , School _school , Vector<Student> _students , Professor _headTeacher , ArrayList<String> _qualities , Map<Integer,Student> _prefects)
	{
		name = _name;
		school = _school;
		students = _students;
		headTeacher = _headTeacher;
		qualities = _qualities;
		prefects = _prefects;
	}
	public House(String _name , School _school , Vector<Student> _students , Professor _headTeacher)
	{
		this(_name , _school , _students , _headTeacher , null , null);
	}
	public House(String _name , School _school)
	{
		this(_name , _school , null , null , null , null);
	}
	public House(String _name )
	{
		this(_name , null , null , null , null , null);
	}
	public House( )
	{
		this("" , null , null , null , null , null);
	}
}
