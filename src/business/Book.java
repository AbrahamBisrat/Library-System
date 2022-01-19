package business;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private String title;
	private int iSBN;
	private boolean availablity;
	private List<Member> borrowerList;
	private List<Author> authors;
	
	// package level
	Book(String thatTitle, int iSBN){
		this.title = thatTitle;
		this.iSBN = iSBN;
		availablity = true;
		authors = new ArrayList<>();
		borrowerList = new ArrayList<>();
	}
	
	public String getTitle() { return title; }
	public int getISBN() { return iSBN; }
	public boolean isItAvailable() { return availablity; }
	public void makeUnavailable() { availablity = false; }
	public void makeAvailable() { availablity = true; }
	
	public void addAuthor(Author author) { 
		authors.add(author);
	}
	public void addAuthors(List<Author> authorsList) {
		authors.addAll(authors);
	}
	public void addBorrower(Member thisOne) {
		borrowerList.add(thisOne);
	}
	
	@Override public String toString() {
		return "[ Book Title : " + title 
				+ "\t iSBN id : " + iSBN 
				+ " ] ";
	}
}
