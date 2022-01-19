package business;

public final class CheckoutEntry {
	private Stuff stuff;
	private Member member;
	private Book book;
	
	CheckoutEntry(Stuff thatStuff, Member thatMember, Book thatBook){
		this.stuff = thatStuff;
		this.book = thatBook;
		this.member = thatMember;
		//System.out.println(getDetails());
		
		addToStuffList();
		addToMemberList();
	}
	
	private void addToMemberList() {
		member.getCheckoutList().add(this);
	}

	private void addToStuffList() {
		stuff.allCheckouts.add(this);
	}

	private String getDetails() {
		return "\t Details for Book : " + book
				+ "\nStuff : " + stuff
				+  "\n Member : " + member 
				+ "\n Book : " + book
				+ "\n";
	}
	
	public Book getBook() {
		return book;
	}
	
	public Stuff getStuff() {
		return stuff;
	}
	
	public Member getMember() {
		return member;
	}
	
	@Override public String toString() {
		return getDetails();
	}
}
