package business;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable{
	private static final long serialVersionUID = 1L;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public Address(String street, String city, String state, String zip){
		this.state = state;
		this.street = street;
		this.zip = zip;
	}

	@Override public String toString() {
		return "Address [street=" + street + ", city=" + city 
				+ ", state=" + state
				+ ", zip=" + zip + "]";
	}

	@Override public int hashCode() {
		return Objects.hash(city, state, street, zip);
	}

	@Override public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(state, other.state)
				&& Objects.equals(street, other.street) && Objects.equals(zip, other.zip);
	}
	
}
