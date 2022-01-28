/**
 *
 */
package com.crs.flipkart.business;

import java.util.Scanner;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Admin;
import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.GenderConstant;
import com.crs.flipkart.constants.RoleConstant;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperation;

/**
 * @author LENOVO
 *
 */
public class AdminService implements AdminInterface {
	
	private static volatile AdminService instance = null;
	private static Logger logger = Logger.getLogger(AdminService.class);
	
	/**
	 * Default Constructor
	 */
	private AdminService() {
		
	}
	
	/**
	 * Method to make AdminService Singleton
	 */
	public static AdminService getInstance() {
		
		if(instance == null) {
			
			synchronized(AdminService.class) {
				
				instance = new AdminService();
			}
		}
		return instance;
	}
	
	AdminDaoInterface adminDaoOperation = AdminDaoOperation.getInstance();
	
	public static final Admin admin = new Admin("userName",  "admin@gmail.com",  "admin",  RoleConstant.ADMIN,  101,  "phoneNo", GenderConstant.MALE,  "address",  "dateOfJoining");
	
	Scanner sc = new Scanner(System.in);

    static int profId = 100;
    static int userId = 1000;

    private void profIdincrementor() {
        profId ++;
    }

    private void userIdincrementor() {
        userId ++;
    }

    Vector<Student> StudentList = new Vector<>();
    Vector<Professor> ProfessorList = new Vector<>();
    Vector<Course> CourseList = new Vector<>();

    @Override
	public void addProfessor(Professor professor) {

	    professor.setProfessorId(profId);
	    professor.setUserId(userId);

	    profIdincrementor();
	    userIdincrementor();

	    adminDaoOperation.addProfessor(professor);
    }

	@Override
	public Vector<Professor> viewProfessor() {

	    return adminDaoOperation.viewProfessor();
	}

	@Override
	public void deleteProfessor(int professorId) {

		adminDaoOperation.deleteProfessor(professorId);
	}

	@Override
	public void approveStudentRegistration(int studentId) {

		adminDaoOperation.approveStudentRegistration(studentId);
	}

	@Override
	public void generateGradeCard(int studentId, int semesterId)
	{
		Vector<GradeCard> grades = new Vector<>();
		
		grades = adminDaoOperation.generateGradeCard(studentId, semesterId);
		
		if (grades.isEmpty()) {
			logger.info("You haven't registered for any course.");
			return;
		}
		
		double overallgpa = 0.0;
		
		for(GradeCard course_grade : grades) {
			
			logger.info("CourseId: " + course_grade.getCourseId() + " GPA: " + course_grade.getGpa());
			
			overallgpa += course_grade.getGpa();
		}
		
		overallgpa /= (double)grades.size();
		
		logger.info("Overall GPA: " + overallgpa);

	}

	@Override
	public void addCourse(Course course) {

		adminDaoOperation.addCourse(course);
	}

	@Override
	public Vector<Course> viewCourse() {

	    return adminDaoOperation.viewCourse();
	}

	@Override
	public void deleteCourse(int courseId) {

		adminDaoOperation.deleteCourse(courseId);
	}
	
	@Override
	public void setIsGenerateGrade(int studentId) {
		
 		adminDaoOperation.setIsGenerateGrade(studentId);
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
