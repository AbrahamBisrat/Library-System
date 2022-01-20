package controller;

import java.util.ArrayList;
import java.util.List;

import business.*;
import dataaccess.Auth;
import dataaccess.*;
import dataaccess.TestData;


public class Controller {
	
	Admin admin = new Admin(" >>> Mr.", "XYZ", Auth.ADMIN, "admin", "admin");
	Librarian librarian = new Librarian("front desk", "reception");
	
	public static void main(String[] args) {
		TestData.main(args); 
		
		DataAccess db = new DataAccessFacade();
		
		Address ad = new Address("10034 street", "fairfield", "IA", "52557");
		
		LibraryMember newGuy = new LibraryMember("879876", "Boiled", "Potatos", 
										"0976986756", ad);
		
		System.out.println(db.readMemberMap());
		
		db.saveNewMember(newGuy);
		
		System.out.println(db.readMemberMap());
		
//		Controller c = new Controller();
//		System.out.println(c.admin.getAllMembers());
//		System.out.println("\n" + c.admin.getAllBooks());
//		System.out.println("\n" + c.admin);
//		System.out.println(c.admin.checkoutHistory());
				
		// days calculation
		
		
	}
}
