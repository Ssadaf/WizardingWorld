package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import entities.*;

public class StudentService {	
	private Student student;
	private Vector<Student> allStudents;
	
	//getter
	public Student getStudent() {
		return student;
	}
	//setter
	public void setStudent(Student student) {
		this.student = student;
	}
	//constructor
	public StudentService(Student _student){
		student = _student;
		allStudents = new Vector<Student> ();
	}
	public StudentService(){
		this(null);
	}
	//methods
	public void sortToHouse(House house){
		student.setHouse(house);
	}
	
	
	
	public void getData(String filename)
    {
    	BufferedReader br = null;
		FileReader fr = null;

		try {

			br = new BufferedReader(new FileReader(filename));
			
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null && sCurrentLine.length() != 0) {
				//read name
				String name = sCurrentLine ; 
				
				//read house
				sCurrentLine = br.readLine();
				House house = new House(sCurrentLine);
				
				//read blood status
				BloodStatus bloodStatus = BloodStatus.Muggle;
				sCurrentLine = br.readLine();
				if(sCurrentLine == "Muggle")
					bloodStatus = BloodStatus.Muggle;
				else if(sCurrentLine == "Muggle_born")
					bloodStatus = BloodStatus.Muggle_born;
				else if(sCurrentLine == "Half_blood")
					bloodStatus = BloodStatus.Half_blood;
				else if(sCurrentLine == "Pure_blood")
				bloodStatus = BloodStatus.Pure_blood;
				else if(sCurrentLine == "Squib")
					bloodStatus = BloodStatus.Squib;
				else if(sCurrentLine == "Half_breed")
					bloodStatus = BloodStatus.Half_breed;
				
				//read school
				sCurrentLine = br.readLine();
				School school = new School(sCurrentLine);
				
				//read birthday
				sCurrentLine = br.readLine();
				String birthDay = sCurrentLine;
				
				//read courses
				sCurrentLine = br.readLine();
				int numCourses = Integer.parseInt(sCurrentLine);
				
				Vector<Course> courses = new Vector<Course>();
				for(int i=0 ; i<numCourses ; ++i)
				{
					sCurrentLine = br.readLine();
					courses.add(new Course(sCurrentLine));
				}
				
				sCurrentLine = br.readLine();
				student = new Student(name,house,bloodStatus , school , birthDay , courses);
				allStudents.add(student);
			}
			for(int i=0 ; i<allStudents.size() ; ++i)
			{
				String s =allStudents.get(i).toString();
				System.out.println(s);
			}
		

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

	public void setData(String filename)
	{
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
		     bw = new BufferedWriter(new FileWriter(filename));
		    
		    bw.write("");
		    
		    for(int i=0 ; i<allStudents.size() ; i++)
		    {
		    	student = allStudents.get(i);
		    	
		    	//write name
		    	bw.append(student.getName()+"\n");
		    	
		    	//write house
		    	bw.append(student.getHouse().getName()+"\n");
		    	
		    	//write blood status
				BloodStatus bloodStatus = student.getBloodStatus();
				if(bloodStatus == BloodStatus.Muggle)
					bw.append("Muggle"+"\n");
				else if(bloodStatus == BloodStatus.Muggle_born)
					bw.append("Muggle_born"+"\n");
				else if(bloodStatus == BloodStatus.Half_blood)
					bw.append("Half_blood"+"\n");
				else if(bloodStatus == BloodStatus.Pure_blood)
					bw.append("Pure_blood"+"\n");
				else if(bloodStatus == BloodStatus.Squib)
					bw.append("Squib"+"\n");
				else if(bloodStatus == BloodStatus.Half_breed)
					bw.append("Half_breed"+"\n");
				
				//write school
				bw.append(student.getSchool().getName()+"\n");
				
				//write birthday
				bw.append(student.getBirthday()+"\n");
				
				//write courses
				int numCourses = student.getCourses().size();
				bw.append(Integer.toString(numCourses)+"\n");
				
				for(int x=0; x<numCourses ;x++)
					bw.append(student.getCourses().get(x).getName()+"\n");
				
				//end of course
				bw.append("*"+"\n");
				
		    }
		     
		    
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}
}
