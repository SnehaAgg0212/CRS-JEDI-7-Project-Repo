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
	private int courseId;
	
	/**
	 * Default Constructor
	 */
	public SemesterRegistration() {
		
	}

	/**
	 * @param semesterId
	 * @param date
	 * @param courseId
	 */
	public SemesterRegistration(int semesterId, Date date, int courseId) {
		super();
		this.semesterId = semesterId;
		this.date = date;
		this.courseId = courseId;
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
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
}
