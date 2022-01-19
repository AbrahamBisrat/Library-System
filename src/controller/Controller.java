package controller;

import business.*;


public class Controller {
	public static void main(String[] args) {
		
		Address address = Factory.createAddress("1000 N, 4th Street");
		Admin admin = Factory.createAdmin("Admin", "Admin", Utils.ADMIN, address);
		Author author = Factory.createAuthor("Josh", "Bloch", "Awesome Programmer", "Co-founded Java");
		Book book = Factory.createBook("Effective Java", 234235);
		Librarian lib = Factory.createLibrarian("front desk", "reception", "Librarian");
		Member member = Factory.createMember("Boiled", "Potatos", address);
		CheckoutEntry newEntry = Factory.createCheckoutEntry(lib, member, book);
		CheckoutRecord cRecord = Factory.createCheckoutRecord();
		cRecord.addRecord(newEntry);
		
		System.out.println(cRecord);
		
	}
}
