package controller;

import business.*;
import dataaccess.*;

public class Controller {
		
	Address address = Factory.createAddress("1000 N, 4th Street");
	Admin admin = Factory.createAdmin("Admin", "Admin", Utils.ADMIN, address);
	Author author = Factory.createAuthor("Josh", "Bloch", "Awesome Programmer", "Co-founded Java");
	Book book = Factory.createBook("Effective Java", 234235);
	Librarian lib = Factory.createLibrarian("front desk", "reception", "Librarian");
	Member member = Factory.createMember("Boiled", "Potatos", address);
	CheckoutEntry newEntry = Factory.createCheckoutEntry(lib, member, book);
	CheckoutRecord cRecord = Factory.createCheckoutRecord();
	
	public static void main(String[] args) {
		Controller c = new Controller();
		
		c.cRecord.addRecord(c.newEntry);
		System.out.println(c.cRecord);
		
	}
	
	private void fetchTestingData() {
		// testing generated data
	}
}
