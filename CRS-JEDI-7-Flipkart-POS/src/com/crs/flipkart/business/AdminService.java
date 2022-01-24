/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.GradeCard;
/**
 * @author LENOVO
 *
 */
public class AdminService {
	
	GradeCard grades[]=new GradeCard[] {
			new GradeCard(414,"Software Engineering",1,9.8,7),
			new GradeCard(213,"Modern Algebra",1,8,7),
			new GradeCard(212,"Software Project Management",1,10,7)
	};
	
	public void GenerateGradeCard(int studentId,int semesterId)
	{
		System.out.println("Semester:"+semesterId);
		
		System.out.println("StudentName: "+" StudentId:"+studentId);
		
		double overallGpa=0.0;

		for(GradeCard course_grade:grades) {
			System.out.println(course_grade.getCourseId()+" "+course_grade.getCourseName()+" "+course_grade.getGpa());
			overallGpa+=course_grade.getGpa();
		}
		
		overallGpa/=(double)grades.length;
		
		System.out.println("Overall GPA:"+overallGpa);
		
	}
	
	
	

}
