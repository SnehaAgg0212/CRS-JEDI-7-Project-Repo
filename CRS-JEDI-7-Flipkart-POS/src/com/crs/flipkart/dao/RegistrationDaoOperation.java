/**
 * 
 */
package com.crs.flipkart.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;
import java.sql.Date;

import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.DBUtils;

/**
 * @author devanshugarg
 *
 */
public class RegistrationDaoOperation implements RegistrationDaoInterface {
		
		Connection connection = DBUtils.getConnection();
		private PreparedStatement statement = null;
		

		public double calculateFee(int studentId) {
			
			statement=null;
			
			double fee=0.0;
			
		try {
				String sql = SQLQueriesConstant.GET_REGISTERED_COURSE_FEE;
				statement = connection.prepareStatement(sql);
				statement.setInt(1, studentId);
				ResultSet resultSet = statement.executeQuery();
				
				while(resultSet.next())
				{
					fee+=resultSet.getDouble("courseFee");
				}
				
				return fee;
			
		}
		catch(SQLException e){
			
			System.out.println(e.getMessage());
			return fee;
		}
		
	}

	public boolean getRegistrationStatus(int studentId) {
		statement=null;
		
		//System.out.println(studentId);
		
	try {
			String sql = SQLQueriesConstant.IS_APPROVED;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);
			ResultSet resultSet = statement.executeQuery();
			
			
			 if(resultSet.next() && resultSet.getInt("isApproved")==1)
				 return true;
			 else
				 return false;
			 
			 
			 
	}
	catch(SQLException e){
		
		System.out.println(e.getMessage());	
		return false;	
		}
	}

	public boolean getPaymentStatus(int studentId) {
		statement=null;
		
		
	try {
			String sql = SQLQueriesConstant.PAYMENT_STATUS;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);
			ResultSet resultSet = statement.executeQuery();
			
			//System.out.println("DONE till now");
			
			 if(resultSet.next() && resultSet.getInt("status")==1)
				 return true;
			 else
				 return false;
	}
	catch(SQLException e){
		
		System.out.println(e.getMessage());	
		return false;	
	}
	}
	
	public void paymentByCard(int studentId,int invoiceId,String cardType,String cardNumber,String cardHolderName,int cvv,String bankName,Date expiryDate) {

		statement=null;
		
		
	try {
			String sql = SQLQueriesConstant.PAYMENT_CARD;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, invoiceId);
			statement.setString(2, cardType);
			statement.setString(3, cardNumber);
			statement.setString(4, cardHolderName);
			statement.setInt(5, cvv);
			statement.setString(6, bankName);
			statement.setDate(7,expiryDate);
			
			statement.executeUpdate();
			
	}
	catch(SQLException e){
		
		System.out.println(e.getMessage());	
	}
		
	}
	
	public void paymentByCheque(int studentId,int invoiceId,int chequeNo,String bankAccountHolderName,String bankAccountNumber,String ifsc,String bankName,String bankBranchName,Date chequeDate) {

		statement=null;
		
		
		try {
				String sql = SQLQueriesConstant.PAYMENT_CHEQUE;
				statement = connection.prepareStatement(sql);
				statement.setInt(1, invoiceId);
				statement.setInt(2, chequeNo);
				statement.setString(3, bankAccountHolderName);
				statement.setString(4, bankAccountNumber);
				statement.setString(5, ifsc);
				statement.setString(6, bankName);
				statement.setString(7,bankBranchName);
				statement.setDate(8,chequeDate);
				

				statement.executeUpdate();
				
		}
		catch(SQLException e){
			
			System.out.println(e.getMessage());	
		}

	}
	
	public void paymentByNetBanking(int studentId,int invoiceId,String bankAccountHolderName,String bankName) {
		statement=null;
		
		
		try {
				String sql = SQLQueriesConstant.PAYMENT_NETBANKING;
				statement = connection.prepareStatement(sql);
				statement.setString(1, bankName);
				statement.setString(2, bankAccountHolderName);
				statement.setInt(3, invoiceId);
				statement.executeUpdate();
		
			}
		catch(SQLException e){
			
			System.out.println(e.getMessage());	
		}
		
	}
	
	public void setPaymentStatus(int studentId,int invoiceId,double amount) {
		statement=null;
		
		
		
		try {
				String sql = SQLQueriesConstant.ADD_PAYMENT;
				statement = connection.prepareStatement(sql);
				statement.setInt(1, invoiceId);
				statement.setInt(2, studentId);
				statement.setDouble(3, amount);
				statement.setBoolean(4, true);

				statement.executeUpdate();
		
			}
		catch(SQLException e){
			
			System.out.println(e.getMessage());	
		}
		
		
			
	}
	
	public boolean isGenerated(int studentId) {
		
		statement=null;
		
		
		
		try {
				String sql = SQLQueriesConstant.IS_GENERATED;
				statement = connection.prepareStatement(sql);
				statement.setInt(1, studentId);

				ResultSet resultSet = statement.executeQuery();
				
				//System.out.println("DONE till now");
				
				 if(resultSet.next() && resultSet.getInt("isGenerated")==1)
					 return true;
				 else
					 return false;
		
			}
		catch(SQLException e){
			System.out.println(e.getMessage());				
			return false;
		}
		
		
	}

	@Override
	public Vector<GradeCard> viewGradeCard(int studentId,int semesterId) {
		// TODO Auto-generated method stub
		
		Vector<GradeCard>grades=new Vector<GradeCard>();
		
		statement=null;
		
		try {
			String sql = SQLQueriesConstant.VIEW_COURSES_GRADE;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);
			statement.setInt(2, semesterId);

			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				GradeCard gradeCard = new GradeCard();
				gradeCard.setCourseId(resultSet.getInt("courseId"));
				gradeCard.setSemesterId(semesterId);
				gradeCard.setGpa(resultSet.getDouble("gpa"));
				gradeCard.setStudentId(studentId);
				grades.add(gradeCard);				
			}
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());				
		}
		
		return grades;
		
		
	}

	

}

	
