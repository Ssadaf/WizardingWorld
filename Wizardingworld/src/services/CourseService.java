package services;

import java.io.*;
import java.util.* ;
import entities.*;

public class CourseService {
	private Course course;
	private Vector<Course> allCourses;
	
	//getter
	public Course getCourse() {
		return course;
	}
	//setter
	public void setCourse(Course course) {
		this.course = course;
	}
	//constructor
	public CourseService(Course _course){
		course = _course;
		allCourses=new Vector<Course> (); 
	}
	public CourseService(){
		this(null);
	}
	
	//methods
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
				
				//read mingrade
				sCurrentLine = br.readLine();
				Grades minGrade = Grades.valueOf(sCurrentLine);
				
				
				//read professor
				sCurrentLine = br.readLine();
				Professor professor = new Professor(sCurrentLine);
				
				//read year
				sCurrentLine = br.readLine();
				int year = Integer.parseInt(sCurrentLine);
				
				//read students
				sCurrentLine = br.readLine();
				int numStudents = Integer.parseInt(sCurrentLine);
				
				Vector<Student> students = new Vector<Student>();
				for(int i=0 ; i<numStudents ; ++i)
				{
					sCurrentLine = br.readLine();
					students.add(new Student(sCurrentLine));
				}
				sCurrentLine = br.readLine();
				course = new Course(name, minGrade, professor, year , students);
				allCourses.add(course);
			}
			for(int i=0 ; i<allCourses.size() ; ++i)
			{
				String s =allCourses.get(i).toString();
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
		    
		    for(int i=0 ; i<allCourses.size() ; i++)
		    {
		    	course = allCourses.get(i);
		    	
		    	//write name
		    	bw.append(course.getName()+"\n");
		    	
		    	//write mingrade
				Grades minGrade = course.getMinGrade();
				switch(minGrade)
				{
				case O:
					{
						bw.append("O"+"\n");
						break;
					}
				case E:
					{
						bw.append("E"+"\n");
						break;
					}
				case A:
					{
						bw.append("A"+"\n");
						break;
					}
				case P:
					{
						bw.append("P"+"\n");
						break;
					}
				case T:
					{
						bw.append("T"+"\n");
						break;
					}
				}
				
				//write professor
				bw.append(course.getProfessor().getName()+"\n");
				
				//write year
				bw.append(Integer.toString(course.getYear())+"\n");
				
				//write students
				int numStudents = course.getStudents().size();
				bw.append(Integer.toString(numStudents)+"\n");
				
				for(int x=0; x<numStudents ;x++)
					bw.append(course.getStudents().get(x).getName()+"\n");
				
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
	
	public void showAllCourses()
	{
		for(int i=0 ; i<allCourses.size() ; ++i)
		{
			String s =allCourses.get(i).toString();
			System.out.println(s);
		}
	}
	
	public Course searchByName(String name) throws NotFoundException
	{
		for(int i=0 ; i<allCourses.size() ; ++i)
		{
			if(allCourses.get(i).getName().equals(name))
			{
				return allCourses.get(i);
			}
		}
		throw new NotFoundException();
	}
	
	public void showCourse(String name) throws NotFoundException
	{
		Course course = searchByName(name);
		String s =course.toString();
		System.out.println(s);
	}
	
	public void createNewStudent(Course course)
	{
		allCourses.add(course);
		setData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/Coursetest.txt");
	}
	
	public void deleteCourse(Course course)
	{
		if(!allCourses.remove(course))
			System.out.println("this course does not exist");
		setData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/Coursetest.txt");
	}
	
	public void editCourse(String name , Course newcourse) throws NotFoundException
	{
		Course prevcourse = searchByName(name);
		allCourses.remove(prevcourse);
		allCourses.add(newcourse);
		setData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/Coursetest.txt");
	}


}