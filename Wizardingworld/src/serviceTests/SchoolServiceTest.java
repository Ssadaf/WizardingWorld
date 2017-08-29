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
		
		//As a helper vector for testing , we make the students vector and add elements
		Vector<Student> students = new Vector<Student>();
		students.add(new Student("Harry Potter"));
		students.add(new Student("Ron Weasley"));
		students.add(new Student("Hermoine Granger"));
		students.add(new Student("Draco Malfoy"));
		students.add(new Student("Luna Lovegood"));

		//As a helper vector for testing , we make the profs vector and add elements
		Vector<Professor> professors = new Vector<Professor>();
		professors.add(new Professor("prof"));

		//As a helper vector for testing , we make the courses vector and add elements
		ArrayList<Course> courses = new ArrayList<Course>();
		courses.add(new Course("Flying"));
		
		//a helper school
		School school = new School("Hogwarts", 1000, true,  houses,	null, null, null, "london");
		School myschool = new School("MySchool" , 1000 , true , houses , students , professors , courses , "nowhere");
		School changedschool = new School("MySchool" , 1000 , true , houses , students , professors , courses , "somewhere");
		
		//the school service we are testing on it
		SchoolService schoolService = new SchoolService(school);
		
		//Printing the results of the tests of GETTERS and SETTERS
		System.out.println("GET SCHOOL  " + testgetSchool(schoolService, school));
		System.out.println("SET SCHOOL  " + testsetSchool(schoolService));
		//System.out.println("SORTING HAT  " + testsortingHat(schoolService));
		
		SchoolService schoolService2 = new SchoolService();
		schoolService2.getData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/SchoolDB.txt");
		try
		{
			System.out.println("####### SHOW ALL SCHOOLS TEST:\n");
			schoolService2.showAllSchools();
			System.out.println("####### SHOW SCHOOL Hogwarts:\n");
			schoolService2.showSchool("Hogwarts");
			//check them by commenting line after each one for example for checking create school you should comment the other 2 lines after it
			schoolService2.createNewSchool(myschool);
			schoolService2.editSchool("MySchool", changedschool);
			//schoolService2.deleteSchool(changedschool);
			
		}catch(NotFoundException ex){
			System.out.println("this student cannot does not exist");
			
		}
	
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
