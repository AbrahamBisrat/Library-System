package business;

import dataaccess.Auth;

public final class Librarian extends Stuff{
	Auth role = Auth.LIBRARIAN;
	
	
	public Librarian(String fName, String lName) {
		super(fName, lName, Auth.LIBRARIAN);
	}
	
	public void checkout(Book thisBook, LibraryMember borrower) {
		CheckoutEntry checkout = new CheckoutEntry(this, borrower, thisBook);
	}
	
	
	// Caution! Fancy code ahead
	
	public void returnBook(Book thisOne) {
		for(LibraryMember eachMember : Admin.getAllMembers())
			for(CheckoutEntry everyCheckout : eachMember.getCheckouts())
				if(everyCheckout.getBook().equals(thisOne))
					everyCheckout.returned();
	}
	
	@Override public String getDetails() { 
		return "From Library Object : " + super.getDetails();  
	}
	
	@Override public String toString() {
		return getDetails();
	}
}
