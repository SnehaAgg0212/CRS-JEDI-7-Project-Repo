/**
 * 
 */
package com.crs.flipkart.bean;

import java.util.Date;

/**
 * @author devanshugarg
 *
 */
public class SemesterRegistration {

	private int semesterId;
	private Date date;
	private int studentId;
	
	/**
	 * Default Constructor
	 */
	public SemesterRegistration() {
		
	}

	/**
	 * @param semesterId
	 * @param date
	 * @param studentId
	 */
	public SemesterRegistration(int semesterId, Date date, int studentId) {
		super();
		this.semesterId = semesterId;
		this.date = date;
		this.studentId = studentId;
	}

	/**
	 * @return the semesterId
	 */
	public int getSemesterId() {
		return semesterId;
	}

	/**
	 * @param semesterId the semesterId to set
	 */
	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the courseId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
}
