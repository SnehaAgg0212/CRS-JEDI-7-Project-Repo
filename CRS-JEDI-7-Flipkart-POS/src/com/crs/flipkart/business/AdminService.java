/**
 * 
 */
package com.crs.flipkart.business;
import java.util.*;
import com.crs.flipkart.bean.Catalog;

/**
 * @author LENOVO
 *
 */
public class AdminService {
	
    Scanner sc = new Scanner(System.in);
    
    static int courseId = 100;
    static int userId = 1000;

    private void courseIdincrementor(){
        courseId ++;
    }
    
    private void userIdincrementor(){
        userId ++;
    }
    
    Vector<Catalog> CourseList = new Vector<Catalog>();

    public void addCourse() {
    	
	    int CourseId = courseId;
	    
	    System.out.println("———————Course Catalog-------------");
	    
	    System.out.print("Enter Course Name: ");
	    String courseName = sc.nextLine();
	    

	   
	    System.out.print("Enter Professor Name: ");
	    String professorName = sc.nextLine();
	    

	    
	    courseIdincrementor();
	    userIdincrementor();
	 
	    Catalog crs = new Catalog(CourseId, courseName,professorName
);
	
	    CourseList.add(crs);
    }

	public void viewCourse(){
		
		System.out.println("———————Course Display-------------");
	
	
	    for(int i = 0; i < CourseList.size(); i++){
	    	
	        	System.out.println(CourseList.get(i).getCourseId());
	            System.out.println(CourseList.get(i).getCourseName());
	            System.out.println(CourseList.get(i).getProfessorName());
	            
	        
	    }
	}
	
	public void deleteCourse(){
		 
		System.out.println("---------------Remove Course-------------");
		
	    System.out.println("Enter Course ID: ");
	    int courseId = sc.nextInt();
	
	    for(int i = 0; i < CourseList.size(); i++){
	    	
	        if(CourseList.get(i) != null && courseId == CourseList.get(i).getCourseId()){
	            
	        	CourseList.removeElementAt(i);
	        	System.out.println("Course Deleted successfully.");
	            break;
	        }
	    }
	}
}