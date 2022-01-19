package business;

public final class Admin extends Stuff{
	
	Admin(String fName, String lName, String role){
		super(fName, lName, role);
	}
	
	@Override public String getDetails() {
		return "From Admin object : " + super.getDetails();
	}
	
	@Override public String toString() {
		return getDetails();
	}
}
