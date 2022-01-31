/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author anirudhagupta
 *
 */
@SuppressWarnings("serial")
public class ProfessorAlreadyRegisteredException extends Exception {

	/**
	 * 
	 */
	private int professorId;
	
	public ProfessorAlreadyRegisteredException(int professorId) {
		// TODO Auto-generated constructor stub
		this.professorId = professorId;
	}
	
	
	public int getProfessorId() {
		return professorId;
	}
	
	/**
	 * Message returned when Exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Professer with Professor Id: " + professorId + " has already registered.";
	}
	

}
