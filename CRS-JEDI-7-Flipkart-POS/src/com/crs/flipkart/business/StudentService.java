/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.GenderConstant;
import com.crs.flipkart.constants.RoleConstant;
import com.crs.flipkart.dao.RegistrationDaoInterface;
import com.crs.flipkart.dao.RegistrationDaoOperation;
import com.crs.flipkart.dao.StudentDaoInterface;
import com.crs.flipkart.dao.StudentDaoOperation;

/**
 * @author devanshugarg, iamshambhavi
 *
 */
public class StudentService implements StudentInterface {
	
	StudentDaoInterface studentDaoOperation = new StudentDaoOperation();
	RegistrationDaoInterface registrationDaoOperation = new RegistrationDaoOperation();
	
	public static final Student student = new Student("userName",  "student@gmail.com",  "student",  RoleConstant.STUDENT,  101,  "phoneNo", GenderConstant.MALE,  "address", "branchName", 13, 2022, true);

	@Override
	public int register(String userName, String userEmailId, String userPassword, int userId, String phoneNo,
			GenderConstant gender, String address, String branch, int batch) {
				
		Student student = new Student(userName, userEmailId, userPassword, RoleConstant.STUDENT, 
 				userId, phoneNo, gender, address, branch, userId, batch, false);

 		int studentId = 0;

 		System.out.println("Your account has been created and pending for Approval by the Admin.");
 		studentId = studentDaoOperation.addStudent(student);

 		return studentId;
	}
	
	@Override
	public int getStudentId(int userId) {
		
		return studentDaoOperation.getStudentId(userId);
	}
	
	@Override
	public Boolean isApproved(int studentId) {
		
		return studentDaoOperation.isApproved(studentId);
	}
	
	@Override
	public Boolean isGenerated(int studentId) {

 		return null;
 	}
	
	@Override
	public boolean semesterRegistration(int semester, int studentId) {
		
 		boolean check = registrationDaoOperation.semesterRegistration(semester, studentId);
 		if(!check) {
 			boolean checkstatus = registrationDaoOperation.addSemester(semester, studentId);
 			if(checkstatus) {
 				System.out.println("Semester Registration is done Successfully.");
 				return true;
 			} else {
 				System.out.println("Semseter Registration is Failed, Please try again!");
 			}
 		} else {
 			System.out.println("Registration of the semester is already done!");
 		}
 		return false;
 	}
}
