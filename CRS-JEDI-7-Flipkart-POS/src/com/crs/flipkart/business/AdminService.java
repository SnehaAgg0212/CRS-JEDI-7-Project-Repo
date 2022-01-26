/**
 *
 */
package com.crs.flipkart.business;

import java.util.Scanner;
import java.util.Vector;

import com.crs.flipkart.bean.Admin;
import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.GenderConstant;
import com.crs.flipkart.constants.RoleConstant;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperation;

/**
 * @author LENOVO
 *
 */
public class AdminService implements AdminInterface {
	
	AdminDaoInterface adminDaoOperation = new AdminDaoOperation();

//	static Vector<GradeCard> stud1 = new Vector<>() {{
//		add (new GradeCard(401, "SE",101, 9, 7)); 
//		add (new GradeCard(402, "DSA",101, 8, 7)); 
//		add (new GradeCard(403, "Java",101, 8.5, 7));
//	}};
//	
//	static Vector<GradeCard> stud2 = new Vector<>() {{
//		add (new GradeCard(401, "SE",102, 9.8, 7));
//		add (new GradeCard(402, "DSA",102, 9.2, 7)); 
//		add (new GradeCard(403, "Java",102, 9, 7));
//	}};
//	
//	public static final HashMap<Integer, Vector<GradeCard>> grades = new HashMap<Integer, Vector<GradeCard>>() {{
//			put(101, stud1);
//			put(102, stud2);
//		}};
	
	public static final Admin admin = new Admin("userName",  "admin@gmail.com",  "admin",  RoleConstant.ADMIN,  101,  "phoneNo", GenderConstant.MALE,  "address",  "dateOfJoining");
	
	Scanner sc = new Scanner(System.in);

    static int profId = 100;
    static int userId = 1000;

    private void profIdincrementor() {
        profId ++;
    }

    private void userIdincrementor() {
        userId ++;
    }

//    Vector<Student> StudentList = new Vector<Student>() {{
//    	add(new Student("username_1", "username_1@flipkart.com", "ABCD", "student", 1,
//				"1234567890", "female", "location", "CS", 101, 123, false));
//			add(new Student("username_2", "username_2@flipkart.com", "ABCD", "student", 1,
//					"1234567890", "female", "location", "CS", 102, 123, false));
//			add(new Student("username_3", "username_3@flipkart.com", "ABCD", "student", 1,
//					"1234567890", "female", "location", "CS", 103, 123, false));
//    }};
    Vector<Student> StudentList = new Vector<>();
    Vector<Professor> ProfessorList = new Vector<>();
    Vector<Course> CourseList = new Vector<>();

    @Override
	public void addProfessor(Professor professor) {

	    professor.setProfessorId(profId);
	    professor.setUserId(userId);

	    profIdincrementor();
	    userIdincrementor();

	    adminDaoOperation.addProfessor(professor);
    }

	@Override
	public Vector<Professor> viewProfessor() {

	    return adminDaoOperation.viewProfessor();
	}

	@Override
	public void deleteProfessor(int professorId) {

		adminDaoOperation.deleteProfessor(professorId);
	}

	@Override
	public void approveStudentRegistration(int studentId) {

		adminDaoOperation.approveStudentRegistration(studentId);
	}

	@Override
	public void generateGradeCard(int studentId, int semesterId)
	{
		Vector<GradeCard> grades = new Vector<>();
		
		grades = adminDaoOperation.generateGradeCard(studentId, semesterId);
		
		double overallgpa=0.0;
		
		for(GradeCard course_grade : grades) {
			
			System.out.println("CourseId: " + course_grade.getCourseId() + " GPA: " + course_grade.getGpa());
			
			overallgpa += course_grade.getGpa();
		}
		
		overallgpa /= (double)grades.size();
		
		System.out.println("Overall GPA: " + overallgpa);

	}

	@Override
	public void addCourse(Course course) {

		adminDaoOperation.addCourse(course);
	}

	@Override
	public Vector<Course> viewCourse() {

	    return adminDaoOperation.viewCourse();
	}

	@Override
	public void deleteCourse(int courseId) {

		adminDaoOperation.deleteCourse(courseId);
	}

//	@Override
//	public void assignCourseToProfessor(int courseId, int professorId) {
//
//		for (Course element : CourseList) {
//
//			if(element != null && courseId == element.getCourseId()) {
//
//				element.setProfessorId(professorId);
//				System.out.println("Course Assigned to Professor successfully.");
//				break;
//			}
//		}
//	}
}
