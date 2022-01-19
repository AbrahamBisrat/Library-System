package business;

public class Address {
	private String street;
	private String city;
	private String state;
	private int phoneNum; 
	private int zip;
	
	Address(String street, String city, String state, int pNum, int zip){
		this.state = state;
		this.street = street;
		this.phoneNum = pNum;
		this.zip = zip;
	}

	@Override public String toString() {
		return "Address [street=" + street + ", city=" + city 
				+ ", state=" + state + ", phoneNum=" + phoneNum 
				+ ", zip=" + zip + "]";
	}
}
