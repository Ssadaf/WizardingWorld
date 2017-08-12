package entities;

import java.util.*;

public class Professor extends Person {
	private Map < Integer , Course > courses;//The list of courses and the year he/she taught them
	private String notes; ////If he/she has any special abilities or something noteworthy it is mentioned here
	
	//getters
	public Map<Integer, Course> getCourses() {
		return courses;
	}
	public String getNotes() {
		return notes;
	}
	//setters
	public void setCourses(Map<Integer, Course> _courses) {
		courses = _courses;
	}
	public void setNotes(String _notes) {
		notes = _notes;
	}
	//constructors
	public Professor(String _name , String _houseName , String _bloodStatus , String _school , Date _birthday , Map <Integer , Course> _courses , String _notes)
	{
		super(_name , _houseName , _bloodStatus , _school ,_birthday);
		courses = _courses;
		notes = _notes;
	}
	public Professor(String _name , String _houseName , String _bloodStatus , String _school , Date _birthday , Map <Integer , Course> _courses )
	{
		this( _name , _houseName , _bloodStatus , _school , _birthday , _courses , "");
	}
	public Professor(String _name , String _houseName , String _bloodStatus , String _school , Date _birthday )
	{
		this( _name , _houseName , _bloodStatus , _school , _birthday , null , "");
	}
	public Professor(String _name , Map <Integer , Course> _courses){
		this(_name , "" , "" , "" ,null , _courses , "");
	}
	public Professor(String _name){
		this(_name , "" , "" , "" ,null , null , "");
	}
	public Professor(){
		this("" , "" , "" , "" ,null , null , "");
	}
}
