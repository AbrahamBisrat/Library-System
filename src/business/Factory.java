package business;

public final class Factory {
	public static Librarian createLibrarian(String fName, String lName, String role) {
		return new Librarian(fName, lName, role);
	}
	public static Member createMember(String fName, String lName, Address address) {
		return new Member(fName, lName, address);
	}
	public static Admin createAdmin(String fName, String lName, String role) {
		return new Admin(fName, lName, role);
	}
	public static Author createAuthor(String firstName, String lastName, String credentials, String shortBio) {
		return new Author(firstName, lastName, credentials, shortBio);
	}
	public static Address createAddress(String address) {
		return new Address(address);
	}
	public static CheckoutEntry createCheckoutEntry(Stuff stuff, Member member, Book book) {
		return new CheckoutEntry(stuff, member, book);
	}
	public static Book createBook(String title, int iSBN) {
		return new Book(title, iSBN);
	}
	public static CheckoutRecord createCheckoutRecord() {
		return new CheckoutRecord();
	}
}
