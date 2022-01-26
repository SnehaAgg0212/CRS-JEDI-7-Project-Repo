/**
 * 
 */
package com.crs.flipkart.constants;

/**
 * @author devanshugarg
 *
 */
public class SQLQueriesConstant {

	/**
	 * AdminDaoQueries
	 */
	public static final String ADD_USER_QUERY = "insert into User(userId, userName, userEmailId, userPassword, role, phoneNo, gender, address) values (?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String ADD_PROFESSOR_QUERY = "insert into Professor(userId, professorId, department, designation) values (?, ?, ?, ?)";
	public static final String VIEW_PROFESSOR_QUERY = "select professorId, userName, gender, department, designation from Professor P natural join User U where P.userId = U.userId";
	public static final String DELETE_PROFESSOR_QUERY = "delete from Professor where professorId = ?";
	public static final String ADD_COURSE_QUERY = "insert into Course(courseId, courseName, courseDescription, courseFee, courseSeats) values (?, ?, ?, ?, ?)";
	public static final String VIEW_COURSE_QUERY = "select courseCode, courseName, courseDescription, courseFee, courseSeats from Course";
	public static final String DELETE_COURSE_QUERY = "delete from Course where courseId = ?";
	public static final String APPROVE_STUDENT_QUERY = "update Student set isApproved = 1 where studentId = ?";
	public static final String GET_STUDENT_ID = "select studentId from student where userId = ?";
	public static final String GET_PROFESSOR_ID = "select professorId from professor where userId = ?";
	public static final String IS_APPROVED = "select isApproved from student where studentId = ?";
	public static final String VIEW_COURSES_GRADE = "select courseId, gpa from gradecard where studentId = ? and semesterId = ?";
	
	public static final String GET_REGISTERED_COURSE_FEE="select courseFee from course where courseId IN (select courseId from registeredcourse where studentId = ?)";
	public static final String PAYMENT_STATUS = "select status from payment where studentId = ?";
	
	public static final String ADD_PAYMENT = "insert into payment(invoiceId,studentId,amount,status) values(?,?,?,?)";
	public static final String PAYMENT_CARD = "insert into card(invoiceId,cardType,cardNumber,cardHolderName,cvv,bankName,expiryDate) values(?,?,?,?,?,?,?)";
	public static final String PAYMENT_CHEQUE = "insert into cheque(invoiceId,chequeNo,bankAccountHolderName,bankAccountNumber,ifsc,bankName,bankBranchName,chequeDate) values(?,?,?,?,?,?,?,?)";
	public static final String PAYMENT_NETBANKING = "insert into netbanking(bankName,bankAccountHolderName,invoiceId) values(?,?,?)";
	
	public static final String SET_GRADECARD_STATUS="update Student set isGenerated = 1 where studentId = ?";
	public static final String IS_GENERATED="select isGenerated from student where studentId = ?";
	


}
