/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.bean.Admin;

import java.util.*;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
/**
 * @author LENOVO
 *
 */
public class AdminService {
	
	GradeCard grades[] = new GradeCard[] {
			new GradeCard(414, "Software Engineering", 1, 9.8, 7),
			new GradeCard(213, "Modern Algebra", 1, 8, 7),
			new GradeCard(212, "Software Project Management", 1, 10, 7)
	};
	
	Student student[] = new Student[] {new Student("ssahay", "shambhavi.sahay@flipkart.com", "ABCD", "student", 1,
			"1234567890", "female", "jaipur", "CS", 101, 123, false), new Student("heroku", "heroku@flipkart.com", "ABCD", "student", 1,
					"1234567890", "female", "jaipur", "CS", 102, 123, false), new Student("mymyaway", "mymyaway@flipkart.com", "ABCD", "student", 1,
							"1234567890", "female", "jaipur", "CS", 103, 123, false)};
	
	public static final Admin admin[] = new Admin[] {new Admin("userName",  "admin@gmail.com",  "admin",  "admin",  101,  "phoneNo", "Male",  "address",  "dateOfJoining"),
			new Admin("userName",  "admin1@gmail.com",  "admin1",  "admin",  102,  "phoneNo", "Male",  "address",  "dateOfJoining"),
			new Admin("userName",  "admin2@gmail.com",  "admin2",  "admin",  103,  "phoneNo", "Male",  "address",  "dateOfJoining"),
			new Admin("userName",  "admin3@gmail.com",  "admin3",  "admin",  104,  "phoneNo", "Female",  "address",  "dateOfJoining")};
	
	Scanner sc = new Scanner(System.in);
    
    static int profId = 100;
    static int userId = 1000;

    private void profIdincrementor(){
        profId ++;
    }
    
    private void userIdincrementor(){
        userId ++;
    }
    
    Vector<Professor> ProfessorList = new Vector<Professor>();

    public void addProfessor() {
    	
	    String role = "Professor";
	    int professorId = profId;
	    
	    System.out.println("---------------Professor Registration Panel-------------");
	    
	    System.out.print("Enter Professor Name: ");
	    String professorName = sc.nextLine();
	    
	    System.out.print("Enter Professor Email Id: ");
	    String emailId = sc.nextLine();
	    
	    System.out.print("Enter Professor Password: ");
	    String password = sc.nextLine();
	    
	    System.out.print("Enter Professor Phone Number: ");
	    String phoneNo = sc.nextLine();
	    
	    System.out.print("Enter Professor Designation: ");
	    String designation = sc.nextLine();
	    
	    System.out.print("Enter Department Designated: ");
	    String department = sc.nextLine();
	    
	    System.out.print("Enter Professor Gender: ");
	    String gender = sc.nextLine();
	    
	    System.out.print("Enter Professor Address: ");
	    String address = sc.nextLine();
	    
	    profIdincrementor();
	    userIdincrementor();
	 
	    Professor prof = new Professor(professorName, emailId, password, role, userId, phoneNo,
	    gender, address, professorId, department, designation);
	
	    ProfessorList.add(prof);
    }

	public void viewProfessor(){
		
		System.out.println("---------------Professor Details Display Panel-------------");
		
	    System.out.println("Enter Professor ID: ");
	    int professorId = sc.nextInt();
	
	    for(int i = 0; i < ProfessorList.size(); i++){
	    	
	        if(ProfessorList.get(i) != null && professorId == ProfessorList.get(i).getProfessorId()){
	            
	        	System.out.println(ProfessorList.get(i).getProfessorId());
	            System.out.println(ProfessorList.get(i).getDepartment());
	            System.out.println(ProfessorList.get(i).getDesignation());
	            break;
	        }  
	    }
	}
	
	public void deleteProfessor(){
		 
		System.out.println("---------------Professor Removal Panel-------------");
		
	    System.out.println("Enter Professor ID: ");
	    int professorId = sc.nextInt();
	
	    for(int i = 0; i < ProfessorList.size(); i++){
	    	
	        if(ProfessorList.get(i) != null && professorId == ProfessorList.get(i).getProfessorId()){
	            
	        	ProfessorList.removeElementAt(i);
	            System.out.println("Professor Deleted successfully.");
	            break;
	        }
	    }
	}
	
	public boolean approveStudentRegistration(int studentId) {
		for(int i=0;i<student.length;i++) {
			if(student[i].getStudentId() == studentId) {
				return false;
			}
		}
		return true;
	}
	
	public void GenerateGradeCard(int studentId, String studentName, int semesterId)
	{
		System.out.println("Semester: " + semesterId);
		
		System.out.println(" StudentId: " + studentId + " StudentName: " + studentName);
		
		double overallGpa = 0.0;

		for(GradeCard course_grade:grades) {
			System.out.println(course_grade.getCourseId() + " " + course_grade.getCourseName() + " " + course_grade.getGpa());
			overallGpa += course_grade.getGpa();
		}
		
		overallGpa /= (double)grades.length;
		
		System.out.println("Overall GPA: " + overallGpa);
		
	}
	
	
	

}
