package business;

import java.util.ArrayList;
import java.util.List;

public final class Admin extends Stuff{
	Address address;
	List<Book> allBooks;
	List<Member> membersList;
	
	
	Admin(String fName, String lName, String role, Address thatAddress){
		super(fName, lName, role);
		this.address = thatAddress;
		membersList = new ArrayList<>();
		allBooks = new ArrayList<>();
	}
	
	public void addMember(Member newMember) {
		membersList.add(newMember);
	}
	
	public void addMembers(List<Member> listOfMembers) {
		membersList.addAll(listOfMembers);
	}
	
	public boolean removeMember(Member removeThisMember) {
		if(!membersList.contains(removeThisMember))
			return false;
		
		membersList.remove(removeThisMember);
		return true;
	}
	
	public void addBook(Book thisOne) {
		allBooks.add(thisOne);
	}
	
	public void addBooks(List<Book> listOfBooks) {
		allBooks.addAll(listOfBooks);
	}
	
	@Override public String getDetails() {
		return "From Admin object : " + super.getDetails();
	}
	
	@Override public String toString() {
		return getDetails();
	}
}
