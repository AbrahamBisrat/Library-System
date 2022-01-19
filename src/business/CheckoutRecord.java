package business;

import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord {
	List<CheckoutEntry> thisRecord;
	
	CheckoutRecord(List<CheckoutEntry> thatRecord, Member member) {
		thisRecord = thatRecord;
	}
	
	public void addRecord(CheckoutEntry newEntry) {
		thisRecord.add(newEntry);
	}
	
	private String getDetails() {
		String allBooks = "";
		
		for(CheckoutEntry eachEntry : thisRecord)
			allBooks += eachEntry + " , ";
		
		return "[ " + allBooks + " ]";
	}
	
	@Override public String toString() {
		return "From Checkout Record : \n " + getDetails();
	}
}
