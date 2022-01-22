package business;

import dataaccess.*;

public class Credentials {
	static DataAccess db = new DataAccessFacade();
	
	public static Auth whoIsThisUser(String thatId, String thatPass) {
		User thisUser = db.readUserMap().get(thatId);
		if(thisUser == null)
			return null;
		
		String thisPass = thisUser.getPassword();
		String thisId = thisUser.getId();
		
		if(thisPass.equals(thatPass) && thisId.equals(thatId))
			return thisUser.getAuthorization();
		
		return null;
	}
	public static void main(String[] args) {
		System.out.println(Credentials.whoIsThisUser("1d02", "abc"));
	}
}
