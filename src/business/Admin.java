package business;

import java.util.ArrayList;
import java.util.List;

public final class Admin extends Stuff{
	Address address;
	static List<Book> allBooks;
	static List<Member> membersList;
	// Compose librarian object for dual role
	
	
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
	
	public static List<Member> getAllMembers() {
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
		
		for(Member eachMember : getAllMembers()) {
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
	
	@Override public String toString() {
		return getDetails();
	}
}
