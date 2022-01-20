package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public final class Book implements Serializable{
	private String title;
	private String iSBN;
	private boolean availablity;
	private List<LibraryMember> borrowerList;
	private List<Author> authors = new ArrayList<>();
	private int numberOfCopies;
	
	// revise availablity logic
	
	public Book(String iSBN, String thatTitle, int numberOfCopies,
			List<Author> authorList) {
		
		this.title = thatTitle;
		this.iSBN = iSBN;
		this.numberOfCopies = numberOfCopies;
		availablity = true;
		authors.addAll(authorList);
		borrowerList = new ArrayList<>();
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

	public void addBorrower(LibraryMember thisOne) {
		borrowerList.add(thisOne);
	}

	public String getAllDetails() {
		String allBorrowers = (borrowerList.isEmpty()) ? 
				"No member has borrowed this book yet." 
				: "Members who borrowed this book are : \n";
		
		String allAuthors = (authors.isEmpty()) ?
				"No authors have been recorded.\n"
				: "";
		
		for(LibraryMember eachBorrower : borrowerList)
			allBorrowers += eachBorrower.getName() + "\n";
		
		for(Author eachAuthor : authors)
			allAuthors += eachAuthor.getName() + "\n";
		
		return this.toString() + allBorrowers + allAuthors;
	}

	@Override public String toString() {
		return "[ Book Title : " + getTitle() + "\t iSBN id : " + getISBN() + " ] ";
	}

	public void addCopy() {
		numberOfCopies++;
	}

	@Override public int hashCode() {
		return Objects.hash(iSBN, title);
	}

	@Override public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(iSBN, other.iSBN) && Objects.equals(title, other.title);
	}
	
}
