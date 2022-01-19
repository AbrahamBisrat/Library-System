package business;

public class CheckoutEntry {
	private Stuff stuff;
	private Member member;
	private Book book;
	private String bookName;
	
	CheckoutEntry(Stuff thatStuff, Member thatMember, Book thatBook, String thatName){
		this.stuff = thatStuff;
		this.book = thatBook;
		this.member = thatMember;
		this.bookName = thatName;
	}
	
	private String getDetails() {
		return "\t Details for Book : " + bookName 
				+ "\nStuff : " + stuff
				+  "\n Member : " + member 
				+ "\n Book : " + book
				+ "\n";
	}
	
	@Override public String toString() {
		return getDetails();
	}
}
