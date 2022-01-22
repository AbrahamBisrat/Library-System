package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class CheckoutEntry implements Serializable{
	private static final long serialVersionUID = 1L;
	LibraryMember member;
	Book book;
	LocalDate checkoutDate;
	LocalDate returnDate;
	boolean returned;
	
	CheckoutEntry(LibraryMember thatMember, Book thatBook){
		book = thatBook;
		member = thatMember;
		checkoutDate = LocalDate.now();
		
		thatBook.makeUnavailable();
		returned = false;
		
		member.addCheckoutEntry(this);
		thatBook.addCheckoutEntry(this);
	}
	
	public boolean isItReturned() {
		return returned;
	}
	
	public LocalDate getReturnedDate() {
		if(!returned)
			return null;
		return returnDate;
	}
	
	public Book getBook() {
		return book;
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
				+ "]";
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
