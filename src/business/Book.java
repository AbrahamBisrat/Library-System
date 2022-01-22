package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public final class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	private String title;
	private String iSBN;
	private boolean availablity;
	List<CheckoutEntry> checkoutList; 
	private List<Author> authors = new ArrayList<>();
	private int currentlyAvailable;
	private int maxCheckouts;
	private int maxBorrowDate;

	
	public Book(String isbn, String thatTitle, int numOfCopies,
			List<Author> authorList, int maxDate) {
		
		title = thatTitle;
		iSBN = isbn;
		currentlyAvailable = numOfCopies;
		availablity = true;
		authors.addAll(authorList);
		checkoutList = new ArrayList<>();
		maxCheckouts = numOfCopies;
		maxBorrowDate = maxDate;
	}
	
	public int getMaxBorrowDate() {
		return maxBorrowDate;
	}
	
	public int getMaxCheckouts() {
		return maxCheckouts;
	}
	
	public void addToMax(int max) {
		maxCheckouts += max;
		currentlyAvailable += max;
	}
	
	public List<Author> getAuthors(){
		return authors;
	}
	
	public String getISBN() {
		return iSBN;
	}
		
	public String getTitle() {
		return title;
	}

	public boolean isItAvailable() {
		return availablity;			// This should use number of Copies
	}

	public void makeUnavailable() {
		availablity = false;
	}

	public void makeAvailable() {
		availablity = true;
	}

	public void addAuthor(Author author) {
		authors.add(author);
	}

	public void addAuthors(List<Author> authorsList) {
		authors.addAll(authors);
	}

	public void addCheckoutEntry(CheckoutEntry thisOne) {
		checkoutList.add(thisOne);
	}
	
	public List<CheckoutEntry> getBorrowersList() {
		return checkoutList;
	}

	public void addCopy() {
		currentlyAvailable++;
		maxCheckouts++;
	}
	
	public void returnCopy() {
		currentlyAvailable++;
	}
	
	public void checkoutCopy() {
		currentlyAvailable--;
	}
	
	public int getCopies() {
		return currentlyAvailable;
	}
	
	@Override public String toString() {
		return "Book [title=" + title 
				+ ", iSBN=" + iSBN 
				+ ", availablity=" + availablity 
				+ ", authors=" + authors 
				+ ", Total Available = " + maxCheckouts
				+ ", currentlyAvailable=" + currentlyAvailable 
				+ ", checkoutList=" + checkoutList 
				+ "]\n";
	}

	@Override public int hashCode() {
		return Objects.hash(iSBN);
	}

	@Override public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(iSBN, other.iSBN);
	}
	
}
