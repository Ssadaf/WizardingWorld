package entities;

import java.util.*;

public class Student extends Person {
	private Vector <Course> courses;
	private Vector <FinishedCourse> reportCard;
	
	//setters and getters
	public Vector<Course> getCourses() {
		return courses;
	}
	public void setCourses(Vector<Course> _courses) {
		courses = _courses;
	}
	public Vector<FinishedCourse> getReportCard() {
		return reportCard;
	}
	public void setReportCard(Vector<FinishedCourse> _reportCard) {
		reportCard = _reportCard;
	}
	
	//constructor
	public Student(String _name , String _houseName , String _bloodStatus , String _school , Date _birthday , Vector <Course> _courses , Vector <FinishedCourse> _reportCard){
		super(_name ,_houseName , _bloodStatus , _school , _birthday);
		courses = _courses;
		reportCard = _reportCard;
	}
	public Student(String _name, Vector <Course> _courses , Vector <FinishedCourse> _reportCard){
		this(_name , "" , "" , "" ,null ,_courses , _reportCard);
	}
	public Student(){
		this("" , "" , "" , "" ,null , null , null);
	}
}
