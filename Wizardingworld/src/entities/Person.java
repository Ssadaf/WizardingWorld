package entities;

import java.util.*;

public class Person {
	private String name;
	private String houseName;
	private String bloodStatus;
	private String school;
	private Date birthday;

	public String getName(){
		return name;
	}
	public String getHouseName(){
		return houseName;
	}
	public  String getBloodStatus(){
		return bloodStatus;
	}
	public  String getSchool(){
		return school;
	}
	public Date getBirthday(){
		return birthday;
	}
	
	public void setName(String _name){
		name = _name;
	}
	public void setHouseName(String _houseName){
		houseName = _houseName;
	}
	public  void setBloodStatus(String _bloodStatus){
		bloodStatus = _bloodStatus;
	}
	public  void setSchool(String _school){
		school = _school;
	}
	public void setBirthday(Date _birthday){
		birthday = _birthday;
	}
	
	public Person(String _name , String _houseName , String _bloodStatus , String _school , Date _birthday){
		name = _name;
		houseName = _houseName;
		bloodStatus = _bloodStatus;
		school = _school;
		birthday = _birthday;
	}
	public Person(String _name){
		this(_name , "" , "" , "" ,null);
	}
	public Person(){
		this("" , "" , "" , "" ,null);
	}
	
}
