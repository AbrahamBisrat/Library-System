package business;

public final class Author {
	private Address address;
	private String firstName;
	private String lastName;
	private String credentials;
	private String shortBio;

	Author(String firstName, String lastName, String creds, 
			String shortBio, Address thatAddress) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.credentials = creds;
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
