package business;

public class Address {
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
}
