package controller;

import business.*;


public class Controller {
	public static void main(String[] args) {
		
		Address address = Factory.createAddress("1000 N, 4th Street");
		Admin admin = Factory.createAdmin("Admin", "Admin", "Administrator");
		Author author = Factory.createAuthor("Josh Bloch");
		Book book = Factory.createBook("Effective Java");
		Librarian lib = Factory.createLibrarian("front desk", "reception", "Librarian");
		Member member = Factory.createMember("Boiled", "Potatos");
		CheckoutEntry newEntry = Factory.createCheckoutEntry(lib, member, book);
		CheckoutRecord cRecord = Factory.createCheckoutRecord();
		cRecord.addRecord(newEntry);
		
		System.out.println(cRecord);
		
	}
}
