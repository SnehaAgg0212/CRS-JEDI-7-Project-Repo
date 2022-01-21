/**
 * 
 */
package com.crs.flipkart.business;
import java.util.*;
import com.crs.flipkart.bean.Professor;
/**
 * @author LENOVO
 *
 */
public class AdminService {
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
    System.out.println("Enter details of the Professor to be added: ");
    System.out.print("Enter the name of the professor: ");
    String professorName = sc.nextLine();
    System.out.print("Enter the professor’s Email Id: ");
    String emailId = sc.nextLine();
    System.out.print("Enter Password - ");
    String password = sc.nextLine();
    System.out.print("Enter contact number - ");
    String phoneNo = sc.nextLine();
    System.out.print("Enter Department designated - ");
    String department = sc.nextLine();
    System.out.print("Enter designation - ");
    String designation = sc.nextLine();
    System.out.print("Enter gender: ");
    String gender = sc.nextLine();
    System.out.print("Enter address: ");
    String address = sc.nextLine();
    profIdincrementor();
    userIdincrementor();
 
    Professor prof = new Professor(professorName, emailId, password, role, userId, phoneNo,
    gender, address, professorId, department, designation);

    ProfessorList.add(prof);
}

public void viewProfessor(){
    System.out.println("Enter the professor ID to view: " );
    int professorId = sc.nextInt();

    for(int i=0; i< ProfessorList.size(); i++){
        if(ProfessorList.get(i)!= null && professorId == ProfessorList.get(i).getProfessorId()){
            System.out.println(ProfessorList.get(i).getProfessorId());
            System.out.println(ProfessorList.get(i).getDepartment());
            System.out.println(ProfessorList.get(i).getDesignation());
            break;
        }  
    }
}

 public void deleteProfessor(){
    System.out.println("Enter the professor ID for deletion" );
    int professorId = sc.nextInt();

    for(int i=0; i< ProfessorList.size(); i++){
        if(ProfessorList.get(i)!= null && professorId == ProfessorList.get(i).getProfessorId()){
            ProfessorList.removeElementAt(i);
            System.out.println("Professor is deleted");
            break;
        }
    }
 }
}
