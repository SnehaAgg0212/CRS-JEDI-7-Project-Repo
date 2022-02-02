/**
 * 
 */
package com.crs.flipkart.validator;

import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;

/**
 * @author devanshugarg
 *
 */
public class AdminValidator {

	/**
	 * Is Valid New Course
	 * @param newCourse
	 * @param courseList
	 * @return 
	 */
	public static boolean isValidNewCourse(Course newCourse, Vector<Course> courseList) {
		
		for(Course course : courseList) {
			if(newCourse.getCourseId() == course.getCourseId()) {
				return false; 
			}
		}
		return true;
	}
	
	/**
	 * Is Valid Drop Course
	 * @param dropCourseId
	 * @param courseId
	 * @return 
	 */
	public static boolean isValidDropCourse(int dropCourseId, Vector<Course> courseList) {
		
		for(Course course : courseList) {
			if(dropCourseId == course.getCourseId()) {
				return true; 
			}
		}
		return false;
	}
	
	/**
	 * Is Valid Unapproved Student
	 * @param studentId
	 * @param studentList
	 * @return 
	 */
	public static boolean isValidUnapprovedStudent(int studentId, Vector<Student> studentList) {
		
		for(Student student : studentList) {
			if(studentId == student.getStudentId()) {
				return true;
			}
		}
		return false;
	}
}
