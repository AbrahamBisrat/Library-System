package dataaccess;

import java.util.HashMap;
import java.util.List;

import business.*;

public interface DataAccess { 
	public HashMap<String, Book> readBooksMap();
	public HashMap<String, User> readUserMap();
	public HashMap<String, LibraryMember> readMemberMap();
	public void saveNewMember(LibraryMember member);
	public LibraryMember removeMember(String memId);
	public void addMember(String memId, String fName, String lName, 
								String phoneNum, Address address);

	public void addNewBook(String iSBN, String thatTitle, 
			int numberOfCopies, List<Author> authorList, int maxDate);
	public void removeBook(String iSBN);
	public void updateBook(Book b);
	public void updateMember(LibraryMember m);
	public void addLibrarian(String libId, String username);
}
