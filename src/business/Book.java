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
	private List<CheckoutEntry> checkoutList; 
	private List<Author> authors = new ArrayList<>();
	private int numberOfCopies;
	
	// revise availablity logic
	
	public Book(String isbn, String thatTitle, int numOfCopies,
			List<Author> authorList) {
		
		title = thatTitle;
		iSBN = isbn;
		numberOfCopies = numOfCopies;
		availablity = true;
		authors.addAll(authorList);
		checkoutList = new ArrayList<>();
	}
	
	public Book(String isbn, String thatTitle, int numOfCopies,
			List<Author> authorList, List<CheckoutEntry> previousCheckouts) {
		
		title = thatTitle;
		iSBN = isbn;
		numberOfCopies = numOfCopies;
		availablity = true;
		authors.addAll(authorList);
		checkoutList = previousCheckouts;
	}
	
	public List<Author> getAuthors(){
		return authors;
	}
	public void setCheckouts(List<CheckoutEntry> setToThis) {
		checkoutList = setToThis;
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
		numberOfCopies++;
	}
	
	public int getCopies() {
		return numberOfCopies;
	}
	
	@Override public String toString() {
		return "Book [title=" + title 
				+ ", iSBN=" + iSBN 
				+ ", availablity=" + availablity 
				+ ", authors=" + authors 
				+ ", numberOfCopies=" + numberOfCopies 
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
