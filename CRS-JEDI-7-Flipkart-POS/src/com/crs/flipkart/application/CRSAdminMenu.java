/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;

import com.crs.flipkart.business.AdminService;

/**
 * @author LENOVO
 *
 */
public class CRSAdminMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Scanner sc = new Scanner(System.in);
		AdminService adminService = new AdminService();
		int id = sc.nextInt();
		if(adminService.approveStudentRegistration(id)) {
			System.out.println("Student Registration is successful.");
		} else {
			System.out.println("Student Registration is failed.");
		}
	}

}
