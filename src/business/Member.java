package business;

public class Member {
	private String name;
	
	// package level
	Member(String thatName){
		this.name = thatName;
	}
	
	public String getName() { return name; }
	
	@Override public String toString() {
		return name;
	}
}
