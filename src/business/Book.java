package business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Book {
	private String title;
	private int iSBN;
	private LocalDate checkoutDate;
	private boolean availablity;
	private List<Member> borrowerList;
	private List<Author> authors;
	
	// Dates for checkout and returns
	
	
	// package level
	Book(String thatTitle, int iSBN) {
		this.title = thatTitle;
		this.iSBN = iSBN;
		availablity = true;
		authors = new ArrayList<>();
		borrowerList = new ArrayList<>();
		checkoutDate = LocalDate.now();
	}

	public int getISBN() {
		return iSBN;
	}
	
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	
	public String getTitle() {
		return title;
	}

	public boolean isItAvailable() {
		return availablity;
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

	public void addBorrower(Member thisOne) {
		borrowerList.add(thisOne);
	}

	public String getAllDetails() {
		String allBorrowers = (borrowerList.isEmpty()) ? 
				"No member has borrowed this book yet." 
				: "Members who borrowed this book are : \n";
		
		String allAuthors = (authors.isEmpty()) ?
				"No authors have been recorded.\n"
				: "";
		
		for(Member eachBorrower : borrowerList)
			allBorrowers += eachBorrower.getName() + "\n";
		
		for(Author eachAuthor : authors)
			allAuthors += eachAuthor.getName() + "\n";
		
		return this.toString() + allBorrowers + allAuthors;
	}

	@Override public String toString() {
		return "[ Book Title : " + getTitle() + "\t iSBN id : " + getISBN() + " ] ";
	}
}
