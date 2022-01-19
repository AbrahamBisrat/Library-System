package business;

public final class Librarian extends Stuff{
	
	
	Librarian(String fName, String lName, String role) {
		super(fName, lName, role);
	}
	
	@Override public String getDetails() { 
		return "From Library Object : " + super.getDetails();  
	}
	
	@Override public String toString() {
		return getDetails();
	}
}
