package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryMember implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private Address address;
	private String memberId;
	private String phoneNumber;
	private List<CheckoutEntry> checkoutList;
		
	public LibraryMember(String memId, String fName, String lName, 
			String phoneNum, Address thatAddress) {
		
		memberId = memId;
		firstName = fName;
		lastName = lName;
		phoneNumber = phoneNum;
		address = thatAddress;
		checkoutList = new ArrayList<>();
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public List<CheckoutEntry> getCheckouts(){
		return checkoutList;
	}
	
	public String getMemberId() { return memberId; }
	
	public void addCheckoutEntry(CheckoutEntry newCheckout) {
		checkoutList.add(newCheckout);
	}
	
	public CheckoutRecord getCheckoutRecord(){
		return new CheckoutRecord(checkoutList, this);
	}

	@Override public String toString() {
		return "LibraryMember [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", memberId=" + memberId + ", phoneNumber=" + phoneNumber + ", checkouts=" + checkouts + "]";
	}

	@Override public int hashCode() {
		return Objects.hash(memberId);
	}

	@Override public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibraryMember other = (LibraryMember) obj;
		return Objects.equals(memberId, other.memberId);
	}
}
