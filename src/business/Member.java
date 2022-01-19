package business;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private String firstName;
	private String lastName;
	private Address address;
	private List<CheckoutEntry> checkouts;
	
	// package level
	Member(String fName, String lName, Address thatAddress) {
		this.firstName = fName;
		this.lastName = lName;
		this.address = thatAddress;
		checkouts = new ArrayList<>();
	}

	public String getName() {
		return firstName + " " + lastName;
	}
	
	public List<CheckoutEntry> getCheckouts(){
		return checkouts;
	}
	
	public void addCheckoutRecord(CheckoutEntry newCheckout) {
		checkouts.add(newCheckout);
	}
	
	public String getAllDetails() {
		String allBorrowedBooks = (checkouts.isEmpty()) ?
				"No Borrowed books recorded." : "";
		for(CheckoutEntry eachCheckout : checkouts)
			allBorrowedBooks += eachCheckout.getBook() + "\n";
		
		return this.toString() + allBorrowedBooks;
	}
	
	public CheckoutRecord getCheckoutRecord(){
		return new CheckoutRecord(checkouts, this);
	}
	
	@Override public String toString() {
		return getName();
	}
}
