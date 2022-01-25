/**
 * 
 */
package com.crs.flipkart.dao;

import java.util.Vector;

import com.crs.flipkart.bean.Course;

/**
 * @author LENOVO
 *
 */
public interface RegistrationDaoInterface {

	Vector<Course> viewCourses(int studentId);

	boolean addCourse(int studentId, int courseId);

	int totalRegisteredCourses(int studentId);

	boolean isSeatAvailable(int studentId);

	boolean dropCourse(int studentId, int courseId);

	Vector<Course> viewRegisteredCourses(int studentId);

}
