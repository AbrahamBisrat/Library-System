package business;

public final class Author {
	private Address address;
	private String firstName;
	private String lastName;
	private String shortBio;
	private String phoneNumber;
	
	public Author(String firstName, String lastName, String phoneNumber, Address thatAddress, 
			String shortBio) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.shortBio = shortBio;
		this.address = thatAddress;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	@Override public String toString() {
		return getName();
	}
}
