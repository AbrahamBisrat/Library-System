package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class CheckoutEntry implements Serializable{
	private static final long serialVersionUID = 1L;
	private LibraryMember member;
	private Book book;
	private LocalDate checkoutDate;
	private LocalDate returnDate;
	

	private boolean returned;
	
	String trial = "show this on table";
	
	CheckoutEntry(LibraryMember thatMember, Book thatBook){
		book = thatBook;
		member = thatMember;
		checkoutDate = LocalDate.now();
		
		thatBook.makeUnavailable();
		returned = false;
		
		member.addCheckoutEntry(this);
		thatBook.addCheckoutEntry(this);
	}
	
	public String getBookTitle() {
		return book.getTitle();
	}
	
	public String getISBN() {
		return book.getISBN();
	}
	
	public boolean getReturned() {
		return returned;
	}
	
	public Book getBook() {
		return book;
	}
	
	public int getCurrentlyAvailableBooks() {
		return book.getCurrentlyAvailable();
	}
	
	public LocalDate getReturnDate() {
		return returnDate;
	}
	
	public String getMemberId() {
		return member.getMemberId();
	}
	
	public String getMemberName() {
		return member.getFullName();
	}
	
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	
	public LibraryMember getMember() {
		return member;
	}
	
	public void returned() {
		returnDate = LocalDate.now();
		returned = true;
		book.makeAvailable();
		book.returnCopy();
	}
	
	@Override public String toString() {
		return "CheckoutEntry [member=" + member.getFullName()
				+ ", book=" + book.getTitle() 
				+ ", checkoutDate="	+ checkoutDate 
				+ ", returnDate=" + returnDate 
				+ ", returned=" + returned 
				+ "]\n";
	}
	
	@Override public int hashCode() {
		return Objects.hash(book, checkoutDate, member);
	}
	
	@Override public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckoutEntry other = (CheckoutEntry) obj;
		return Objects.equals(book, other.book) && Objects.equals(checkoutDate, other.checkoutDate)
				&& Objects.equals(member, other.member);
	}
}
