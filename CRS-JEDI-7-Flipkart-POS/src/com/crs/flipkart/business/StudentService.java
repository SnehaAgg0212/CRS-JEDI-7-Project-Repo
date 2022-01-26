/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.dao.RegistrationDaoInterface;
import com.crs.flipkart.dao.RegistrationDaoOperation;

/**
 * @author devanshugarg
 *
 */
public class StudentService implements StudentInterface {
	
	RegistrationDaoInterface registrationdao = new RegistrationDaoOperation();

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
	
	@Override
	public boolean semesterRegistration(int semester, int studentId) {
		boolean check = registrationdao.semesterRegistration(semester, studentId);
		if(!check) {
			boolean checkstatus = registrationdao.addSemester(semester, studentId);
			if(checkstatus) {
				System.out.println("Semester Registration is done Successfully");
				return true;
			}else {
				System.out.println("Semseter Registration is Failed, Please try again!");
			}
		}else {
			System.out.println("Registration of the semester is already done!");
		}
		return false;
	}
}
