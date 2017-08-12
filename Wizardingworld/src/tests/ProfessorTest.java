package tests;

import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

import entities.Professor;
import entities.Course;

public class ProfessorTest {
	Professor snape;
	@Test
	public void getNameTest()
	{
		snape = new Professor("Severus Snape");
		
		String actual = snape.getName();
		String expected = "Severus Snape";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void getHouseTest() throws ParseException
	{
		DateFormat formatter = new SimpleDateFormat("d-MM-yyyy"); 
		snape = new Professor("Severus Snape", "Slytherin", "half-blood", "Hogwarts", formatter.parse("9-01-1960"));
		String actual = snape.getHouseName();
		String expected = "Slytherin";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void getBloodStatusTest() throws ParseException
	{
		DateFormat formatter = new SimpleDateFormat("d-MM-yyyy"); 
		snape = new Professor("Severus Snape", "Slytherin", "half-blood", "Hogwarts", formatter.parse("9-01-1960"));
		
		String actual = snape.getBloodStatus();
		String expected = "half-blood";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void getSchoolTest() throws ParseException
	{
		DateFormat formatter = new SimpleDateFormat("d-MM-yyyy"); 
		snape = new Professor("Severus Snape", "Slytherin", "half-blood", "Hogwarts", formatter.parse("9-01-1960"));		
		String actual = snape.getSchool();
		String expected = "Hogwarts";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void getCourses() throws ParseException
	{
		DateFormat formatter = new SimpleDateFormat("d-MM-yyyy"); 
		Map<Integer,Course> map = new HashMap<Integer,Course>();  
		Course flying = new Course("flying");
		map.put(1998,flying);  
		snape = new Professor("Severus Snape", "Slytherin", "half-blood", "Hogwarts", formatter.parse("9-01-1960") , map );		
		Map<Integer,Course> actual = snape.getCourses();
		Map<Integer,Course> expected = map;
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void getNotes() throws ParseException
	{
		DateFormat formatter = new SimpleDateFormat("d-MM-yyyy"); 
		Map<Integer,Course> map = new HashMap<Integer,Course>();  
		Course flying = new Course("flying");
		map.put(1998,flying);  
		snape = new Professor("Severus Snape", "Slytherin", "half-blood", "Hogwarts", formatter.parse("9-01-1960") , map , "has decipline");		
		String actual = snape.getNotes();
		String expected = "has decipline";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setNameTest()
	{
		snape = new Professor("");
		snape.setName("Severus Snape");
		String actual = snape.getName();
		String expected = "Severus Snape";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setHouseTest()
	{
		snape = new Professor("Severus Snape");
		snape.setHouseName("Slytherin");
		String actual = snape.getHouseName();
		String expected = "Slytherin";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setBloodStatusTest()
	{
		snape = new Professor("Severus Snape");
		snape.setBloodStatus("Half-Blood");
		String actual = snape.getBloodStatus();
		String expected = "Half-Blood";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setSchoolTest()
	{
		snape = new Professor("Severus Snape");
		snape.setSchool("Hogwarts");
		String actual = snape.getSchool();
		String expected = "Hogwarts";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setCourses()
	{
		snape = new Professor("Severus Snape");
		Map<Integer,Course> map = new HashMap<Integer,Course>();  
		Course flying = new Course("flying");
		map.put(1998,flying);  
		snape.setCourses(map);
		Map<Integer,Course> actual = snape.getCourses();
		Map<Integer,Course> expected = map;
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setNotes()
	{
		snape = new Professor("Severus Snape");
		snape.setNotes("has decipline");
		String actual = snape.getNotes();
		String expected = "has decipline";
		
		Assert.assertEquals(expected, actual);
	}

}
