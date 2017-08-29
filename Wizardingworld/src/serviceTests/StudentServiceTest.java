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
		School hogwarts = new School("Hogwarts", true, "England");
		House house = new House("Slytherin", hogwarts);
		//helper student
		Student student = new Student("Harry Potter");
		Student sadaf = new Student("sadaf" , house ,BloodStatus.Half_blood , hogwarts , "22.06.1998" , new Vector<Course> ());
		Student changedSadaf = new Student("sadaf" , house ,BloodStatus.Muggle , hogwarts , "22.06.1998" , new Vector<Course> ());
		
		//the student service we are testing on it
		StudentService studentService = new StudentService(student);
		
		//Printing the results of the tests of GETTERS and SETTERS
		System.out.println("GET COURSE  " + testgetStudent(studentService, student));
		System.out.println("SET COURSE  " + testsetStudent(studentService));
		System.out.println("SET COURSE  " + testSortToHouse(studentService));
		
		StudentService studentService2 = new StudentService();
		studentService2.getData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/StudentDB.txt");
		try
		{
			System.out.println("####### SHOW ALL STUDENTS TEST:\n");
			studentService2.showAllStudents();
			System.out.println("####### SHOW STUDENT Fleur Delacour:\n");
			studentService2.showStudenet("Fleur Delacour");
			//check them by commenting line after each one for example for checking create student you should comment the other 2 lines after it
			studentService2.createNewStudent(sadaf);
			studentService2.editStudent("sadaf", changedSadaf);
			studentService2.deleteStudent(changedSadaf);
			
			
		}catch(NotFoundException ex){
			System.out.println("this student cannot does not exist");
			
		}
		
		
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
