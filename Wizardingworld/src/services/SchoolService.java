package services;

import java.util.*;
import entities.*;
import java.io.*;

public class SchoolService {
    private School school;
    private Vector<School> allSchools;
    
    //getter
    public School getSchool() {
        return school;
    }
    //setter
    public void setSchool(School school) {
        this.school = school;
    }
    //constructors
    public SchoolService(School _school){
        school = _school;
        allSchools = new Vector<School> ();
    }
    public SchoolService(){
        this(null);
    }
    //methods
    public House SortingHat(Student student){
        int Score=0 ; 
        
        //the form to ask questions in orther to find student's suitable  house
        Scanner reader = new Scanner(System.in);
        int input=0;
        System.out.println("please give score to each following items about yourself in the range of (0-10) to help sorting hat to find out which house is suitable for you");
        
        System.out.println("bravery : ");
        input =  reader.nextInt();
        Score += input*2;
        System.out.println("daring : ");
        input =  reader.nextInt();
        Score += input*2;
        System.out.println("nerve : ");
        input =  reader.nextInt();
        Score += input*2;

        System.out.println("hard work : ");
        input =  reader.nextInt();
        Score += input;
        System.out.println("patience : ");
        input =  reader.nextInt();
        Score += input;
        System.out.println("fair play : ");
        input =  reader.nextInt();
        Score += input;
        
        
        System.out.println("intelligence : ");
        input = reader.nextInt();
        Score += input*(-1);
        System.out.println("knowledge : ");
        input = reader.nextInt();
        Score += input*(-1);
        System.out.println("wit : ");
        input = reader.nextInt();
        Score += input*(-1);
        
        System.out.println("ambition : ");
        input = reader.nextInt();
        Score += input*(-2);
        System.out.println("cunning  : ");
        input = reader.nextInt();
        Score += input*(-2);
        System.out.println("resourcefulness  : ");
        input = reader.nextInt();
        Score += input*(-2);
        
        reader.close();
                
        if (Score >= 30 )
        	return school.getHouses().get(0);//"Gryffindor" or house whih is same as gryffindor in qualities should be in 0 index of houses in school array list
        else if( ( (Score < 30) && (Score >= 0)) )
        	return school.getHouses().get(1);//"Hufflepuff" or house whih is same as hufflepuff in qualities should be in 1 index of houses in school array list
        else if( ( (Score < 0) && (Score >= -30)))
        	return school.getHouses().get(2);//"Revenclaw" or house whih is same as revenclaw in qualities should be in 2 index of houses n school array list
        else if( ( Score < -30 )) 	
        	return school.getHouses().get(3);//"Slytherin"or house whih is same as slytherin in qualities should be in 0 index of houses n school array list
        else 
        	return null;
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
				
				//read houses
				sCurrentLine = br.readLine();
				int numHouses = Integer.parseInt(sCurrentLine);
				
				ArrayList<House> houses = new ArrayList<House>();
				for(int i=0 ; i<numHouses ; ++i)
				{
					sCurrentLine = br.readLine();
					houses.add(new House(sCurrentLine));
				}
				
				//read students
				sCurrentLine = br.readLine();
				int numStudents= Integer.parseInt(sCurrentLine);
				
				Vector<Student> students = new Vector<Student>();
				for(int i=0 ; i<numStudents ; ++i)
				{
					sCurrentLine = br.readLine();
					students.add(new Student(sCurrentLine));
				}
				
				
				//read professors
				sCurrentLine = br.readLine();
				int numProfessors= Integer.parseInt(sCurrentLine);
				
				Vector<Professor> professors = new Vector<Professor>();
				for(int i=0 ; i<numProfessors ; ++i)
				{
					sCurrentLine = br.readLine();
					professors.add(new Professor(sCurrentLine));
				}
				
				//read courses
				sCurrentLine = br.readLine();
				int numCourses = Integer.parseInt(sCurrentLine);
				
				ArrayList<Course> courses = new ArrayList<Course>();
				for(int i=0 ; i<numCourses ; ++i)
				{
					sCurrentLine = br.readLine();
					courses.add(new Course(sCurrentLine));
				}
				
				//read location
				String location;
				sCurrentLine = br.readLine();
				location =sCurrentLine;
				
				
				sCurrentLine = br.readLine();
				school = new School(name, students.size(),true, houses, students, professors, courses,location);
				allSchools.add(school);
			}
			for(int i=0 ; i<allSchools.size() ; ++i)
			{
				String s =allSchools.get(i).toString();
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
		    
		    for(int i=0 ; i<allSchools.size() ; i++)
		    {
		    	school = allSchools.get(i);
		    	
		    	//write name
		    	bw.append(school.getName()+"\n");
		    	
		    	//write houses
				int numHouses = school.getHouses().size();
				bw.append(Integer.toString(numHouses)+"\n");
				
				for(int x=0; x<numHouses ;x++)
					bw.append(school.getHouses().get(x).getName()+"\n");
				
				//write students
				int numStudents = school.getStudents().size();
				bw.append(Integer.toString(numStudents)+"\n");
				
				for(int x=0; x<numStudents ;x++)
					bw.append(school.getStudents().get(x).getName()+"\n");
				
				//write professors
				int numProfessors = school.getProfessors().size();
				bw.append(Integer.toString(numProfessors)+"\n");
				
				for(int x=0; x<numProfessors ;x++)
					bw.append(school.getProfessors().get(x).getName()+"\n");
			
				//write courses
				int numCourses = school.getCourses().size();
				bw.append(Integer.toString(numCourses)+"\n");
				
				for(int x=0; x<numCourses ;x++)
					bw.append(school.getCourses().get(x).getName()+"\n");
				
				//write location
		    	bw.append(school.getLocation()+"\n");
				
				//end of school
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
