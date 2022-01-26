/**
 * 
 */
package com.crs.flipkart.application;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.EnrolledStudent;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.ProfessorService;

/**
 * @author devanshugarg
 *
 */
/**
 * @author devanshugarg
 *
 */
public class CRSProfessorMenu {
	static ProfessorService profService = new ProfessorService();
	static AdminService adminservice = new AdminService();
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Method to Create Main Menu
	 */
	public static void createProfessorMenu(int professorId)
	{
		
		while(true) {
			
	        System.out.println("#------------------------Welcome to Course Registration System------------------------#");
	        
	        System.out.println("*************************************************************************************");
	        System.out.println("********************************* Professor Menu ************************************");
	        System.out.println("*************************************************************************************");
	        
	        System.out.println("1. View Courses");
			System.out.println("2. Add Grades");
			System.out.println("3. View Enrolled Students");
			System.out.println("4. Choose Courses");
			System.out.println("5. Exit");
	        
	        System.out.println("*********************************************************************************");
	        
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
		Vector<Course> allCourses = profService.viewAvailableCourses();
		System.out.println(String.format("%20s %20s","COURSE ID","COURSE NAME"));
		for(Course course: allCourses) {
			System.out.println(String.format("%20s %20s",course.getCourseId(),course.getCourseName()));
		}
		
		System.out.println();
		System.out.println("Enter the Course you want to teach: ");
		int courseSelected = sc.nextInt();
		
		boolean status = profService.addCourse(professorId, courseSelected);
		if(status) {
			System.out.println("CourseId " + courseSelected + " is registered for ProfessorId " + professorId + " successfully");
		}else {
			System.out.println("Professor has already registered.");
		}
	}

	/**
	 * View Enrolled Students
	 * @param professorId
	 */
	private static void viewEnrolledStudents(int professorId) {
		// TODO Auto-generated method stub
		System.out.println(String.format("%20s %20s %20s","COURSE CODE","COURSE NAME","Student" ));
		try {
			Vector<EnrolledStudent> enrolledStudents = new Vector<EnrolledStudent>();
			enrolledStudents = profService.viewEnrolledStudents(professorId);
			for (EnrolledStudent obj: enrolledStudents) {
				System.out.println(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),obj.getStudentId()));
			}
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage()+"Something went wrong, please try again later!");
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
	
			Vector<EnrolledStudent> enrolledStudents = new Vector<EnrolledStudent>();
			enrolledStudents = profService.viewEnrolledStudents(professorId);
			System.out.println(String.format("%20s %20s %20s","COURSE CODE","COURSE NAME","Student ID" ));
			for (EnrolledStudent obj: enrolledStudents) {
				System.out.println(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),obj.getStudentId()));
			}
			Vector<Course> coursesEnrolled = new Vector<Course>();
			coursesEnrolled	= profService.viewCourses(professorId);
			System.out.println("----------------Add Grade--------------");
			System.out.printf("Enter student id: ");
			studentId = sc.nextInt();
			System.out.printf("Enter course code: ");
			courseCode = sc.nextInt();
			System.out.println("Enter grade: ");
			grade = sc.nextDouble();
			System.out.println("Enter semester Id: ");
			semesterId = sc.nextInt();
			profService.addGrade(studentId, courseCode, grade, semesterId);
			System.out.println("Grade added successfully for "+studentId);
			/*if (!(ProfessorValidator.isValidStudent(enrolledStudents, studentId)
			&& ProfessorValidator.isValidCourse(coursesEnrolled, courseCode))) {
				professorInterface.addGrade(studentId, courseCode, grade);
				System.out.println("Grade added successfully for "+studentId);
			} else {
				System.out.println("Invalid data entered, try again!");
			}
			
		} catch(GradeNotAllotedException ex) {
			System.out.println("Grade cannot be added for"+ex.getStudentId());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

	/**
	 * View Courses
	 * @param professorId
	 */
	private static void getCourses(int professorId) {
		
		// TODO Auto-generated method stub
		try {
			Vector<Course> coursesEnrolled = profService.viewCourses(professorId);
			System.out.println(String.format("%20s %20s %20s","COURSE ID","COURSE NAME","No. of Students" ));
			for(Course obj: coursesEnrolled) {
				System.out.println(String.format("%20s %20s %20s",obj.getCourseId(), obj.getCourseName(), obj.getCourseSeats()));
			}		
		} catch(Exception ex) {
			System.out.println("Something went wrong!"+ex.getMessage());
		}

		
	}

}
