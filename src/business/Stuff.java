package business;

import java.util.ArrayList;
import java.util.List;

import dataaccess.Auth;

public abstract class Stuff {
	protected String firstName;
	protected String lastName;
	protected Auth role;
	protected boolean dualRole; // Admin + Librarian
	
	
	protected List<CheckoutEntry> allCheckouts;
	
	Stuff(String fName, String lName, Auth role){
		this.firstName = fName;
		this.lastName = lName;
		this.role = role;
		
		if(role.equals(Auth.ADMIN))
			allCheckouts = new ArrayList<>();
		
		if(role.equals(Auth.BOTH))
			dualRole = true;
	}
	
	public String getDetails() {
		return firstName + " : " + lastName + " : " + role ;
	}
	
	@Override public String toString() {
		return getDetails();
	}
}
