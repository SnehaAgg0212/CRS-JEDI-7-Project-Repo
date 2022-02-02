/**
 * 
 */
package com.crs.flipkart.application;

import java.sql.SQLException;
import java.util.Vector;
import java.util.Scanner;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.EnrolledStudent;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.ProfessorInterface;
import com.crs.flipkart.business.ProfessorService;
import com.crs.flipkart.exceptions.CourseNotFoundException;
import com.crs.flipkart.exceptions.ProfessorAlreadyRegisteredException;
import com.crs.flipkart.validator.ProfessorValidator;

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
	 * @throws ProfessorAlreadyRegisteredException 
	 */
	public static void createProfessorMenu(int professorId) throws ProfessorAlreadyRegisteredException
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
	 * @throws ProfessorAlreadyRegisteredException 
	 */
	private static void chooseCourses(int professorId) throws ProfessorAlreadyRegisteredException {
		// TODO Auto-generated method stub
		
		try {
			Vector<Course> allCourses = professorService.viewAvailableCourses();
	 		System.out.println(String.format("%20s %20s","COURSE ID","COURSE NAME"));
	 		
	 		allCourses.forEach((course) -> {
	 			System.out.println(String.format("%20s %20s", course.getCourseId(), course.getCourseName()));
	 		 });
	
	 		System.out.println();
	 		System.out.println("Enter the Course you want to teach: ");
	 		int courseSelected = sc.nextInt();
	 		try {
	 			boolean status = professorService.addCourse(professorId, courseSelected);
		 		if(status) {
		 			System.out.println("CourseId " + courseSelected + " is registered for ProfessorId " + professorId + " successfully.");
		 		} else {
		 			throw new ProfessorAlreadyRegisteredException(professorId);
		 		}
	 		} catch(CourseNotFoundException e) {
	 			System.out.println("Error : " + e);
	 		} catch(ProfessorAlreadyRegisteredException e) {
	 			System.out.println("Error : " + e);
	 		}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
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
 			
 			enrolledStudents.forEach((obj) -> {
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
		
		int courseCode, studentId;
 		double grade;

 		try {
			Vector<EnrolledStudent> notGradedStudents = new Vector<EnrolledStudent>();
			notGradedStudents = professorService.viewEnrolledStudents(professorId);
			if(notGradedStudents.size() == 0) {
				System.out.println("Professor is not teaching any course!!");
				System.out.println();
				return;
			}
			System.out.println();
			System.out.println(String.format("%20s %20s %20s","COURSE CODE", "COURSE NAME", "Student ID"));
			System.out.println();
			
			notGradedStudents.forEach ((obj) -> {
				System.out.println(String.format("%20s %20s %20s", obj.getCourseId(), obj.getCourseName(), obj.getStudentId()));
			});
			
			Vector<Course> coursesEnrolled = professorService.viewCourses(professorId);
			Course course = coursesEnrolled.get(0);
			courseCode = course.getCourseId();
			coursesEnrolled	= professorService.viewCourses(professorId);
			System.out.println("--------------------------------Add Grade------------------------------");
			System.out.println();
			System.out.printf("Enter Student Id: ");
			studentId = sc.nextInt();
			
			System.out.println("Enter Grade: ");
			grade = sc.nextDouble();
			
			if (ProfessorValidator.isValidStudent(notGradedStudents, studentId) && ProfessorValidator.isValidCourse(coursesEnrolled, courseCode)) {
				professorService.addGrade(studentId, courseCode, grade);
				System.out.println("Grade added successfully for " + studentId);
			} else {
				System.out.println("Grade cannot be added for " + studentId);
			}
 		} catch (SQLException e) {
 			System.out.println("Error: " + e);
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
 			if(coursesEnrolled.size() == 0) {
 				System.out.println("No Courses selected by Professor!!");
 				return;
 			}
 			System.out.println(String.format("%20s %20s %20s", "COURSE ID", "COURSE NAME", "No. of Students" ));
 			coursesEnrolled.forEach((obj) -> {
 				System.out.println(String.format("%20s %20s %20s", obj.getCourseId(), obj.getCourseName(), 10 - obj.getCourseSeats()));
 			});
 		} catch(Exception e) {
 			System.out.println("Something went wrong!" + e.getMessage());
 		}
	}

}
