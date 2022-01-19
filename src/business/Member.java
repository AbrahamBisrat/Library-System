package business;

public class Member {
	private String firstName;
	private String lastName;
	
	// package level
	Member(String fName, String lName){
		firstName = fName;
		lastName = lName;
	}
	
	public String getName() { return firstName + " " + lastName; }
	
	@Override public String toString() {
		return getName();
	}
}
