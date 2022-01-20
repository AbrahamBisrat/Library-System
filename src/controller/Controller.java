package controller;

import java.util.ArrayList;
import java.util.List;

import business.*;
import dataaccess.Auth;
import dataaccess.TestData;


public class Controller {
	
	Admin admin = new Admin(" >>> Mr.", "XYZ", Auth.ADMIN, "admin", "admin");
	Librarian librarian = new Librarian("front desk", "reception");
	
	public static void main(String[] args) {
		
		TestData.main(args);
		
		Controller c = new Controller();
		System.out.println(c.admin.getAllMembers());
		System.out.println("\n" + c.admin.getAllBooks());
		System.out.println("\n" + c.admin);
		System.out.println(c.admin.checkoutHistory());
				
		// days calculation
		
		
	}
}
