package business;

public final class Factory {
	public static Librarian createLibrarian(String fName, 
			String lName, String role) {
		return new Librarian(fName, lName, Utils.LIBRARIAN);
	}
	
	public static Admin createAdmin(String fName, String lName, 
			String role) {
		return new Admin(fName, lName, role);
	}
	
	public static Author createAuthor(String fName, String lName, 
			String creds, String shortBio, Address address) {
		return new Author(fName, lName, creds, shortBio, address);
	}

	public static Address createAddress(String street, String city, 
			String state, int phoneNumber, int zipCode) {
		return new Address(street, city, state, phoneNumber, zipCode);
	}
	
	public static Book createBook(String title, int iSBN) {
		return new Book(title, iSBN);
	}
}
