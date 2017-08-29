package serviceTests;

import java.util.Vector;

import entities.*;
import services.*;

public class CourseServiceTest {
	public void runTests()
	{
		//As a helper vector for testing the course, we make the students vector and add elements
		Vector<Student> students = new Vector<Student>();
		students.add(new Student("Harry Potter"));
		students.add(new Student("Ron Weasley"));
		students.add(new Student("Hermoine Granger"));
		students.add(new Student("Draco Malfoy"));
		students.add(new Student("Luna Lovegood"));

		//The helper course 
		Course course = new Course("SpecialCourse", Grades.O, new Professor("Madame Hooche"), 1994, students);
		Course changedCourse = new Course("SpecialCourse", Grades.A, new Professor("Madame Hooche"), 1994, students);
		
		//the course service we are testing on it
		CourseService courseService = new CourseService(course);
		
		
		//Printing the results of the tests of GETTERS and SETTERS
		System.out.println("GET COURSE  " + testgetCourse(courseService, course));
		System.out.println("SET COURSE  " + testsetCourse(courseService));
		
		CourseService courseService2 = new CourseService();
		courseService2.getData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/CourseDB.txt");
		try
		{
			System.out.println("####### SHOW ALL COURSES TEST:\n");
			courseService2.showAllCourses();
			System.out.println("####### SHOW COURSE Potions:\n");
			courseService2.showCourse("Potions");
			//check them by commenting line after each one for example for checking create course you should comment the other 2 lines after it
			courseService2.createNewCourse(course);
			courseService2.editCourse("SpecialCourse", changedCourse);
			courseService2.deleteCourse(changedCourse);
			
			
		}catch(NotFoundException ex){
			System.out.println("this student cannot does not exist");
			
		}
	
	}
	public boolean testgetCourse(CourseService courseService, Course expected){
		Course actual = courseService.getCourse();
		
		if(actual.equals(expected))
			return true;
		return false;
	}
	public boolean testsetCourse(CourseService courseService)
	{
		Vector<Student> students = new Vector<Student>();
		students.add(new Student("Harry Potter"));
		students.add(new Student("Ron Weasley"));
		Course expected = new Course("Dark arts", Grades.O, new Professor("Madame Hooche"), 1994, students);
		courseService.setCourse(expected);
		Course actual = courseService.getCourse();
		if(actual.equals(expected))
			return true;				
		return false;
	}
}
