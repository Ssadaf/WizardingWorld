package tests;


import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

import entities.FinishedCourse;
import entities.Grades;

public class FinishedCourseTest {
	FinishedCourse flying;

	@Test
	public void getStudentsTest() 
	{
		flying = new FinishedCourse("flying" , Grades.O , true);
		Vector<String> students = new Vector<String>();
		students.add("Harry Potter");
		students.add("Ron Weasley");
		students.add("Hermoine Granger");
		students.add("Draco Malfoy");
		flying.setStudentNames(students);
		
		Vector<String> actual = flying.getStudentNames();
		Vector<String> expected = students;
		
		Assert.assertArrayEquals(expected.toArray(), actual.toArray());
	}
	@Test
	public void getProfessorTest() {
		flying = new FinishedCourse("flying", "Madame Hooch", 'O', 1996 , Grades.O , true);
		String expected = "Madame Hooch";
		String actual = flying.getProfessorName();
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void getNameTest() {
		flying = new FinishedCourse("flying", "Madame Hooch", 'O', 1996 , Grades.O , true);
		String expected = "flying";
		String actual = flying.getName();
		
		Assert.assertEquals(expected, actual);
		
	}
	@Test
	public void getMinGradeTest() {
		flying = new FinishedCourse("flying", "Madame Hooch", 'O', 1996, Grades.O , true);
		char expected = 'O';
		char actual = flying.getMinGrade();
		
		Assert.assertEquals(expected, actual);

	}
	@Test
	public void getGrade() {
		flying = new FinishedCourse("flying", "Madame Hooch", 'O', 1996, Grades.O , true);
		Grades expected = Grades.O;
		Grades actual = flying.getGrade();
		
		Assert.assertEquals(expected, actual);

	}
	@Test
	public void getPassed() {
		flying = new FinishedCourse("flying", "Madame Hooch", 'O', 1996, Grades.O , true);
		Boolean expected = true;
		Boolean actual = flying.getPassed();
		
		Assert.assertEquals(expected, actual);

	}
	@Test
	public void setProfessorTest() {
		flying = new FinishedCourse("Flying", Grades.O , true);
		flying.setProfessorName("Madame Hooch");
		String expected = "Madame Hooch";
		String actual = flying.getProfessorName();
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setNameTest() {
		flying = new FinishedCourse("", Grades.O , true);
		flying.setName("Flying");
		String expected = "Flying";
		String actual = flying.getName();
		
		Assert.assertEquals(expected, actual);
		
	}
	@Test
	public void setGrade() {
		flying = new FinishedCourse();
		flying.setGrade(Grades.O);
		Grades expected = Grades.O;
		Grades actual = flying.getGrade();
		
		Assert.assertEquals(expected, actual);
		
	}
}
