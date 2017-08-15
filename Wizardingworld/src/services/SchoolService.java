package services;

import entities.*;
import java.util.Scanner;

public class SchoolService {
    private School school;
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
}
