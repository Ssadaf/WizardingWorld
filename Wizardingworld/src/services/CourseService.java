package services;

import entities.*;

public class CourseService {
	private Course course;
	
	//getter
	public Course getCourse() {
		return course;
	}
	//setter
	public void setCourse(Course course) {
		this.course = course;
	}
	//constructor
	public CourseService(Course _course){
		course = _course;
	}
	public CourseService(){
		this(null);
	}
}
