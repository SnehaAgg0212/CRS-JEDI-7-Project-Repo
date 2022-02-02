/**
 * 
 */
package com.crs.flipkart.application;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.AdminInterface;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.NotificationInterface;
import com.crs.flipkart.business.NotificationService;
import com.crs.flipkart.constants.GenderConstant;
import com.crs.flipkart.constants.NotificationTypeConstant;
import com.crs.flipkart.constants.RoleConstant;
import com.crs.flipkart.exceptions.CourseAlreadyExistsException;
import com.crs.flipkart.exceptions.CourseNotDeletedException;
import com.crs.flipkart.exceptions.CourseNotFoundException;
import com.crs.flipkart.exceptions.ProfessorHasNotGradedException;
import com.crs.flipkart.exceptions.ProfessorNotAddedException;
import com.crs.flipkart.exceptions.ProfessorNotDeletedException;
import com.crs.flipkart.exceptions.ProfessorNotFoundException;
import com.crs.flipkart.exceptions.StudentNotFoundException;
import com.crs.flipkart.exceptions.StudentNotFoundForApprovalException;
import com.crs.flipkart.exceptions.UserIdAlreadyInUseException;

/**
 * @author devanshugarg
 *
 */
public class CRSAdminMenu {
	
	static AdminInterface adminServices = AdminService.getInstance();
	static NotificationInterface notificationService = NotificationService.getInstance();
	static Scanner sc = new Scanner(System.in);

	/**
	 * Method to Create Main Menu
	 */
	public static void createAdminMenu()
	{
		while(CRSApplicationMenu.loggedin) {
			
	        System.out.println("#------------------------Welcome to Course Registration System------------------------#");
	        
	        System.out.println("*********************************************************************************");
	        System.out.println("********************************* Admin Menu ************************************");
	        System.out.println("*********************************************************************************");
	        
	        System.out.println("1. Add Professor");
	        System.out.println("2. View Professor");
	        System.out.println("3. Remove Professor");
	        System.out.println("4. Approve Student");
	        System.out.println("5. Add Course to Catalog");
	        System.out.println("6. View Courses in Catalog");
	        System.out.println("7. Delete Course from Catalog");
	        System.out.println("8. Generate Grade Card");
	        System.out.println("9. View Pending Admissions");
	        System.out.println("10. Exit");
	        
	        System.out.println("*********************************************************************************");
	        
	        System.out.print("Enter User Input: ");
			
			int userInput = sc.nextInt();  
			
			switch(userInput) {
			
			case 1: 
				addProfessor();
				break;
			case 2: 
				viewProfessor();
				break;
			case 3: 
				deleteProfessor();
				break;
			case 4:
				approveStudent();
				break;
			case 5:
				addCourseToCatalog();
				break;
			case 6:
				viewCoursesInCatalog();
				break;
			case 7:
				deleteCourseFromCatalog();
				break;
			case 8:
				generateGradeCard();
				break;
			case 9:
				viewPendingAdmissions();
				break;
			case 10:
				CRSApplicationMenu.loggedin = false;
				return;
			default:
				System.out.println("Invalid Input !");
			}
		}
	}
	
	/**
	 * View Pending Admissions
	 */
	private static Vector<Student> viewPendingAdmissions() {
		
		Vector<Student> pendingStudents = adminServices.viewPendingAdmissions();
		
 		if(pendingStudents.size() == 0) {
 			System.out.println("No student left for approving admission.");
 			return pendingStudents;
 		}
		
		System.out.println("---------------Viewing Pending Admissions-------------");
		
		
		System.out.println();
 		System.out.println(String.format("%20s %20s %20s %20s %20s %20s", "STUDENTID", "NAME", "GENDER", "BATCH", "BRANCH", "PHONENO"));
 		System.out.println();
 		pendingStudents.forEach((student) -> { 
 			System.out.println(String.format("%20s %20s %20s %20s %20s %20s", student.getStudentId(), student.getUserName(), student.getGender(), student.getBatch(), student.getBranchName(), student.getPhoneNo()));
 		});
 		return pendingStudents;
	}

	/**
	 * Approve Student
	 */
	private static void approveStudent() {
		
		Vector<Student> pendingStudents = viewPendingAdmissions();
		
 		if(pendingStudents.size() == 0) {
 			return;
 		}
		
		System.out.println("---------------Student Approval Panel-------------");
		
		

 		System.out.println("Enter the Student Id: ");
 		int studentId = sc.nextInt();
 		
 		try {
	 		adminServices.approveStudentRegistration(studentId, pendingStudents);
	 		
	 		try {
				int notificationId = notificationService.sendApprovalNotification(NotificationTypeConstant.APPROVAL, studentId);
				System.out.println("Notification Id: " + notificationId);
	 		} catch (SQLException e) {
	 			System.out.println("Error: " + e);
	 		}
 		} catch (StudentNotFoundForApprovalException e) {
 			System.out.println("Error: " + e);
 		}
	}
	
	/**
	 * Add Professor
	 */
	private static void addProfessor() {
		
		Professor professor = new Professor();
		
		System.out.println("---------------Professor Registration Panel-------------");
		sc.nextLine();
	    
	    System.out.print("Enter Professor Name: ");
	    String professorName = sc.nextLine();
	    professor.setUserName(professorName);
	    
	    System.out.print("Enter Professor Email Id: ");
	    String emailId = sc.nextLine();
	    professor.setUserEmailId(emailId);
	    
	    System.out.print("Enter Professor Password: ");
	    String password = sc.nextLine();
	    professor.setUserPassword(password);
	    
	    System.out.print("Enter Professor Phone Number: ");
	    String phoneNo = sc.nextLine();
	    professor.setPhoneNo(phoneNo);
	    
	    System.out.print("Enter Professor Designation: ");
	    String designation = sc.nextLine();
	    professor.setDesignation(designation);
	    
	    System.out.print("Enter Department Designated: ");
	    String department = sc.nextLine();
	    professor.setDepartment(department);
	    
	    System.out.print("Enter Professor Gender: \t 1: Male \t 2.Female \t 3.Other : ");
	    int gender = sc.nextInt();
	    professor.setGender(GenderConstant.getName(gender));
	    sc.nextLine();
	    
	    System.out.print("Enter Professor Address: ");
	    String address = sc.nextLine();
	    professor.setAddress(address);
	    
	    professor.setRole(RoleConstant.stringToRole("PROFESSOR"));
	    
	    try {
	    	adminServices.addProfessor(professor);
	    } catch (ProfessorNotAddedException e) {
	    	System.out.println("Error: " + e);
	    } catch (UserIdAlreadyInUseException e) {
	    	System.out.println("Error: " + e);
	    }
	}
	
	/**
	 * View Professor
	 */
	private static void viewProfessor() {
		
		Vector<Professor> ProfessorList = adminServices.viewProfessor();
		if(ProfessorList.size() == 0) {
			System.out.println("No Professor has been added!");
 			return;
		}
		
		System.out.println("---------------Professor Details Display Panel-------------");
		System.out.println();
	    
	    System.out.println(String.format("%-20s %-20s %-30s %-20s", "PROFESSOR ID", "PROFESSOR NAME", "PROFESSOR DEPARTMENT", "PROFESSOR DESIGNATION"));
	    System.out.println();
	    ProfessorList.forEach((professor) -> {
	    	System.out.println(String.format(" %-20s %-20s %-30s %-20s", professor.getProfessorId(), professor.getUserName(), professor.getDepartment(), professor.getDesignation()));
	    });
	    
	    System.out.println();
	}
	
	/**
	 * Delete Professor
	 */
	private static void deleteProfessor() {
		
		Vector<Professor> ProfessorList = adminServices.viewProfessor();
		if(ProfessorList.size() == 0) {
			System.out.println("No Professor has been added!");
 			return;
		}
		
		System.out.println("---------------Professor Removal Panel-------------");
		
		System.out.println();
	    
	    System.out.println(String.format("%-20s %-20s %-30s %-20s", "PROFESSOR ID", "PROFESSOR NAME", "PROFESSOR DEPARTMENT", "PROFESSOR DESIGNATION"));
	    System.out.println();
	    ProfessorList.forEach((professor) -> {
	    	System.out.println(String.format(" %-20s %-20s %-30s %-20s", professor.getProfessorId(), professor.getUserName(), professor.getDepartment(), professor.getDesignation()));
	    });
	    
	    System.out.println("Enter Professor ID: ");
	    int professorId = sc.nextInt();
	    
	    try {
	    	adminServices.deleteProfessor(professorId);
	    } catch (ProfessorNotDeletedException e) {
	    	System.out.println("Error: " + e);
	    } catch (ProfessorNotFoundException e) {
	    	System.out.println("Error: " + e);
	    }
	}
	
	/**
	 * Add Course to Catalogue
	 */
	private static void addCourseToCatalog() {
		
		Course course = new Course();
		
		System.out.println("-------------Add Course To Catalog-------------");
		
		System.out.print("Enter Course Code: ");
	    int courseId = sc.nextInt();
	    course.setCourseId(courseId);
	    sc.nextLine();
		
		System.out.print("Enter Course Name: ");
	    String courseName = sc.next();
	    course.setCourseName(courseName);
	    
	    sc.nextLine();
	    
	    System.out.println("Enter Course Description: ");
	    String courseDesc = sc.nextLine();
	    course.setCourseDescription(courseDesc);
	    
	    System.out.println("Enter Course Fees: ");
	    double courseFee = sc.nextDouble();
	    course.setCourseFee(courseFee);
	    
	    System.out.println("Enter Number of Seats: ");
	    int noOfSeats = sc.nextInt();
	    course.setCourseSeats(noOfSeats);
	    
	    Vector<Course> allCourse = adminServices.viewCourse();
	    try {
	    	adminServices.addCourse(course, allCourse);
	    } catch (CourseAlreadyExistsException e) {
	    	System.out.println("Error: " + e);
	    }
	}
	
	/**
	 * View Courses in Catalogue
	 */
	private static Vector<Course> viewCoursesInCatalog() {
		
		Vector<Course> CourseList = adminServices.viewCourse();
		if(CourseList.size() == 0) {
			System.out.println("No Courses has been added!");
 			return null;
		}
		
		System.out.println("-------------Viewing Courses In Catalog-------------");
		System.out.println();
		
		
		
		System.out.println(String.format("%-20s %-20s %-45s %-20s %-20s", "COURSE ID", "COURSE NAME", "COURSE DESCRIPTION", "COURSE FEES" , "COURSE SEATS"));
		System.out.println();
		CourseList.forEach((course) -> {
			System.out.println(String.format("%-20s %-20s %-45s %-20s %-20s", course.getCourseId(), course.getCourseName(), course.getCourseDescription(), course.getCourseFee(), course.getCourseSeats()));
		});
		
		System.out.println();
		
		return CourseList;
	}
	
	/**
	 * Delete Course from Catalogue
	 */
	private static void deleteCourseFromCatalog() {
		
		Vector<Course> CourseList = adminServices.viewCourse();
		if(CourseList.size() == 0) {
			System.out.println("No Courses has been added!");
 			return;
		}
		
		System.out.println("-------------Delete Course From Catalog-------------");
		System.out.println();
		System.out.println(String.format("%-20s %-20s %-45s %-20s %-20s", "COURSE ID", "COURSE NAME", "COURSE DESCRIPTION", "COURSE FEES" , "COURSE SEATS"));
		System.out.println();
		CourseList.forEach((course) -> {
			System.out.println(String.format("%-20s %-20s %-45s %-20s %-20s", course.getCourseId(), course.getCourseName(), course.getCourseDescription(), course.getCourseFee(), course.getCourseSeats()));
		});
		
		System.out.println();
		
		System.out.println("Enter Course Code: ");
	    int courseId = sc.nextInt();
	    
	    try {
	    	adminServices.deleteCourse(courseId, viewCoursesInCatalog());
	    } catch (CourseNotDeletedException e) {
	    	System.out.println("Error: " + e);
	    } catch (CourseNotFoundException e) {
	    	System.out.println("Error: " + e);
	    }
	}
	
	/**
	 * Generate Grade Card
	 * @throws ProfessorHasNotGradedException 
	 * @throws StudentNotFoundException 
	 */
	private static void generateGradeCard() {
		
		System.out.println("-------------Grade Card Generation-------------");
		System.out.println();
		System.out.println("Enter the Student Id: ");
		int studentId = sc.nextInt();
		try {
			adminServices.generateGradeCard(studentId);
			adminServices.setIsGenerateGrade(studentId);
		}catch(StudentNotFoundException e) {
			System.out.println("Error : " + e);
		}catch(ProfessorHasNotGradedException e) {
			System.out.println("Error : " + e);
		}catch(Exception e) {
			System.out.println("Error : " + e);
		}
	}
}