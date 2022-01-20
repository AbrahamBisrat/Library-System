package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import dataaccess.*;

public final class Admin extends Stuff{
	private String username = "";
	private String password = "";
	
	static List<Book> allBooks;
	static List<LibraryMember> membersList;
	
	private DataAccess db = new DataAccessFacade();
	
	// Compose librarian object for dual role
	
	public Admin(String fName, String lName, Auth role, 
			String thatUsername, String thatPassword){
		
		super(fName, lName, role);
		this.username = thatUsername;
		this.password = thatPassword;
		membersList = new ArrayList<>();
		allBooks = new ArrayList<>();
		
		// adding to database would be more flexible
		// adding details to Database...
	}
	
	public LibraryMember addMember(String memId, String fName, String lName, 
			String phoneNum, Address address) {
		LibraryMember newMember = new LibraryMember(memId, fName, lName, phoneNum, address);
		membersList.add(newMember);
		
		// adding entry to database
		db.saveNewMember(newMember);
		
		return membersList.get(membersList.size() - 1);
	}
	
	// this implementation needs to change, delete by name or id
	public boolean removeMember(String memId) {
		db.removeMember(memId);
//		if(!membersList.contains(removeThisMember))
//			return false;
//		
//		membersList.remove(removeThisMember);
		return true;  // review this
	}
	
	public static List<LibraryMember> getAllMembers() {
		return membersList;
	}
	public static List<Book> getAllBooks() {
		return allBooks;
	}
	
	public void addBook(Book thisOne) {
		allBooks.add(thisOne);
	}
	
	public void addBooks(List<Book> listOfBooks) {
		allBooks.addAll(listOfBooks);
	}
	
	public String checkoutHistory() {
		String historyIntro = "\n\n History of Every Checkout \n";
		
		String messageBody = "";
		
//		System.out.println(TEXT_RED + "This text is red!" + TEXT_RESET);
		
		for(LibraryMember eachMember : getAllMembers()) {
			String everyUsersHistory = "";
			for(CheckoutEntry e : eachMember.getCheckouts()) {
				everyUsersHistory += "[ " + e.getMember().getName() 
						+ "  borrowed : " + e.getBook().getTitle() 
						+ "  on : " + e.getCheckoutDate()
						+ ((e.isItReturned()) ? 
								(Utils.TEXT_GREEN + " returned on : " + e.getReturnedDate() + " ]" + Utils.TEXT_RESET) 
								: (Utils.TEXT_RED + " not returned!" + Utils.TEXT_RESET + " ]")) 
						+ "\n";
			}
			messageBody += everyUsersHistory;
		}
		if(messageBody.equals(""))
			messageBody = "No data found";
		
		return historyIntro + messageBody;
	}
	
	public DataAccess getdb() { return db; }
	
	@Override public String toString() {
		return getDetails();
	}

	@Override public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(password, username);
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	
}
