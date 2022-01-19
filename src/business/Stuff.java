package business;

import java.util.ArrayList;
import java.util.List;

public abstract class Stuff {
	protected String firstName;
	protected String lastName;
	protected String role;
	protected boolean dualRole; // Admin + Librarian
	
	
	protected List<CheckoutEntry> allCheckouts;
	
	Stuff(String fName, String lName, String role){
		this.firstName = fName;
		this.lastName = lName;
		this.role = role;
		
		if(!role.equals(Utils.ADMIN))
			allCheckouts = new ArrayList<>();
		
		if(role.equals(Utils.DUAL_ROLE))
			dualRole = true;
	}
	
	public String getDetails() {
		return firstName + " : " + lastName + " : " + role ;
	}
	
	@Override public String toString() {
		return getDetails();
	}
}
