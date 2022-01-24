/**
 * 
 */
package com.crs.flipkart.business;

/**
 * @author devanshugarg
 *
 */
public class StudentService implements StudentInterface {

	@Override
	public String register(String userName, String userEmailId, String userPassword, int userId, String phoneNo,
			String gender, String address, String branch, int batch) {
				
		return null;
	}
	
	@Override
	public String getStudentId(String userId) {
		
		return null;
	}
	
	@Override
	public Boolean isApproved(String studentId) {
		
		return false;
	}
}
