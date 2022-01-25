/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;
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
public class AdminDaoOperation implements AdminDaoInterface {

	Connection connection = DBUtils.getConnection();
	private PreparedStatement statement = null;

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
	public Vector<GradeCard> generateGradeCard(int studentId, int semesterId) {
		
		statement=null;
		Vector<GradeCard>grades=new Vector<GradeCard>();
		
		try {
			
			String sql = SQLQueriesConstant.VIEW_COURSES_GRADE;
			statement = connection.prepareStatement(sql);

			statement.setInt(1, studentId);
			statement.setInt(2, semesterId);

			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				GradeCard grade=new GradeCard();
				
				grade.setCourseId(resultSet.getInt("courseId"));
				grade.setSemesterId(semesterId);
				grade.setGpa(resultSet.getDouble("gpa"));
				grade.setStudentId(studentId);
				
				grades.add(grade);
			}
			
			return grades;
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}

		
		
		
	}
	
	/**
	 * 
	 * @param course
	 */
	@Override
	public void addCourse(Course course) {
		
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public Vector<Course> viewCourse() {
		
		return null;
	}
	
	/**
	 * 
	 * @param courseId
	 */
	@Override
	public void deleteCourse(int courseId) {
		
	}
	
	/**
	 * 
	 * @param user
	 */
	@Override
	public void addUser(User user) {
		
	}
}
