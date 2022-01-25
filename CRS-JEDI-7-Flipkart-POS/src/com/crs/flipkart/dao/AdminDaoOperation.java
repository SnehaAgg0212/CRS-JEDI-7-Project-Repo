/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.RegisteredCourse;
import com.crs.flipkart.bean.User;
import com.crs.flipkart.constants.SQLQueriesConstant;

import java.util.Vector;

import com.crs.flipkart.utils.DBUtils;

/**
 * @author devanshugarg
 *
 */
public class AdminDaoOperation implements AdminDaoInterface{

	Connection connection = DBUtils.getConnection();
	PreparedStatement statement = null;

	/**
	 * 
	 * @param professor
	 */
	@Override
	public void addProfessor(Professor professor) {

	}

	/**
	 * 
	 * @return
	 */
	@Override
	public Vector<Professor> viewProfessor() {

		return null;
	}

	/**
	 * 
	 * @param professorId
	 */
	@Override
	public void deleteProfessor(int professorId) {

	}

	/**
	 * 
	 * @param studentId
	 */
	@Override
	public void approveStudentRegistration(int studentId) {

	}

	/**
	 * 
	 * @param studentId
	 * @param semesterId
	 * @return
	 */
	@Override
	public Vector<RegisteredCourse> generateGradeCard(int studentId, int semesterId) {

		return null;
	}

	public boolean checkCourse(int courseId) {

		Vector<Course> courseList = viewCourse();
		for (Course course : courseList) {
			if (course.getCourseId() == courseId) {
				return true;
			}
		}
		return false;

	}

	/**
	 * 
	 * @param course
	 */
	@Override
	public void addCourse(Course course) {
		try {
			if (checkCourse(course.getCourseId())) {
				System.out.println("Course with this Id is already present!");
				return;
			}
			String sql = SQLQueriesConstant.ADD_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, course.getCourseId());
			statement.setString(2, course.getCourseName());
			statement.setString(3, course.getCourseDescription());
			statement.setDouble(4, course.getCourseFee());
			statement.setInt(5, course.getCourseSeats());
			statement.executeUpdate();

		} catch (SQLException se) {

		}

	}

	/**
	 * 
	 * @return
	 */
	@Override
	public Vector<Course> viewCourse() {
		Vector<Course> courseList = new Vector<Course>();
		try {
			String sql = SQLQueriesConstant.VIEW_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				Course course = new Course();
				course.setCourseId(result.getInt("courseId"));
				course.setCourseName(result.getString("courseName"));
				course.setCourseDescription(result.getString("courseDescription"));
				course.setCourseFee(result.getDouble("courseFee"));
				course.setCourseSeats(result.getInt("courseSeats"));

				courseList.add(course);
			}

		} catch (SQLException se) {

		}
		return courseList;
	}

	/**
	 * 
	 * @param courseId
	 */
	@Override
	public void deleteCourse(int courseId) {
		try {
			if (!checkCourse(courseId)) {
				System.out.println("Course with this Id is not present!");
				return;
			}
			String sql = SQLQueriesConstant.DELETE_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, courseId);
			statement.executeUpdate();

		} catch (SQLException se) {

		}
	}

	/**
	 * 
	 * @param user
	 */
	@Override
	public void addUser(User user) {

	}
}
