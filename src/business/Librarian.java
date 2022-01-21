package business;

import dataaccess.Auth;
import dataaccess.DataAccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataaccess.*;

public final class Librarian extends Stuff{
	private static final long serialVersionUID = 1L;
	Auth role = Auth.LIBRARIAN;
	private DataAccess dbLib = new DataAccessFacade();
	public static List<CheckoutEntry> checkouts = new ArrayList<>();
	
	public Librarian(String fName, String lName) {
		super(fName, lName, Auth.LIBRARIAN);
	}
	
	public void checkout(String iSBN, String memberId) {
		Book thisBook = getBookWithISBN(iSBN);
		LibraryMember borrower = getMemberWithId(memberId);
		
		if(thisBook == null || borrower == null)
			return;
		
		CheckoutEntry checkout = new CheckoutEntry(borrower, thisBook, this);
//		System.out.println("from Checkout method : ");
//		System.out.print(borrower.toString());
//		System.out.print(thisBook);
//		System.out.print(checkout);
		
		// updating database
		thisBook.setCheckouts(null);
		updateBookInDB(thisBook);
	}
	
	private void updateBookInDB(Book b) {
		dbLib.updateBook(b.getISBN(), b.getTitle(), b.getCopies(), 
				b.getAuthors(), b.getBorrowersList());
	}

	private LibraryMember getMemberWithId(String memId) {
		try {
			return dbLib.readMemberMap().get(memId);
		}
		catch(Exception e) {
			return null;
		}
	}
	
	private Book getBookWithISBN(String iSBN) {
		try {
			return dbLib.readBooksMap().get(iSBN);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public void addCheckoutEntry(CheckoutEntry thisCheckout) {
		checkouts.add(thisCheckout);
	}
	
	public HashMap<String, LibraryMember> getAllMembers() {
		return dbLib.readMemberMap();
	}
	
	// Caution! Fancy code ahead
	// has not been fully implemented yet
	
	public void returnBook(Book thisOne) {
//		for(LibraryMember eachMember : dbLib.readBooksMap().values())
//			for(CheckoutEntry everyCheckout : eachBook.getCheckouts())
//				if(everyCheckout.getBook().equals(thisOne))
//					everyCheckout.returned();
	}
	
	@Override public String getDetails() { 
		return "From Library Object : " + super.getDetails();  
	}
	
	@Override public String toString() {
		return getDetails();
	}
}
