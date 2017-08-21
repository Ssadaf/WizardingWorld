package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import entities.*;

public class PersonService {
	private Person person;
	private Vector<Person> allPersons;
	
	//constructor
	public PersonService(Person _person){
		person = _person;
		allPersons = new Vector<Person> ();
	}
	public PersonService(){
		this(null);
	}
	//getter and setter
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person _person) {
		person = _person;
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
				String birthday = sCurrentLine;
				
				sCurrentLine = br.readLine();
				person = new Person(name,house, bloodStatus, school , birthday);
				allPersons.add(person);
			}
			for(int i=0 ; i<allPersons.size() ; ++i)
			{
				String s =allPersons.get(i).toString();
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
		    
		    for(int i=0 ; i<allPersons.size() ; i++)
		    {
		    	person = allPersons.get(i);
		    	
		    	//write name
		    	bw.append(person.getName()+"\n");
		    	
		    	//write house
		    	bw.append(person.getHouse().getName()+"\n");
		    	
		    	//write blood status
				BloodStatus bloodStatus = person.getBloodStatus();
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
				bw.append(person.getSchool().getName()+"\n");
				
				//write birthday
				bw.append(person.getBirthday()+"\n");
				
				//end of person
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
