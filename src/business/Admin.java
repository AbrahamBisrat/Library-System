package business;

import java.util.ArrayList;
import java.util.List;

public final class Admin extends Stuff{
	Address address;
	List<Book> allBooks;
	List<Member> membersList;
	
	Admin(String fName, String lName, String role){
		super(fName, lName, role);
		membersList = new ArrayList<>();
		allBooks = new ArrayList<>();
	}
	
	public Member addMember(String fName, String lName, Address thatAddress) {
		membersList.add(new Member(fName, lName, thatAddress));
		return membersList.get(membersList.size() - 1);
	}
	
	// this implementation needs to change, delete by name or id
	public boolean removeMember(Member removeThisMember) {
		if(!membersList.contains(removeThisMember))
			return false;
		
		membersList.remove(removeThisMember);
		return true;
	}
	
	public List<Member> getAllMembers() {
		return membersList;
	}
	public List<Book> getAllBooks() {
		return allBooks;
	}
	
	public void addBook(Book thisOne) {
		allBooks.add(thisOne);
	}
	
	public void addBooks(List<Book> listOfBooks) {
		allBooks.addAll(listOfBooks);
	}
	
	@Override public String toString() {
		return getDetails();
	}
}
