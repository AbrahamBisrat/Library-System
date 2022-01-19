package controller;

import business.*;
import dataaccess.*;

public class Controller {
		
	Address address = Factory.createAddress("1000 N, 4th Street");
	
	Admin admin = Factory.createAdmin("Admin", "Admin", Utils.ADMIN, address);
	
//	Author author = Factory.createAuthor("Josh", "Bloch", "Awesome Programmer", "Co-founded Java");
	
//	Book book = Factory.createBook("Effective Java", 234235);
	
	Librarian lib = Factory.createLibrarian("front desk", "reception", "Librarian");
	
//	CheckoutRecord cRecord = Factory.createCheckoutRecord();
	
	Member member = admin.addMember("Boiled", "Potatos", address);
	
//	CheckoutEntry newEntry = Factory.createCheckoutEntry(lib, member, book);
	
	public static void main(String[] args) {
		
		try {
			Controller c = new Controller();
//			c.cRecord.addRecord(c.newEntry);
//			System.out.println(c.cRecord);
		}
		catch(Exception e){
			System.out.println("What happened?");
		}
		
	}
	
	private void fetchTestingData() {
		// testing generated data
	}
}
