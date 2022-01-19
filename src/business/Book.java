package business;

public class Book {
	private String name;
	
	// package level
	Book(String thatName){
		this.name = thatName;
	}
	
	public String getName() { return name; }
	
	@Override public String toString() {
		return name;
	}
}
