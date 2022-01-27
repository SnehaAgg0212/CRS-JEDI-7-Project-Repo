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
	public void register(Student student) {
		
		studentDaoOperation.addStudent(student);
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
 				return true;
 			} else {
 				System.out.println("Semseter Registration is Failed, Please try again!");
 			}
 		}
 		return false;
 	}
}
