import entityTests.*;
import serviceTests.*;

public class Main {
	
	
	public static void main(String args[])
	{

/*********************			COURSE TESTS			*********************/
		
		//Creating an instance of course test in order to use the methods
		CourseTest ctest = new CourseTest();
		System.out.println(
				"********************************** COURSE TEST ***************************************"
				);
		ctest.runTests();
		//////////*~~~~~ END OF COURSE TESTS
		

/*********************			FINISHED COURSE TESTS			*********************/
		
		//Creating an instance of finished course test in order to use the methods
		FinishedCourseTest ftest = new FinishedCourseTest();
		System.out.println(
				"************************** FINISHED COURSE TEST ***************************************"
				);
		ftest.runTests();
		//////////*~~~~~ END OF FINISHED COURSE TESTS
		

		
/*********************			HOUSE TESTS			*********************/
		
		//Creating an instance of HOUSE test in order to use the methods
		HouseTest htest = new HouseTest();
		System.out.println(
				"***************************** HOUSE TEST ***************************************"
				);
		htest.runTests();
		//////////*~~~~~ END OF HOUSE TESTS
		
		
/*********************			PERSON TESTS			*********************/
		
		//Creating an instance of PERSON test in order to use the methods
		PersonTest ptest = new PersonTest();
		System.out.println(
				"**************************** PERSON TEST ***************************************"
				);
		ptest.runTests();
		//////////*~~~~~ END OF PERSON TESTS		
	
/******************          	COURSE SERVICE TEST **********************************/
		
		//creating an instance of COURSE SERVICE test
		CourseServiceTest courseServiceTest = new CourseServiceTest();
		System.out.println("**************************** COURSE SERVICE TEST ***************************************");
		courseServiceTest.runTests();
		/////////end of course service test
/******************          	STUDENT SERVICE TEST **********************************/
		//creating an instance of STUDENT SERVICE test
				StudentServiceTest studentServiceTest = new StudentServiceTest();
				System.out.println("**************************** STUDENT SERVICE TEST ***************************************");
				studentServiceTest.runTests();
				/////////end of student service test
/******************          	SCHOOL SERVICE TEST **********************************/
				//creating an instance of SCHOOL SERVICE test
						SchoolServiceTest schoolServiceTest = new SchoolServiceTest();
						System.out.println("**************************** SCHOOL SERVICE TEST ***************************************");
						schoolServiceTest.runTests();
						/////////end of school service test

	
	}
	
	

}
