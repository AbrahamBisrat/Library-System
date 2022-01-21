package controller;

import java.util.ArrayList;
import java.util.List;

import business.*;
import dataaccess.Auth;
import dataaccess.*;
import dataaccess.TestData;


public class Controller {
	
	Admin admin = new Admin(" >>> Mr.", "XYZ", Auth.ADMIN, "admin", "admin");
	DataAccess db = new DataAccessFacade(); 
	Librarian lib;
	LibraryMember mem;
	Address addr;
	
	
	
	public static void main(String[] args) {
		TestData.main(args); 
		
		Controller c = new Controller();
		// Admin side Tests
		
		Address ad = new Address("10034 street", "fairfield", "IA", "52557");
//		
//		System.out.println(Admin.getAllMembers());
		
		c.admin.addMember("879876", "Boiled", "Potatos", "0976986756", ad);
		
//		System.out.println("\nAdd : " + db.readMemberMap());
		
		c.admin.removeMember("879876");
		
//		System.out.println("remove : " + Admin.getAllMembers());
//		
//		System.out.println(db.readBooksMap());
//		
//		System.out.println();
		
		List<Author> authors = new ArrayList<>() {
			{
				add(new Author("Joe", "Thomas", "641-445-2123", ad, "A happy man is he."));
	            add(new Author("Sandra", "Thomas", "641-445-2123", ad, "A happy wife is she."));
	            add(new Author("Nirmal", "Pugh", "641-919-3223", ad, "Thinker of thoughts."));
	            add(new Author("Andrew", "Cleveland", "976-445-2232", ad, "Author of childrens' books."));
	            add(new Author("Sarah", "Connor", "123-422-2663", ad, "Known for her clever style."));
			}
		};
		
//		System.out.println("\n\n Books before add \n\n");
//		System.out.println(admin.showBooks());
//		
//		admin.addBook("23544", "Effective Java", 12, authors);
//		
//		System.out.println("\n\n Books remove \n\n");
//		System.out.println(admin.showBooks());
//		
//		System.out.println("\n\n Books AFTER REMOVE \n\n");
//		
//		admin.removeBook("23544");
//		
//		System.out.println(admin.showBooks());
		
		
		// Librarian Tests
		
		Librarian lib = new Librarian("front desk", "reception");
		
		System.out.println("Checkout and return tests");
		
		
//		admin.addMember("2342342", "Peter", "Gregory", "987957", ad);
		LibraryMember thisGuy = LibraryMember.membershipList.get(0);
		Book thisBook = Book.catalog.get(0);
		System.out.println("Checking in....");
		System.out.println("Member : " + thisGuy);
		System.out.println("Book : " + thisBook);
		
		lib.checkout(thisBook, thisGuy);
		
		System.out.println("\n\nAfter Checkouts");
		
		System.out.println(Librarian.allCheckouts.size());
		
		System.out.println(Librarian.allCheckouts.toString());
//		System.out.println("Book : " + thisBook);
		
		
		
		// days calculation		
	}
	
	
}
