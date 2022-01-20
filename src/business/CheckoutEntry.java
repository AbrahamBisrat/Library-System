package business;

import java.time.LocalDate;

public final class CheckoutEntry {
	private Stuff stuff;
	private LibraryMember member;
	private Book book;
	private LocalDate checkoutDate;
	private LocalDate returnDate;
	private boolean returned;
	
	CheckoutEntry(Stuff thatStuff, LibraryMember thatMember, Book thatBook){
		this.stuff = thatStuff;
		this.book = thatBook;
		this.member = thatMember;
		checkoutDate = LocalDate.now();
		
		thatBook.makeUnavailable();
		returned = false;
		
		addToStuffList();
		addToMemberList();
	}
	
	private void addToMemberList() {
		member.getCheckouts().add(this);
	}
	
	public boolean isItReturned() {
		return returned;
	}
	
	public LocalDate getReturnedDate() {
		if(!returned)
			return null;
		return returnDate;
	}

	private void addToStuffList() {
		stuff.allCheckouts.add(this);
	}
	
	private String getDetails() {
		return "\t Details for Book : " + book
				+ "\nStuff : " + stuff
				+  "\n Member : " + member 
				+ "\n Book : " + book
				+ "\n";
	}
	
	public Book getBook() {
		return book;
	}
	
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	
	public Stuff getStuff() {
		return stuff;
	}
	
	public LibraryMember getMember() {
		return member;
	}
	
	public void returned() {
		returnDate = LocalDate.now();
		returned = true;
	}
	
	@Override public String toString() {
		return getDetails();
	}
}
