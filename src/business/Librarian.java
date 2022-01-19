package business;

public final class Librarian extends Stuff{
	Roles role = Roles.LIBRARIAN;
	
	Librarian(String fName, String lName, String role) {
		super(fName, lName, Utils.LIBRARIAN);
	}
	
	@Override public String getDetails() { 
		return "From Library Object : " + super.getDetails();  
	}
	
	@Override public String toString() {
		return getDetails();
	}
}
