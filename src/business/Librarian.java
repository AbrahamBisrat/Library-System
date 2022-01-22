package business;

import dataaccess.Auth;
import dataaccess.DataAccess;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataaccess.*;

public final class Librarian extends Stuff implements Serializable{
	private static final long serialVersionUID = 1L;
	Auth role = Auth.LIBRARIAN;
	private DataAccess dbLib = new DataAccessFacade();
	
	Librarian(String libId, String fName, String lName) {
		super(fName, lName, Auth.LIBRARIAN);
	}
	
	public boolean checkout(String iSBN, String memberId) {
		Book thisBook = getBookWithISBN(iSBN);
		LibraryMember borrower = getMemberWithId(memberId);
		if(thisBook == null || thisBook.getCopies() <= 0 || borrower == null)
			return false;
		CheckoutEntry checkout = 
				new CheckoutEntry(borrower, thisBook);
		thisBook.checkoutCopy();
		
		updateBookInDB(thisBook);
		updateMemberInDB(borrower);
		return true;
	}
	
	public void returnBook(String iSBN) { // number of copies, availablity
		Book thisBook = getBookWithISBN(iSBN);
		if(thisBook == null)
			return;
		
		for(CheckoutEntry e : thisBook.getBorrowersList())
			if(e.getBook().equals(thisBook))
				e.returned();
		updateBookInDB(thisBook);	// update user info as well
	}
	
	private void updateMemberInDB(LibraryMember m) {
		dbLib.updateMember(m);
	}

	private void updateBookInDB(Book b) {
		dbLib.updateBook(b);
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
	
	public HashMap<String, LibraryMember> getAllMembers() {
		return dbLib.readMemberMap();
	}
	
	@Override public String getDetails() { 
		return "From Library Object : " + super.getDetails();  
	}
	
	
	@Override public String toString() {
		return getDetails();
	}
}
