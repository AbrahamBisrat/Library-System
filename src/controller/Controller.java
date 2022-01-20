package controller;

import java.util.ArrayList;
import java.util.List;

import business.*;
import dataaccess.Auth;


public class Controller {
	
	Admin admin = new Admin(" >>> Mr.", "XYZ", Auth.ADMIN, "admin", "admin");
	Librarian librarian = Factory.createLibrarian("front desk", "reception", "Librarian");
	
	public static void main(String[] args) {
		
		try {
			Controller c = new Controller();
			c.fetchTestingData();
			System.out.println(c.admin.getAllMembers());
			System.out.println("\n" + c.admin.getAllBooks());
			System.out.println("\n" + c.admin);
			System.out.println(c.admin.checkoutHistory());
			
		}
		catch(Exception e){
			System.out.println("What happened?");
		}
				
		// days calculation
		
	}
	
	// In the following iterations this will be replaced by the db;
	private void fetchTestingData() {
		 Address address = Factory.createAddress("1000 N 4th st", 
				 "Fairfield", "IOWA", 52557, 123456789);
		 Author author = Factory.createAuthor("Josh", "Bloch", 
				 "Awesome Programmer", "Co-founded Java", address);
		 
		 Author a1 = Factory.createAuthor
				 ("author", "One", "PHD", "no story", address);
	
		 admin.addMember("first", "Potato", address);
		 admin.addMember("second", "Potato", address);
		 admin.addMember("third", "Potato", address);
		 admin.addMember("fourth", "Potato", address);
		 admin.addMember("fifth", "Potato", address);
		 
		 List<Book> book = new ArrayList<>();
		 book.add(Factory.createBook("Effective Java", 12345));
		 book.add(Factory.createBook("Design Patterns", 23456));
		 book.add(Factory.createBook("Refactoring", 34567));
		 book.add(Factory.createBook("Cracking the Coding interview", 45678));
		 
		 book.get(0).addAuthor(author); // too lazy to make another author
		 book.get(1).addAuthor(author);
		 book.get(2).addAuthor(a1);
		 book.get(3).addAuthor(author);
		 
		 admin.addBooks(book);
		 
		 librarian.checkout(book.get(2), admin.getAllMembers().get(0));
		 librarian.checkout(book.get(3), admin.getAllMembers().get(2));
		 librarian.checkout(book.get(1), admin.getAllMembers().get(3));
		 librarian.checkout(book.get(0), admin.getAllMembers().get(1));
		 
		 
		 librarian.returnBook(book.get(2));
		 librarian.returnBook(book.get(0));
		 
		 
	}
	
	private String showFullRecord() {
		// enumerate over all the members data
		return null;
	}
}
