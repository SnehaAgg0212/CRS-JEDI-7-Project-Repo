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

		AdminService adminServices = new AdminService();
		@SuppressWarnings("unused")
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("Enter the number to perform the task:-\n1. AddProfessor()\n 2. Delete Professor\n3. View Professor\n exit");  
			int a= sc.nextInt();  
			
			switch(a) {
				case 1: 
					adminServices.addProfessor();
					break;

				case 2: 
					adminServices.deleteProfessor();
					break;
				
				case 3: 
					adminServices.viewProfessor();
					break;

				default:
					break;
			}
			
			if(a > 3) {
				break;
			}
		}
		sc.close();
	}
	
}
