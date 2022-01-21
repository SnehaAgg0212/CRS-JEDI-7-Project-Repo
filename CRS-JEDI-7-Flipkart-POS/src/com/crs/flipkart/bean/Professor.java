/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author devanshugarg
 *
 */
public class Professor extends User {

	private int professorId;
	private String department;
	private String designation;
	
	/**
	 * Default Constructor
	 */
	public Professor() {
	}
	
	/**
	 * @param userName
	 * @param userEmailId
	 * @param userPassword
	 * @param role
	 * @param userId
	 * @param phoneNo
	 * @param gender
	 * @param address
	 * @param professorId
	 * @param department
	 * @param designation
	 */
	public Professor(String userName, String userEmailId, String userPassword, String role, int userId, String phoneNo,
			String gender, String address, int professorId, String department, String designation) {
		super(userName, userEmailId, userPassword, role, userId, phoneNo, gender, address);
		this.professorId = professorId;
		this.department = department;
		this.designation = designation;
	}

	/**
	 * @return the professorId
	 */
	public int getProfessorId() {
		return professorId;
	}
	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
