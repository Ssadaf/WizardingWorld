package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

import entities.Course;
import entities.House;
import entities.School;
import entities.Student;
import entities.Professor;

public class HouseTest {

	private House Gryffindors;

	@Test
	public void getNameTest()
	{
		Gryffindors = new House("Gryffindors");
		String expected = "Gryffindors";
		String actual = Gryffindors.getName();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void getSchoolTest()
	{
		School hogwarts = new School ("Hogwarts");
		Gryffindors = new House("Gryffindors" , hogwarts );
		School expected = hogwarts;
		School actual = Gryffindors.getSchool();
		Assert.assertEquals(expected, actual);
	}	
	@Test
	public void getStudentsTest()
	{
		Vector<Student> students = new Vector<Student>();
		Student s = new Student("Harry Potter");
		students.add(s);
		Gryffindors = new House("Gryffindors" , null, students, null , null , null);
		
		Vector<Student> actual = Gryffindors.getStudents();
		Vector<Student> expected = students;
		Assert.assertArrayEquals(expected.toArray(), actual.toArray());		
	}
	@Test
	public void getHeadTeacherTest()
	{
		Professor p = new Professor ("Albus Dumbledore");
		Gryffindors = new House("Gryffindors" , null, null, p , null , null);
		Professor actual = Gryffindors.getHeadTeacher();
		Professor expected = p;
		//Assert.assertArrayEquals(expected.toArray(), actual.toArray());

	}
	public void getQualitiesTest()
	{
		 ArrayList<String> q = new ArrayList<String>();
			q.add("Potions");
			q.add("Divination");
			q.add("Magical Creatures");
		Gryffindors = new House("Gryffindors" , null, null, null, q , null);
		ArrayList<String> actual = Gryffindors.getQualities();
		ArrayList<String> expected = q;
		Assert.assertArrayEquals(expected.toArray(), actual.toArray());

	}
	public void getPrefects()
	{
		Map<Integer,Student> map = new HashMap<Integer , Student>();
		Student s = new Student("harry");
		map.put(1998,s);  
		Gryffindors = new House("Gryffindors" , null, null, null, null ,map);
		Map<Integer,Student> actual = Gryffindors.getPrefects();
		Map<Integer,Student> expected = map;
		//Assert.assertArrayEquals(expected.toArray(), actual.toArray());

	}

	

}
