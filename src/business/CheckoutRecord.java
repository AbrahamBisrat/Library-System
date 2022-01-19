package business;

import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord {
	List<Book> totalRecord;
	
	CheckoutRecord() {
		totalRecord = new ArrayList<>();
	}
	
	public void addRecord(Book newEntry) {
		totalRecord.add(newEntry);
	}
	
	private String getDetails() {
		return totalRecord.toArray().toString();
	}
	
	@Override public String toString() {
		return "From Checkout Record : \n " + getDetails();
	}
}
