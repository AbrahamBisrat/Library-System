package business;

import java.util.ArrayList;
import java.util.List;

public final class Librarian extends Stuff{
	Roles role = Roles.LIBRARIAN;
	
	
	Librarian(String fName, String lName, String role) {
		super(fName, lName, Utils.LIBRARIAN);
	}
	
	public void checkout(Book thisBook, Member borrower) {
		CheckoutEntry checkout = new CheckoutEntry(this, borrower, thisBook);
	}
	
	@Override public String getDetails() { 
		return "From Library Object : " + super.getDetails();  
	}
	
	@Override public String toString() {
		return getDetails();
	}
}
