package business;

import java.io.Serializable;
import java.util.Objects;

public final class Author implements Serializable{
	private Address address;
	private String firstName;
	private String lastName;
	private String shortBio;
	private String phoneNumber;
	
	public Author(String firstName, String lastName, String phoneNumber, 
						Address thatAddress, String shortBio) {
		
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

	@Override public int hashCode() {
		return Objects.hash(address, firstName, lastName, 
				phoneNumber, shortBio);
	}

	@Override public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(address, other.address) 
				&& Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) 
				&& Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(shortBio, other.shortBio);
	}
}
