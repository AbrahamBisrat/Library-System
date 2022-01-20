package controller;

import java.util.ArrayList;
import java.util.List;

import business.*;
import dataaccess.Auth;
import dataaccess.*;
import dataaccess.TestData;


public class Controller {
	
	public static void main(String[] args) {
		//Librarian librarian = new Librarian("front desk", "reception");
		
		TestData.main(args); 

		Admin admin = new Admin(" >>> Mr.", "XYZ", Auth.ADMIN, "admin", "admin");
		
		DataAccess db = new DataAccessFacade();
		
		Address ad = new Address("10034 street", "fairfield", "IA", "52557");
		
		System.out.println(db.readMemberMap());
		
		admin.addMember("879876", "Boiled", "Potatos", "0976986756", ad);
		
		System.out.println("\n" + db.readMemberMap());
		
		admin.removeMember("879876");
		
		System.out.println(db.readMemberMap());
//		Controller c = new Controller();
//		System.out.println(c.admin.getAllMembers());
//		System.out.println("\n" + c.admin.getAllBooks());
//		System.out.println("\n" + c.admin);
//		System.out.println(c.admin.checkoutHistory());
				
		// days calculation
		
		
	}
}
