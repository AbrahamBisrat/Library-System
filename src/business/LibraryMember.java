package business;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {
	private String firstName;
	private String lastName;
	private Address address;
	private String memberId;
	private String phoneNumber;
	private List<CheckoutEntry> checkouts;
	
	// package level
	public LibraryMember(String memberId, String fName, 
			String lName, String phoneNum, Address thatAddress) {
		
		this.memberId = memberId;
		this.firstName = fName;
		this.lastName = lName;
		this.phoneNumber = phoneNum;
		this.address = thatAddress;
		checkouts = new ArrayList<>();
	}

	public String getName() {
		return firstName + " " + lastName;
	}
	
	public List<CheckoutEntry> getCheckouts(){
		return checkouts;
	}
	
	public String getMemberId() { return memberId; }
	
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
