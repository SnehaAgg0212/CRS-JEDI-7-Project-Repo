/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Admin;

import java.util.*;
import com.crs.flipkart.bean.Professor;

/**
 * @author LENOVO
 *
 */
public class AdminService {
	
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

}
