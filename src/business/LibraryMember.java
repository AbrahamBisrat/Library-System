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

	public LibraryMember(String memId, String fName, String lName, 
			String phoneNum, Address thatAddress) {
		memberId = memId;
		firstName = fName;
		lastName = lName;
		phoneNumber = phoneNum;
		address = thatAddress;
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

	@Override
	public String toString() {
		return "LibraryMember [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", memberId=" + memberId + ", phoneNumber=" + phoneNumber + ", checkouts=" + checkouts + "]";
	}
	
	public static void main(String[] args) {
		
		LibraryMember l = new LibraryMember("32423", "do!", "optimally", "and prosper", null);
		System.out.println(l);
		
	}
}
