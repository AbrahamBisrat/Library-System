package business;

import dataaccess.Auth;
import dataaccess.DataAccess;

import java.util.ArrayList;
import java.util.List;

import dataaccess.*;

public final class Librarian extends Stuff{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Auth role = Auth.LIBRARIAN;
	private DataAccess dbLib = new DataAccessFacade();
	public static List<CheckoutEntry> allCheckouts = new ArrayList<>();
	
	public Librarian(String fName, String lName) {
		super(fName, lName, Auth.LIBRARIAN);
	}
	
	public void checkout(Book thisBook, LibraryMember borrower) {
		CheckoutEntry checkout = new CheckoutEntry(borrower, thisBook);
	}
	
	
	// Caution! Fancy code ahead
	
//	public void returnBook(Book thisOne) {
//		for(LibraryMember eachMember : dbLib.readBooksMap().values())
//			for(CheckoutEntry everyCheckout : eachBook.getCheckouts())
//				if(everyCheckout.getBook().equals(thisOne))
//					everyCheckout.returned();
//	}
	
	@Override public String getDetails() { 
		return "From Library Object : " + super.getDetails();  
	}
	
	@Override public String toString() {
		return getDetails();
	}
}
