/**
 *
 */
package com.crs.flipkart.business;

import java.util.Scanner;
import java.util.Vector;

import com.crs.flipkart.bean.Admin;
import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;

/**
 * @author LENOVO
 *
 */
public class AdminService implements AdminInterface {

//	public static final GradeCard grades[] = new GradeCard[] {
//			new GradeCard(414, "Software Engineering", 1, 9.8, 7),
//			new GradeCard(213, "Modern Algebra", 1, 8, 7),
//			new GradeCard(212, "Software Project Management", 1, 10, 7)
//	};

	public static final Admin admin[] = new Admin[] {new Admin("userName",  "admin@gmail.com",  "admin",  "admin",  101,  "phoneNo", "Male",  "address",  "dateOfJoining"),
			new Admin("userName",  "admin1@gmail.com",  "admin1",  "admin",  102,  "phoneNo", "Male",  "address",  "dateOfJoining"),
			new Admin("userName",  "admin2@gmail.com",  "admin2",  "admin",  103,  "phoneNo", "Male",  "address",  "dateOfJoining"),
			new Admin("userName",  "admin3@gmail.com",  "admin3",  "admin",  104,  "phoneNo", "Female",  "address",  "dateOfJoining")};

	Scanner sc = new Scanner(System.in);

    static int profId = 100;
    static int userId = 1000;

    private void profIdincrementor() {
        profId ++;
    }

    private void userIdincrementor() {
        userId ++;
    }

    Vector<Student> StudentList = new Vector<>();
    Vector<Professor> ProfessorList = new Vector<>();
    Vector<Course> CourseList = new Vector<>();

    @Override
	public void addProfessor(Professor professor) {

	    professor.setProfessorId(profId);
	    professor.setUserId(userId);

	    profIdincrementor();
	    userIdincrementor();

	    ProfessorList.add(professor);
    }

	@Override
	public Vector<Professor> viewProfessor() {

	    return ProfessorList;
	}

	@Override
	public void deleteProfessor(int professorId) {

	    for(int i = 0; i < ProfessorList.size(); i++) {

	        if(ProfessorList.get(i) != null && professorId == ProfessorList.get(i).getProfessorId()){

	        	ProfessorList.removeElementAt(i);
	            System.out.println("Professor Deleted successfully.");
	            break;
	        }
	    }
	}

	@Override
	public boolean approveStudentRegistration(int studentId) {

		for (Student element : StudentList) {

			if(element.getStudentId() == studentId) {

				return false;
			}
		}
		return true;
	}

//	@Override
//	public void GenerateGradeCard(int studentId, String studentName, int semesterId)
//	{
//		System.out.println("Semester: " + semesterId);
//
//		System.out.println(" StudentId: " + studentId + " StudentName: " + studentName);
//
//		double overallGpa = 0.0;
//
//		for(GradeCard course_grade:grades) {
//			System.out.println(course_grade.getCourseId() + " " + course_grade.getCourseName() + " " + course_grade.getGpa());
//			overallGpa += course_grade.getGpa();
//		}
//
//		overallGpa /= (double)grades.length;
//
//		System.out.println("Overall GPA: " + overallGpa);
//
//	}

	@Override
	public void addCourse(Course course) {

		    CourseList.add(course);
	}

	@Override
	public Vector<Course> viewCourse() {

	    return CourseList;
	}

	@Override
	public void deleteCourse(int courseId) {

	    for(int i = 0; i < CourseList.size(); i++) {

	        if(CourseList.get(i) != null && courseId == CourseList.get(i).getCourseId()) {

	        	CourseList.removeElementAt(i);
	        	System.out.println("Course Deleted successfully.");
	            break;
	        }
	    }
	}

	@Override
	public void assignCourseToProfessor(int courseId, int professorId) {

		for (Course element : CourseList) {

			if(element != null && courseId == element.getCourseId()) {

				element.setProfessorId(professorId);
				System.out.println("Course Assigned to Professor successfully.");
				break;
			}
		}
	}
}
