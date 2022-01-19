package business;

public final class Factory {
	public static Librarian createLibrarian(String fName, String lName, String role) {
		return new Librarian(fName, lName, Utils.LIBRARIAN);
	}
	
	/*** >>> ONLY ADMIN CAN CREATE USER  <<<	 ***/
//	public static Member createMember(String fName, String lName, Address address) {
//		return new Member(fName, lName, address);
//	}

	public static Admin createAdmin(String fName, String lName, String role, Address address) {
		return new Admin(fName, lName, role, address);
	}
		// THIS BELONGS TO LIBRARIAN
//	public static Author createAuthor(String fName, String lName, String creds, String shortBio) {
//		return new Author(fName, lName, creds, shortBio);
//	}

	public static Address createAddress(String address) {
		return new Address(address);
	}
	
// 			THIS BELONGS TO LIBRARIAN
//	public static CheckoutEntry createCheckoutEntry(Stuff stuff, Member member, Book book) {
//		return new CheckoutEntry(stuff, member, book);
//	}
		// THIS BELONGS TO LIBRARIAN
//	public static Book createBook(String title, int iSBN) {
//		return new Book(title, iSBN);
//	}
			// BELONGS TO LIBRARIAN OR DUAL _ROLE
//	public static CheckoutRecord createCheckoutRecord() {
//		return new CheckoutRecord();
//	}
}
