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
	
	public void addCheckoutRecord(CheckoutEntry newCheckout) {
		checkouts.add(newCheckout);
	}
	
	public List<CheckoutEntry> getCheckoutList(){
		return checkouts;
	}
	
	public String getAllDetails() {
		String allBorrowedBooks = (checkouts.isEmpty()) ?
				"No Borrowed books recorded."
				: "";
		for(CheckoutEntry eachCheckout : checkouts)
			allBorrowedBooks += eachCheckout.getBook() + "\n";
		
		return this.toString() + allBorrowedBooks;
	}

	@Override public String toString() {
		return getName();
	}
}
