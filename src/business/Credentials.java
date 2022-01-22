package business;

import dataaccess.*;

public class Credentials {
	DataAccess db = new DataAccessFacade();
	
	public Auth whoIsThisUser(String thatId, String thatPass) {
		User thisUser = db.readUserMap().get(thatId);
		
		String thisPass = thisUser.getPassword();
		String thisId = thisUser.getId();
		
		if(thisPass.equals(thatPass) && thisId.equals(thatId))
			return thisUser.getAuthorization();
		
		return null;
	}
	public static void main(String[] args) {
		Credentials c = new Credentials();
		
		System.out.println(c.whoIsThisUser("102", "abc"));
	}
}
