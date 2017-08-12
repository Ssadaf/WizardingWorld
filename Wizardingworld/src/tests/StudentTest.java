package tests;

import static org.junit.Assert.*;

import java.util.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

import entities.Student;
import entities.Course;
import entities.FinishedCourse;

public class StudentTest {

	Student harry;
	@Test
	public void getNameTest()
	{
		harry = new Student("Harry Potter" );
		
		String actual = harry.getName();
		String expected = "Harry Potter";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void getHouseTest() throws ParseException
	{
		DateFormat formatter = new SimpleDateFormat("d-MM-yyyy"); 
		Vector < FinishedCourse> fc = new Vector <FinishedCourse>();
		FinishedCourse fco=new FinishedCourse();
		fc.add(fco);
		Vector < Course> c = new Vector <Course>();
		Course co=new Course("flying");
		c.add(co);
		harry = new Student("Harry Potter", "Gryffindor", "pureblood", "Hogwarts", formatter.parse("9-01-1960") , c , fc);
		String actual = harry.getHouseName();
		String expected = "Gryffindir";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void getBloodStatusTest() throws ParseException
	{
		DateFormat formatter = new SimpleDateFormat("d-MM-yyyy");
		Vector < FinishedCourse> fc = new Vector <FinishedCourse>();
		FinishedCourse fco=new FinishedCourse();
		fc.add(fco);
		Vector < Course> c = new Vector <Course>();
		Course co=new Course("flying");
		c.add(co);
		harry = new Student("Harry Potter", "Gryffindor", "pureblood", "Hogwarts", formatter.parse("9-01-1960") , c , fc);
	
		
		String actual = harry.getBloodStatus();
		String expected = "pureblood";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void getSchoolTest() throws ParseException
	{
		DateFormat formatter = new SimpleDateFormat("d-MM-yyyy"); 
		Vector < FinishedCourse> fc = new Vector <FinishedCourse>();
		FinishedCourse fco=new FinishedCourse();
		fc.add(fco);
		Vector < Course> c = new Vector <Course>();
		Course co=new Course("flying");
		c.add(co);
		harry = new Student("Harry Potter", "Gryffindor", "pureblood", "Hogwarts", formatter.parse("9-01-1960") , c , fc);
	
		String actual = harry.getSchool();
		String expected = "Hogwarts";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setNameTest()
	{
		harry = new Student("");
		harry.setName("Harry Potter");
		String actual = harry.getName();
		String expected = "Harry Potter";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setHouseTest()
	{
		harry = new Student("Harry Potter");
		harry.setHouseName("Slytherin");
		String actual = harry.getHouseName();
		String expected = "Slytherin";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setBloodStatusTest()
	{
		harry = new Student("Harry Potter");
		harry.setBloodStatus("Half-Blood");
		String actual = harry.getBloodStatus();
		String expected = "Half-Blood";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setSchoolTest()
	{
		harry = new Student("Harry Potter");
		harry.setSchool("Hogwarts");
		String actual = harry.getSchool();
		String expected = "Hogwarts";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setCoursesTest()
	{
		harry = new Student("Harry Potter");
		Vector < Course> c = new Vector <Course>();
		Course co=new Course("flying");
		c.add(co);
		harry.setCourses(c);
		Vector < Course> actual = harry.getCourses();
		Vector < Course> expected = c;
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setReportCardTest()
	{
		harry = new Student("Harry Potter");
		Vector < FinishedCourse> fc = new Vector <FinishedCourse>();
		FinishedCourse fco=new FinishedCourse();
		fc.add(fco);
		harry.setReportCard(fc);
		Vector < FinishedCourse> actual = harry.getReportCard();
		Vector < FinishedCourse> expected = fc;
		
		Assert.assertEquals(expected, actual);
	}


}
