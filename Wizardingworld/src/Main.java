import entityTests.*;
import serviceTests.*;
import services.*;

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
				
//				
//				System.out.println("**************************** SCHOOL SERVICE  ***************************************");
//				SchoolService schoolService = new SchoolService();
//				schoolService.getData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/SchoolDB.txt");
//				schoolService.setData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/Schooltest.txt");
//						
//				System.out.println("**************************** COURSE SERVICE  ***************************************");
//				CourseService courseService = new CourseService();
//				courseService.getData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/CourseDB.txt");
//				courseService.setData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/Coursetest.txt");
//
//				System.out.println("**************************** STUDENT SERVICE  ***************************************");
//				StudentService studentService = new StudentService();
//				studentService.getData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/StudentDB.txt");
//				studentService.setData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/StudentTest.txt");
//				
//				System.out.println("**************************** HOUSE SERVICE  ***************************************");
//				HouseService houseService = new HouseService();
//				houseService.getData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/HouseDB.txt");
//				houseService.setData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/Housetest.txt");
//				
//				System.out.println("**************************** PROFESSOR SERVICE  ***************************************");
//				ProfessorService professorService = new ProfessorService();
//				professorService.getData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/ProfessorDB.txt");
//				professorService.setData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/ProfessorTest.txt");
//				
//				System.out.println("**************************** PERSON SERVICE  ***************************************");
//				PersonService personService = new PersonService();
//				personService.getData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/PersonDB.txt");
//				personService.setData("/home/sadaf/Documents/summerJava/WizardingWorld/Wizardingworld/sample_DB/Persontest.txt");
			}
	
	

}
