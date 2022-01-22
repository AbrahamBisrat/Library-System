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
		
	public static void main(String[] args) {  // refactor c.methods
		TestData.main(args); 
		
		Controller c = new Controller();
		
		Address ad = new Address("10034 street", "fairfield", "IA", "52557");
		
		//adminSideTests(c, ad);
		
		librarianSideTests(c);
		
		System.out.println(c.db.readUserMap());
		
		// days calculation		
	}

	private static void librarianSideTests(Controller c) {
//		Librarian lib = new Librarian("lib2342", "front desk", "reception");
		
		Librarian lib = c.admin.addLibrarian("lib2342", "lib_userName", "front desk", "reception");
		
		System.out.println("\n		Checkout and return tests");
		
		// let's see members and books
		System.out.println(c.admin.showBooks());
		System.out.println(Admin.getAllMembers());
		
		lib.checkout("99-22223", "1001");
		
		System.out.println("\n\n Did the changes Stick!");
		System.out.println(c.admin.getdb().readMemberMap().get("1001"));
		System.out.println(c.admin.getdb().readBooksMap().get("99-22223"));
		
		System.out.println("\n After checkout of  '99-22223' by '1001'\n");
		System.out.println(c.admin.showBooks());
		System.out.println(Admin.getAllMembers());
		
		System.out.println("\n\n\t Checking Returns ");
		lib.returnBook("99-22223");
		System.out.println(c.admin.showBooks());
		c.admin.addCopy("99-22223", 8);
		System.out.println(Admin.getAllBooks());
	}

	private static void adminSideTests(Controller c, Address ad) {
		System.out.println(Admin.getAllMembers());
		
		c.admin.addMember("879876", "Boiled", "Potatos", "0976986756", ad);

		System.out.println("\nAdd : " + c.db.readMemberMap());
		
		c.admin.removeMember("1001"); // needs work
		
		System.out.println("remove : " + Admin.getAllMembers());

		System.out.println("\nBooks Testing...\n\n");
		
		List<Author> authors = new ArrayList<>() {
			{
				add(new Author("Joe", "Thomas", "641-445-2123", ad, "A happy man is he."));
	            add(new Author("Sandra", "Thomas", "641-445-2123", ad, "A happy wife is she."));
	            add(new Author("Nirmal", "Pugh", "641-919-3223", ad, "Thinker of thoughts."));
	            add(new Author("Andrew", "Cleveland", "976-445-2232", ad, "Author of childrens' books."));
	            add(new Author("Sarah", "Connor", "123-422-2663", ad, "Known for her clever style."));
			}
		};
		
		System.out.println("	Books before add \n");
		System.out.println(c.admin.showBooks());

		c.admin.addBook("23544", "Effective Java", 12, authors);
		
		System.out.println("Books after add\n" + c.admin.showBooks());
		
		System.out.println("\n\n Books remove 'Thinking in Java' \n\n");
		c.admin.removeBook("99-22223");
		System.out.println(c.admin.showBooks());
		
		
		System.out.println("\n\n Books AFTER REMOVE Book with iSBN 23544\n\n");
		
		c.admin.removeBook("23544");
		
		System.out.println(c.admin.showBooks());
	}
	
	public CheckoutRecord getCheckoutList(LibraryMember mem) {
		return mem.getCheckoutRecord();
	}
	
	public List<LibraryMember> getBorrowerList(Book b) {
		List<LibraryMember> borrowers = new ArrayList<>();
		
		for(CheckoutEntry everyCheckout : b.getBorrowersList())
			borrowers.add(everyCheckout.getMember());
		
		return borrowers;	
	}
	
	
}
