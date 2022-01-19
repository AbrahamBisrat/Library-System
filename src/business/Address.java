package business;

public class Address {
	private String address;
	
	Address(String address){
		this.address = address;
	}
	
	public String getAddress() { return address; }
	
	@Override public String toString() {
		return getAddress();
	}
}
