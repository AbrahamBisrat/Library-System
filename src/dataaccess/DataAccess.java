package dataaccess;

import java.util.HashMap;
import java.util.List;

import business.*;

public interface DataAccess { 
	public HashMap<String, Book> readBooksMap();
	public HashMap<String, User> readUserMap();
	public HashMap<String, LibraryMember> readMemberMap();
	public void saveNewMember(LibraryMember member);
	public void removeMember(String memId);
	public void addMember(String memId, String fName, String lName, 
								String phoneNum, Address address);
//	void addNewBook(String iSBN, String thatTitle, int numberOfCopies, List<Author> authorList);
//	void addNewBook(String iSBN, String thatTitle, int numberOfCopies, List<Author> authorList);
	public void addNewBook(String iSBN, String thatTitle, int numberOfCopies, List<Author> authorList);
	public void removeBook(String iSBN);
}
