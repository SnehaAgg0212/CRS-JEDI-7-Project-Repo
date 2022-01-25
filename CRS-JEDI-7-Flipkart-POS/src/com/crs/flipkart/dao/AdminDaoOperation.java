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
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.bean.User;

import com.crs.flipkart.constants.SQLQueriesConstant;

import java.util.Vector;

import com.crs.flipkart.utils.DBUtils;

/**
 * @author devanshugarg
 *
 */
public class AdminDaoOperation implements AdminDaoInterface {
	
	private PreparedStatement statement = null;
	Connection connection = DBUtils.getConnection();
	
	/**
	 * Default Constructor
	 */
	private AdminDaoOperation() {
		
	}
	
	/**
	 * 
	 * @param professor
	 */
	@Override
	public void addProfessor(Professor professor) {
		
		this.addUser(professor);
		
		statement = null;
		
		try {
			String sql = SQLQueriesConstant.ADD_PROFESSOR_QUERY;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, professor.getUserId());
			statement.setInt(2, professor.getProfessorId());
			statement.setString(3, professor.getDepartment());
			statement.setString(4, professor.getDesignation());
			int row = statement.executeUpdate();
			if (row == 0) {
				System.out.println("Professor with Professor Id " + professor.getProfessorId() + " not added.");
			} else {
				System.out.println("Professor with Professor Id " + professor.getProfessorId() + " added.");
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public Vector<Professor> viewProfessor() {
		
		statement = null;
		
		Vector<Professor> professorList = new Vector<>();
		
		try {
			String sql = SQLQueriesConstant.VIEW_PROFESSOR_QUERY;
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Professor professor = new Professor();
				professor.setProfessorId(resultSet.getInt(1));
				professor.setUserName(resultSet.getString(2));
				professor.setGender(resultSet.getString(3));
				professor.setDepartment(resultSet.getString(4));
				professor.setDesignation(resultSet.getString(5));
				professorList.add(professor);
			}
			System.out.println("Total Number of Professors in the Institute: " + professorList.size());
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return professorList;
	}
	
	/**
	 * 
	 * @param professorId
	 */
	@Override
	public void deleteProfessor(int professorId) {
	
		statement = null;
		
		try {
			String sql = SQLQueriesConstant.DELETE_PROFESSOR_QUERY;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, professorId);
			int row = statement.executeUpdate();
			if (row == 0) {
				System.out.println("Professor with Professor Id " + professorId + " does not exists.");
			} else {
				System.out.println("Professor with Professor Id " + professorId + " deleted.");
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
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
