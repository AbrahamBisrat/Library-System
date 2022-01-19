package business;

public abstract class Stuff {
	protected String firstName;
	protected String lastName;
	protected String role;
	
	Stuff(String fName, String lName, String role){
		this.firstName = fName;
		this.lastName = lName;
		this.role = role;
	}
	
	public String getDetails() {
		return firstName + " : " + lastName + " : " + role ;
	}
	
	@Override public String toString() {
		return getDetails();
	}
}
