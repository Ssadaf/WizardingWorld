package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import entities.*;

public class HouseService {
	private House house;
	private Vector<House> allHouses;
	
	//constructor
	public HouseService(House _house)
	{
		house = _house;
		allHouses  = new Vector<House> ();
	}
	public HouseService(){
		this(null);
	}
	//getter and setter
	public House getHouse() {
		return house;
	}
	public void setHouse(House _house) {
		house = _house;
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
					
				//read school
				sCurrentLine = br.readLine();
				School school = new School(sCurrentLine);
				
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
				house = new House(name, school , students);
				allHouses.add(house);
			}
			for(int i=0 ; i<allHouses.size() ; ++i)
			{
				String s =allHouses.get(i).toString();
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
		    
		    for(int i=0 ; i<allHouses.size() ; i++)
		    {
		    	house = allHouses.get(i);
		    	
		    	//write name
		    	bw.append(house.getName()+"\n");
		    	
		    	//write school
		    	bw.append(house.getSchool().getName()+"\n");
		    	
		    	//write students
				int numStudents = house.getStudents().size();
				bw.append(Integer.toString(numStudents)+"\n");
				
				for(int x=0; x<numStudents ;x++)
					bw.append(house.getStudents().get(x).getName()+"\n");
				
				//end of student
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
