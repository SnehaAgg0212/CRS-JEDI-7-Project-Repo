/**
 *
 */
package com.crs.flipkart.business;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import com.crs.flipkart.bean.Admin;
import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.GenderConstant;
import com.crs.flipkart.constants.RoleConstant;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperation;
import com.crs.flipkart.utils.Utils;

/**
 * @author LENOVO
 *
 */
public class AdminService implements AdminInterface {
	
	AdminDaoInterface adminDaoOperation = new AdminDaoOperation();
		
	Scanner sc = new Scanner(System.in);

    Vector<Student> StudentList = new Vector<>();
    Vector<Professor> ProfessorList = new Vector<>();
    Vector<Course> CourseList = new Vector<>();

    @Override
	public void addProfessor(Professor professor) {

    	int professorId = Utils.generateId();
		int userId = Utils.generateId();
    	
	    professor.setProfessorId(professorId);
	    professor.setUserId(userId);

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
	public void approveStudentRegistration(int studentId, List<Student> pendingStudents) {

		Boolean isValidUnapprovedStudent = false;
		for(Student student : pendingStudents) {
			if(studentId == student.getStudentId()) {
				isValidUnapprovedStudent = true;
				break;
			}
		}
		
		if(!isValidUnapprovedStudent) {
			System.out.println("Student not found.");
			return;
		}
		
		adminDaoOperation.approveStudentRegistration(studentId);
	}

	@Override
	public void generateGradeCard(int studentId, int semesterId)
	{
		Vector<GradeCard> grades = new Vector<>();
		
		grades = adminDaoOperation.generateGradeCard(studentId, semesterId);
		
		double overallgpa=0.0;
		
		for(GradeCard course_grade : grades) {
			
			System.out.println("CourseId: " + course_grade.getCourseId() + " GPA: " + course_grade.getGpa());
			
			overallgpa += course_grade.getGpa();
		}
		
		overallgpa /= (double)grades.size();
		
		System.out.println("Overall GPA: " + overallgpa);

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
	
	@Override
	public List<Student> viewPendingAdmissions() {
		return adminDaoOperation.viewPendingAdmissions();
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
