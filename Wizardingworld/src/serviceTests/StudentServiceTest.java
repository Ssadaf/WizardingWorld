package serviceTests;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import entities.*;
import services.*;

public class StudentServiceTest {
	public void runTests()
	{
		//helper student
		Student student = new Student("Harry Potter");
		
		//the student service we are testing on it
		StudentService studentService = new StudentService(student);
		
		//Printing the results of the tests of GETTERS and SETTERS
		System.out.println("GET COURSE  " + testgetStudent(studentService, student));
		System.out.println("SET COURSE  " + testsetStudent(studentService));
		System.out.println("SET COURSE  " + testSortToHouse(studentService));
	}
	public boolean testgetStudent(StudentService studentService, Student expected){
		Student actual = studentService.getStudent();
		
		if(actual.equals(expected))
			return true;
		return false;
	}
	public boolean testsetStudent(StudentService studentService)
	{
		Student expected = new Student("Ron Weasley");
		studentService.setStudent(expected);
		Student actual = studentService.getStudent();
		if(actual.equals(expected))
			return true;				
		return false;
	}
	public boolean testSortToHouse(StudentService studentService)
	{
		//helper house
		Vector<Student> students = new Vector<Student>();
		students.add(new Student("Luna Lovegood"));
		students.add(new Student("Cho Chang"));

		ArrayList<String> qualities = new ArrayList<String>();
		qualities.add("Intelligence");
		qualities.add("Knowledge");
		qualities.add("Wit");
		
		Map<Integer, Student> prefects = new TreeMap<Integer, Student>();
		prefects.put(1995, new Student("Not Sure!"));
		prefects.put(1995, new Student("Don't know"));
		prefects.put(1996, new Student("Someone"));
		prefects.put(1996, new Student("Probably Cho?"));

		House expected = new House("Raven Claw", new School("Hogwarts", true, "England"),students, new Professor("Finnius Flitwik"), qualities, prefects);
		studentService.sortToHouse(expected);
		House actual = studentService.getStudent().getHouse();
		if(actual.equals(expected))
			return true;
		return false;
	}
}
