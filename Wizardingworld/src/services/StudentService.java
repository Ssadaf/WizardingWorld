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
				sCurrentLine = br.readLine();
				BloodStatus bloodStatus = BloodStatus.valueOf(sCurrentLine);
				
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
				switch(bloodStatus)
				{
					case Muggle:
					{
						bw.append("Muggle"+"\n");
						break;
					}
					case Muggle_born:
					{
						bw.append("Muggle_born"+"\n");
						break;
					}
					case Half_blood:
					{
						bw.append("Half_blood"+"\n");
						break;
					}
					case Pure_blood:
					{
						bw.append("Pure_blood"+"\n");
						break;
					}
					case Squib:
					{
						bw.append("Squib"+"\n");
						break;
					}
					case Half_breed:
					{
						bw.append("Half_breed"+"\n");
						break;
					}
				}
				
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
	
	public void showAllStudents()
	{
		for(int i=0 ; i<allStudents.size() ; ++i)
		{
			String s =allStudents.get(i).toString();
			System.out.println(s);
		}
		
	}
	
	public Student searchByName(String name) throws NotFoundException
	{
		for(int i=0 ; i<allStudents.size() ; ++i)
		{
			if(allStudents.get(i).getName().equals(name))
			{
				return allStudents.get(i);
			}
		}
		throw new NotFoundException();
	}
	
	public void showStudenet(String name) throws NotFoundException
	{
		Student student = searchByName(name);
		String s =student.toString();
		System.out.println(s);
	}
	
	public void createNewStudent(Student student)
	{
		allStudents.add(student);
		setData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/StudentDB.txt.txt");
	}
	
	public void deleteStudent(Student student)
	{
		if(!allStudents.remove(student))
			System.out.println("this student does not exist");
		setData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/StudentDB.txt");
	}
	
	public void editStudent(String name , Student newstudent) throws NotFoundException
	{
		Student prevstudent = searchByName(name);
		allStudents.remove(prevstudent);
		allStudents.add(newstudent);
		setData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/StudentTest.txt");
	}
}
