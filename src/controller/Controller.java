package controller;

import java.util.ArrayList;
import java.util.List;

import business.*;
import dataaccess.*;

public class Controller {
	
	Admin admin = Factory.createAdmin("Admin", "Admin", Utils.ADMIN);
	Librarian librarian = Factory.createLibrarian("front desk", "reception", "Librarian");
	
	public static void main(String[] args) {
		
		try {
			Controller c = new Controller();
			c.fetchTestingData();
			System.out.println(c.admin.getAllMembers());
			System.out.println("\n" + c.admin.getAllBooks());
			System.out.println("\n" + c.admin);
		}
		catch(Exception e){
			System.out.println("What happened?");
		}
	}
	
	private void fetchTestingData() {
		 Address address = Factory.createAddress("1000 N 4th st", 
				 "Fairfield", "IOWA", 52557, 123456789);
		 Author author = Factory.createAuthor("Josh", "Bloch", 
				 "Awesome Programmer", "Co-founded Java", address);
		 
		 admin.addMember("first", "Potato", address);
		 admin.addMember("second", "Potato", address);
		 admin.addMember("third", "Potato", address);
		 admin.addMember("fourth", "Potato", address);
		 admin.addMember("fifth", "Potato", address);
		 
		 List<Book> thisBooks = new ArrayList<>();
		 new Factory();
		 thisBooks.add(Factory.createBook("Effective Java", 12345));
		 thisBooks.add(Factory.createBook("Design Patterns", 23456));
		 thisBooks.add(Factory.createBook("Refactoring", 34567));
		 thisBooks.add(Factory.createBook("Cracking the Coding interview", 45678));
		 
		 thisBooks.get(0).addAuthor(author); // too lazy to make another author
		 thisBooks.get(1).addAuthor(author);
		 thisBooks.get(2).addAuthor(author);
		 thisBooks.get(3).addAuthor(author);
		 
		 admin.addBooks(thisBooks);
		 
		 Author a1 = Factory.createAuthor("author", "One", "PHD", "no story", address);
	}
	
	private String showFullRecord() {
		// enumerate over all the members data
		return null;
	}
}
