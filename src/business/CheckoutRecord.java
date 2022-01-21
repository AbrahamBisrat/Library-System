package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CheckoutRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	List<CheckoutEntry> checkouts;
	LibraryMember member;
	
	CheckoutRecord(List<CheckoutEntry> thatCheckouts, LibraryMember thatMember) {
		checkouts = thatCheckouts;
		member = thatMember;
	}
	
	public LibraryMember getMember() {
		return member;
	}
	
	@Override public String toString() {
		return "CheckoutRecord [thisRecord=" + checkouts + ", member=" + member + "]";
	}

	@Override public int hashCode() {
		return Objects.hash(member, checkouts);
	}

	@Override public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckoutRecord other = (CheckoutRecord) obj;
		return Objects.equals(member, other.member) && Objects.equals(checkouts, other.checkouts);
	}
	
}
