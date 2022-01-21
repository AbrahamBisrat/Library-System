package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable{
	List<CheckoutEntry> thisRecord;
	LibraryMember member;
	
	CheckoutRecord(List<CheckoutEntry> thatRecord, LibraryMember thatMember) {
		thisRecord = thatRecord;
		this.member = thatMember;
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
	
	public LibraryMember getMember() {
		return member;
	}
	
	@Override public String toString() {
		return "From Checkout Record : \n " + getDetails();
	}
}
