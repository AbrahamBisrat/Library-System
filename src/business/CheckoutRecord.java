package business;

import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord {
	List<CheckoutEntry> totalRecord;
	
	CheckoutRecord() {
		totalRecord = new ArrayList<>();
	}
	
	public void addRecord(CheckoutEntry newEntry) {
		totalRecord.add(newEntry);
	}
	
	private String getDetails() {
		String allBooks = "";
		
		for(CheckoutEntry eachEntry : totalRecord)
			allBooks += eachEntry + " , ";
		
		return "[ " + allBooks + " ]";
	}
	
	@Override public String toString() {
		return "From Checkout Record : \n " + getDetails();
	}
}
