/**
 *
 */
package com.crs.flipkart.business;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

import com.crs.flipkart.bean.Admin;
import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.AdminDaoOperation;

/**
 * @author LENOVO
 *
 */
public class AdminService implements AdminInterface {

	
	AdminDaoOperation adminDaoOperation =new AdminDaoOperation();

	public static final Admin admin = new Admin("userName",  "admin@gmail.com",  "admin",  "admin",  101,  "phoneNo", "Male",  "address",  "dateOfJoining");
	
	Scanner sc = new Scanner(System.in);

    static int profId = 100;
    static int userId = 1000;

    private void profIdincrementor() {
        profId ++;
    }

    private void userIdincrementor() {
        userId ++;
    }

    Vector<Student> StudentList = new Vector<Student>() {{
    	add(new Student("username_1", "username_1@flipkart.com", "ABCD", "student", 1,
				"1234567890", "female", "location", "CS", 101, 123, false));
			add(new Student("username_2", "username_2@flipkart.com", "ABCD", "student", 1,
					"1234567890", "female", "location", "CS", 102, 123, false));
			add(new Student("username_3", "username_3@flipkart.com", "ABCD", "student", 1,
					"1234567890", "female", "location", "CS", 103, 123, false));
    }};
    Vector<Professor> ProfessorList = new Vector<>();
    Vector<Course> CourseList = new Vector<>();

    @Override
	public void addProfessor(Professor professor) {

	    professor.setProfessorId(profId);
	    professor.setUserId(userId);

	    profIdincrementor();
	    userIdincrementor();

	    ProfessorList.add(professor);
    }

	@Override
	public Vector<Professor> viewProfessor() {

	    return ProfessorList;
	}

	@Override
	public void deleteProfessor(int professorId) {

	    for(int i = 0; i < ProfessorList.size(); i++) {

	        if(ProfessorList.get(i) != null && professorId == ProfessorList.get(i).getProfessorId()){

	        	ProfessorList.removeElementAt(i);
	            System.out.println("Professor Deleted successfully.");
	            break;
	        }
	    }
	}

	@Override
	public boolean approveStudentRegistration(int studentId) {

		for (Student element : StudentList) {

			if(element.getStudentId() == studentId) {

				return false;
			}
		}
		return true;
	}

	@Override
	public void generateGradeCard(int studentId, int semesterId)
	{
		Vector<GradeCard>grades = new Vector<GradeCard>();
		
		grades = adminDaoOperation.generateGradeCard(studentId,semesterId);
		
		double overallgpa=0.0;
		
		for(GradeCard course_grade:grades) {
			
			System.out.println("CourseId:"+course_grade.getCourseId() + "gpa:"+course_grade.getGpa());
			
			overallgpa+=course_grade.getGpa();
		}
		
		overallgpa/=(double)grades.size();
		
		System.out.println("Overall GPA:"+overallgpa);
		
	}

	@Override
	public void addCourse(Course course) {

		    CourseList.add(course);
	}

	@Override
	public Vector<Course> viewCourse() {

	    return CourseList;
	}

	@Override
	public void deleteCourse(int courseId) {

	    for(int i = 0; i < CourseList.size(); i++) {

	        if(CourseList.get(i) != null && courseId == CourseList.get(i).getCourseId()) {

	        	CourseList.removeElementAt(i);
	        	System.out.println("Course Deleted successfully.");
	            break;
	        }
	    }
	}

//	@Override
//	public void assignCourseToProfessor(int courseId, int professorId) {
//
//		for (Course element : CourseList) {
//
//			if(element != null && courseId == element.getCourseId()) {
//
//				element.setProfessorId(professorId);
//				System.out.println("Course Assigned to Professor successfully.");
//				break;
//			}
//		}
//	}
}
