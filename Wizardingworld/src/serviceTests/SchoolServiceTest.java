package serviceTests;

import java.util.ArrayList;
import java.util.Vector;

import entities.*;
import services.*;

public class SchoolServiceTest {
	public void runTests()
	{
		//As a helper arraylist of houses 
		ArrayList<House> houses = new  ArrayList<House>();
		houses.add(new House ("Gryffindor" ,  null));
		houses.add(new House("Hufflepuff" , null));
		houses.add(new House("Revenclaw" , null));
		houses.add(new House("Slytherin" , null));
		
		//a helper school
		School school = new School("Hogwarts", 1000, true,  houses,	null, null, null, "london");
		
		//the school service we are testing on it
		SchoolService schoolService = new SchoolService(school);
		
		//Printing the results of the tests of GETTERS and SETTERS
		System.out.println("GET SCHOOL  " + testgetSchool(schoolService, school));
		System.out.println("SET SCHOOL  " + testsetSchool(schoolService));
		System.out.println("SORTING HAT  " + testsortingHat(schoolService));
	
	}
	public boolean testgetSchool(SchoolService schoolService, School expected){
		School actual = schoolService.getSchool();
		
		if(actual.equals(expected))
			return true;
		return false;
	}
	public boolean testsetSchool(SchoolService schoolService)
	{
		//As a helper arraylist of houses 
		ArrayList<House> houses = new  ArrayList<House>();
		houses.add(new House ("Gryffindor" ,  null));
		houses.add(new House("Hufflepuff" , null));
		houses.add(new House("Revenclaw" , null));
		houses.add(new House("Slytherin" , null));
		
		School expected = new School("alami", 100, true,  houses,	null, null, null, "london");
		schoolService.setSchool(expected);
		School actual = schoolService.getSchool();
		if(actual.equals(expected))
			return true;				
		return false;
	}
	public String testsortingHat(SchoolService schoolService)
	{
		Student student = new Student("Harry Potter");
		House actual = schoolService.SortingHat(student);
		return actual.getName();
	}

}
