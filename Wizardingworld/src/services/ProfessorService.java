package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import entities.*;

public class ProfessorService {
	private Professor professor;
	private Vector<Professor> allProfessors;
	
	//constructor
	public ProfessorService(Professor _professor)
	{
		professor = _professor;
		allProfessors = new Vector<Professor> ();
	}
	public ProfessorService()
	{
		this(null);
	}
	//getter and setter
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor _professor) {
		professor = _professor;
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
					
					//read house
					sCurrentLine = br.readLine();
					House house=new House(sCurrentLine);
					
					//read blood status
					sCurrentLine = br.readLine();
					BloodStatus bloodStatus = BloodStatus.valueOf(sCurrentLine);
					
					//read school
					sCurrentLine = br.readLine();
					School school=new School(sCurrentLine);
					
					//read birthday
					sCurrentLine = br.readLine();
					String birthday=sCurrentLine;
					
					//read course
					
					TreeMap<Integer, Course> courses = new TreeMap<Integer, Course>();
					sCurrentLine = br.readLine();
					Course course = new Course(sCurrentLine);
					sCurrentLine = br.readLine();
					int year = Integer.parseInt(sCurrentLine);
					courses.put(year , course);
					
					
					//read notes
					sCurrentLine = br.readLine();
					String notes=sCurrentLine;

					sCurrentLine = br.readLine();
					professor = new Professor(name, house,bloodStatus, school, birthday ,courses ,notes);
					allProfessors.add(professor);
				}
				for(int i=0 ; i<allProfessors.size() ; ++i)
				{
					String s =allProfessors.get(i).toString();
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
			    
			    for(int i=0 ; i<allProfessors.size() ; i++)
			    {
			    	professor = allProfessors.get(i);
			    	
			    	//write name
			    	bw.append(professor.getName()+"\n");
			    	
			    	//write house
			    	bw.append(professor.getHouse().getName()+"\n");
			    	
			    	//write blood status
					BloodStatus bloodStatus = professor.getBloodStatus();
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
			    	
					//write birthday
					bw.append(professor.getBirthday()+"\n");
					
			    	//write courses
					
					
					//write notes
					bw.append(professor.getNotes()+"\n");
					
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
	

		public void showAllProfessors()
		{
			for(int i=0 ; i<allProfessors.size() ; ++i)
			{
				String s =allProfessors.get(i).toString();
				System.out.println(s);
			}
			
		}
		
		public Professor searchByName(String name) throws NotFoundException
		{
			for(int i=0 ; i<allProfessors.size() ; ++i)
			{
				if(allProfessors.get(i).getName().equals(name))
				{
					return allProfessors.get(i);
				}
			}
			throw new NotFoundException();
		}
		
		public void showProfessor(String name) throws NotFoundException
		{
			Professor professor = searchByName(name);
			String s =professor.toString();
			System.out.println(s);
		}
		
		public void createNewProfessor(Professor professor)
		{
			allProfessors.add(professor);
			setData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/ProfessorDB.txt");
		}
		
		public void deleteProfessor(Professor professor)
		{
			if(!allProfessors.remove(professor))
				System.out.println("this professor does not exist");
			setData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/ProfessorDB.txt");
		}
		
		public void editProfessor(String name , Professor newprofessor) throws NotFoundException
		{
			Professor prevprofessor = searchByName(name);
			deleteProfessor(prevprofessor);
			createNewProfessor(newprofessor);
		}

}
