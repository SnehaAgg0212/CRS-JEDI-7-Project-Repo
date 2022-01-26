/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Admin;
import com.crs.flipkart.bean.Student;

/**
 * @author devanshugarg
 *
 */
public class StudentService implements StudentInterface {
	
//	String userName, String userEmailId, String userPassword, String role, int userId, String phoneNo,
//	String gender, String address, String branchName, int studentId, int batch, boolean isApproved
	public static final Student student = new Student("userName",  "student@gmail.com",  "student",  "student",  101,  "phoneNo", "Male",  "address","branchName",13,2022,true);

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
	
	public Boolean isGenerated(int studentId) {
		
		return null;
		
	}
}
