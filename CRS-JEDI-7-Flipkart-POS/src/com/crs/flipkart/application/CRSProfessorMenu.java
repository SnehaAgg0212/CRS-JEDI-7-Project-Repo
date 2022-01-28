/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Vector;

import java.util.Scanner;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.EnrolledStudent;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.ProfessorInterface;
import com.crs.flipkart.business.ProfessorService;
import com.crs.flipkart.exceptions.GradeCannotBeAddedException;

/**
 * @author devanshugarg
 *
 */
/**
 * @author devanshugarg
 *
 */
public class CRSProfessorMenu {

	static Scanner sc = new Scanner(System.in);
	static ProfessorInterface professorService = ProfessorService.getInstance();
 	static AdminService adminservice = AdminService.getInstance();
	
	/**
	 * Method to Create Main Menu
	 */
	public static void createProfessorMenu(int professorId)
	{
		
		while(CRSApplicationMenu.loggedin) {
			
	        System.out.println("#------------------------Welcome to Course Registration System------------------------#");
	        
	        System.out.println("*************************************************************************************");
	        System.out.println("********************************* Professor Menu ************************************");
	        System.out.println("*************************************************************************************");
	        
	        System.out.println("1. View Courses");
			System.out.println("2. Add Grades");
			System.out.println("3. View Enrolled Students");
			System.out.println("4. Choose Courses");
			System.out.println("5. Exit");
	        
	        System.out.println("*************************************************************************************");
	        
	        System.out.print("Enter User Input: ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				getCourses(professorId);
				break;
			case 2:
				addGrade(professorId);
				break;
			case 3:
				viewEnrolledStudents(professorId);
				break;
			case 4:
				chooseCourses(professorId);
				break;
			case 5:
				CRSApplicationMenu.loggedin = false;
				return;
			default:
				System.out.println("Invalid Input !");
			}
		}
	}
	
	/**
	 * Choose Courses
	 * @param professorId
	 */
	private static void chooseCourses(int professorId) {
		// TODO Auto-generated method stub
		
		try{Vector<Course> allCourses = professorService.viewAvailableCourses();
 		System.out.println(String.format("%20s %20s","COURSE ID","COURSE NAME"));
 		/*for(Course course : allCourses) {
 			System.out.println(String.format("%20s %20s",course.getCourseId(),course.getCourseName()));
 		}*/
		 allCourses.forEach((course)->{
			System.out.println(String.format("%20s %20s",course.getCourseId(),course.getCourseName()));
		 });

 		System.out.println();
 		System.out.println("Enter the Course you want to teach: ");
 		int courseSelected = sc.nextInt();

 		boolean status = professorService.addCourse(professorId, courseSelected);
 		if(status) {
 			System.out.println("CourseId " + courseSelected + " is registered for ProfessorId " + professorId + " successfully.");
 		} else {
 			System.out.println("Professor has already registered.");
 		}
	}catch(Exception ex){
		System.out.println("Error occured! "+ ex.getMessage());
	}
	}

	/**
	 * View Enrolled Students
	 * @param professorId
	 */
	private static void viewEnrolledStudents(int professorId) {
		// TODO Auto-generated method stub
		
		System.out.println(String.format("%20s %20s %20s","COURSE CODE", "COURSE NAME", "Student"));
 		try {
 			Vector<EnrolledStudent> enrolledStudents = new Vector<EnrolledStudent>();
 			enrolledStudents = professorService.viewEnrolledStudents(professorId);
 			/*for(EnrolledStudent obj:enrolledStudents){
				System.out.println(String.format("%20s %20s %20s", obj.getCourseId(), obj.getCourseName(), obj.getStudentId()));
			 }*/
			 enrolledStudents.forEach ((obj)-> {
 				System.out.println(String.format("%20s %20s %20s", obj.getCourseId(), obj.getCourseName(), obj.getStudentId()));
 			});
 		} catch(Exception e) {
 			System.out.println(e.getMessage() + "Something went wrong, please try again later!");
 		}
	}

	/**
	 * Add Grades
	 * @param professorId
	 */
	private static void addGrade(int professorId) {
		// TODO Auto-generated method stub
		
		int courseCode, studentId, semesterId;
 		double grade;
		boolean isValidCourse=false, isValidStudent = false;
		try	{
		Vector<EnrolledStudent> enrolledStudents = new Vector<EnrolledStudent>();
		enrolledStudents = professorService.viewEnrolledStudents(professorId);
		System.out.println(String.format("%20s %20s %20s","COURSE CODE", "COURSE NAME", "Student ID"));

		enrolledStudents.forEach ((obj)-> {
			System.out.println(String.format("%20s %20s %20s", obj.getCourseId(), obj.getCourseName(), obj.getStudentId()));
		});
		Vector<Course> coursesEnrolled = professorService.viewCourses(professorId);
		System.out.println("----------------Add Grade--------------");
		System.out.printf("Enter Student Id: ");
		studentId = sc.nextInt();
		System.out.printf("Enter Course Code: ");
		courseCode = sc.nextInt();
		System.out.println("Enter Grade: ");
		grade = sc.nextDouble();
		System.out.println("Enter Semester Id: ");
		semesterId = sc.nextInt();

		// <--- Check if the entered Course is correct ---->
		for(int i=0;i< coursesEnrolled.size();i++)
		{
			if(coursesEnrolled.get(i).getCourseId() == courseCode)
				isValidCourse = true;
		}
		if(!isValidCourse)
			throw new GradeCannotBeAddedException("This Course is not taught by professor!"+ professorId);

		// <---- Check if the entered student is correct --->
		for(int i=0;i< enrolledStudents.size();i++)
		{
			if(enrolledStudents.get(i).getStudentId() == studentId)
				isValidStudent = true;
		}
		if(!isValidStudent)
			throw new GradeCannotBeAddedException("This Student is not taught by professor!"+ professorId);
		///////////////////////
		
		professorService.addGrade(studentId, courseCode, grade, semesterId);
		System.out.println("Grade added successfully for " + studentId);
	}
		//<------ Add this exception after Drop wizards ----->

		/*catch(GradeCannotBeAddedException e){
			System.out.println("Grade cannot be added for"+e.getStudentId());
		}*/
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	/**
	 * View Courses
	 * @param professorId
	 */
	private static void getCourses(int professorId) {
		// TODO Auto-generated method stub
		
		try {
 			Vector<Course> coursesEnrolled = professorService.viewCourses(professorId);
 			System.out.println(String.format("%20s %20s %20s", "COURSE ID", "COURSE NAME", "No. of Students" ));
 			coursesEnrolled.forEach((obj)-> {
 				System.out.println(String.format("%20s %20s %20s", obj.getCourseId(), obj.getCourseName(), 10 - obj.getCourseSeats()));
 			});		
 		} catch(Exception e) {
 			System.out.println("Something went wrong!" + e.getMessage());
 		}
	}

}
