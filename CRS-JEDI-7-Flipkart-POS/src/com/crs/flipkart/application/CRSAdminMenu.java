/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;
import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.business.AdminInterface;
import com.crs.flipkart.business.AdminService;

/**
 * @author LENOVO
 *
 */
public class CRSAdminMenu {
	
	static AdminInterface adminServices = new AdminService();
	static Scanner sc = new Scanner(System.in);

	/**
	 * Method to Create Main Menu
	 */
	public static void createAdminMenu()
	{
		while(true) {
			
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
	        System.out.println("9. Exit");
	        
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
				return;
			default:
				System.out.println("Invalid Input !");
			}
		}
	}
	
	/**
	 * Approve Student
	 */
	private static void approveStudent() {
		
		System.out.println("---------------Student Approval Panel-------------");
		
		System.out.println("Enter the Student Id: ");
		int studentId = sc.nextInt();
		adminServices.approveStudentRegistration(studentId);

	}
	
	/**
	 * Add Professor
	 */
	private static void addProfessor() {
		
		Professor professor = new Professor();
		
		System.out.println("---------------Professor Registration Panel-------------");
	    
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
	    
	    System.out.print("Enter Professor Gender: ");
	    String gender = sc.nextLine();
	    professor.setGender(gender);
	    
	    System.out.print("Enter Professor Address: ");
	    String address = sc.nextLine();
	    professor.setAddress(address);
	    
	    professor.setRole("Professor");
	    
	    adminServices.addProfessor(professor);
	}
	
	/**
	 * View Professor
	 */
	private static void viewProfessor() {
		
		System.out.println("---------------Professor Details Display Panel-------------");
	    
	    Vector<Professor> ProfessorList = adminServices.viewProfessor();
	    
	    for(int i = 0; i < ProfessorList.size(); i++){
	    	
    		System.out.println("Professor " + i + ": ");
        	System.out.println("Professor Id: " + ProfessorList.get(i).getProfessorId());
        	System.out.println("Professor Name: " + ProfessorList.get(i).getUserName());
            System.out.println("Department: " + ProfessorList.get(i).getDepartment());
            System.out.println("Designation: " + ProfessorList.get(i).getDesignation()); 
            System.out.println("*******************************************************************");
            
	    }
	}
	
	/**
	 * Delete Professor
	 */
	private static void deleteProfessor() {
		
		System.out.println("---------------Professor Removal Panel-------------");
		
	    System.out.println("Enter Professor ID: ");
	    int professorId = sc.nextInt();
	    
	    adminServices.deleteProfessor(professorId);
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
		
		System.out.print("Enter Course Name: ");
	    String courseName = sc.nextLine();
	    course.setCourseName(courseName);
	    
	    System.out.println("Enter Course Description: ");
	    String courseDesc = sc.nextLine();
	    course.setCourseDescription(courseDesc);
	    
	    System.out.println("Enter Course Fees: ");
	    double courseFee = sc.nextDouble();
	    course.setCourseFee(courseFee);
	    
	    System.out.println("Enter Number of Seats: ");
	    int noOfSeats = sc.nextInt();
	    course.setCourseSeats(courseId);
	    
	    adminServices.addCourse(course);
	}
	
	/**
	 * View Courses in Catalogue
	 */
	private static void viewCoursesInCatalog() {
		
		System.out.println("-------------Viewing Courses In Catalog-------------");
		
		Vector<Course> CourseList = adminServices.viewCourse();
		
		for(int i = 0; i < CourseList.size(); i++){
    		
    		System.out.println("Course " + i + ": ");
        	System.out.println("Course Code: " + CourseList.get(i).getCourseId());
            System.out.println("Course Name: " + CourseList.get(i).getCourseName());
            System.out.println("Course Description: " + CourseList.get(i).getCourseDescription());
            System.out.println("Course Fees: " + CourseList.get(i).getCourseFee());
            System.out.println("Remaining Seats: " + CourseList.get(i).getCourseSeats());
            System.out.println("*******************************************************************");
		}
	}
	
	/**
	 * Delete Course from Catalogue
	 */
	private static void deleteCourseFromCatalog() {
		
		System.out.println("-------------Delete Course From Catalog-------------");
		
		System.out.println("Enter Course Code: ");
	    int courseId = sc.nextInt();
	    
	    adminServices.deleteCourse(courseId);
	}
	
	/**
	 * Generate Grade Card
	 */
	private static void generateGradeCard() {
		
		System.out.println("-------------Grade Card Generation-------------");
		
		System.out.println("Enter the Student Id: ");
		int studentId = sc.nextInt();
		
		System.out.println("Enter the Semester Id: ");
		int semester = sc.nextInt();
		
		adminServices.generateGradeCard(studentId, semester);
	}
	
//	/**
//	 * Assign Course to Professor
//	 */
//	private static void assignCourseToProfessor() {
//		
//		System.out.println("-------------Assign Courses to Professors-------------");
//		
//		Vector<Professor> ProfessorList = adminServices.viewProfessor();
//		Vector<Course> CourseCatalog = adminServices.viewCourse();
//		
//		System.out.println("---------------Professor Details Display Panel-------------");
//		
//		for(int i = 0; i < ProfessorList.size(); i++){
//	    	
//    		System.out.println("Professor " + i + ": ");
//        	System.out.println("Professor Id: " + ProfessorList.get(i).getProfessorId());
//        	System.out.println("Professor Name: " + ProfessorList.get(i).getUserName());
//            System.out.println("Department: " + ProfessorList.get(i).getDepartment());
//            System.out.println("Designation: " + ProfessorList.get(i).getDesignation()); 
//            System.out.println("*******************************************************************");
//            
//	    }
//		
//		System.out.println("-------------Viewing Courses In Catalog-------------");
//		
//		for(int i = 0; i < CourseCatalog.size(); i++){
//    		
//    		System.out.println("Course " + i + ": ");
//        	System.out.println("Course Code: " + CourseCatalog.get(i).getCourseId());
//            System.out.println("Course Name: " + CourseCatalog.get(i).getCourseName());
//            System.out.println("Course Description: " + CourseCatalog.get(i).getCourseDescription());
//            System.out.println("*******************************************************************");
//		}
//		
//		System.out.println("Enter Course Code: ");
//		int courseId = sc.nextInt();
//		
//		System.out.println("Enter Professor Id: ");
//		int professorId = sc.nextInt();
//		
//		adminServices.assignCourseToProfessor(courseId, professorId);
//	}
}