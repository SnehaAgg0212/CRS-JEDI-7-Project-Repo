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
	
	public static final String ADD_STUDENT_QUERY = "insert into Student(userId, branchName, batch) values (?, ?, ?)";
	
	public static final String GET_REGISTERED_COURSE_FEE = "select courseFee from course where courseId IN (select courseId from registeredcourse where studentId = ?)";
 	public static final String PAYMENT_STATUS = "select status from payment where studentId = ?";

 	public static final String ADD_PAYMENT = "insert into payment(invoiceId, studentId, amount, status) values(?, ?, ?, ?)";
 	public static final String PAYMENT_CARD = "insert into card(invoiceId, cardType, cardNumber, cardHolderName, cvv, bankName, expiryDate) values(?, ?, ?, ?, ?, ?, ?)";
 	public static final String PAYMENT_CHEQUE = "insert into cheque(invoiceId, chequeNo, bankAccountHolderName, bankAccountNumber, ifsc, bankName, bankBranchName, chequeDate) values(?, ?, ?, ?, ?, ?, ?, ?)";
 	public static final String PAYMENT_NETBANKING = "insert into netbanking(bankName, bankAccountHolderName, invoiceId) values(?, ?, ?)";

 	public static final String SET_GRADECARD_STATUS = "update Student set isGenerated = 1 where studentId = ?";
 	public static final String IS_GENERATED = "select isGenerated from student where studentId = ?";
 	
 	public static final String GET_COURSES = "select professor.professorId, course.courseId, course.courseName, course.courseSeats from course INNER JOIN professor where course.courseId = professor.courseId and professorId = ?";
 	public static final String GET_ENROLLED_STUDENTS = "select professor.professorId as professorId, course.courseId as courseId, course.courseName as courseName, registeredcourse.studentId as studentId from course inner join registeredcourse on course.courseId = registeredcourse.courseId INNER JOIN professor on course.courseId = professor.courseId where professor.professorId = ? order by course.courseId";
 	public static final String ADD_GRADE = "update gradecard set gpa=? where courseId=? and studentId=? and semesterId = ?";
 	public static final String GET_PROF_NAME = "SELECT professor.professorId, user.userName FROM user INNER JOIN professor WHERE professorId = ?";
 	public static final String ADD_COURSE_TO_PROFESSOR = "update Professor set courseId = ? where professorId = ?";
 	public static final String GET_AVAILABLE_COURSES = "select course.courseId, course.courseName, course.courseDescription, course.courseFee, course.courseSeats from course where courseId not in (select courseId from Professor)";
 	public static final String CHECK_SELECTED_COURSE = "select courseId from professor where professorId = ?";
 	
 	public static final String VIEW_AVAILABLE_COURSES = "select * from Course where courseSeats > 0 and courseId not in (select courseId from registeredCourse where studentId = ?)";
 	public static final String TOTAL_REGISTERED_COURSES = "select courseId from registeredCourse where studentId = ?";
 	public static final String AVAILABLE_SEATS = "select courseSeats from Course where courseId = ?";
 	public static final String ADD_COURSE = "insert into registeredcourse (studentId,courseId) values (?, ?)";
 	public static final String DECREMENT_SEAT = "update Course set courseSeats = courseSeats-1 where courseId = ? ";
 	public static final String DROP_COURSE = "delete from registeredcourse where studentId = ? AND courseId = ?";
 	public static final String INCREMENT_SEAT = "update Course set courseSeats = courseSeats + 1 where courseId = ? ";
 	public static final String VIEW_REGISTERED_COURSES = "select * from Course inner join registeredCourse on Course.courseId = registeredCourse.courseId where registeredCourse.studentId = ?";
 	public static final String CHECK_STUDENT_AND_SEM = "select studentId from semesterRegistration where studentId = ? and semester = ?";
 	public static final String ADD_SEMESTER = "insert into semesterRegistration(semesterId, studentId, semester, date) values (?, ?, ?, curdate())";

 	public static final String UPDATE_PASSWORD = "update user set userPassword=? where userEmailId = ?";
 	public static final String VERIFY_CREDENTIALS = "select userPassword from user where userEmailId = ?";
 	public static final String GET_ROLE = "select role from user where userId = ?";
}
