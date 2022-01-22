package ui;

import business.Admin;
import dataaccess.Auth;

public class SaveForAdmin {
	Admin admin = new Admin(" >>> Mr.", "XYZ", Auth.ADMIN, "admin", "admin");
	public Admin Save()
	{
		return admin;
	}

}
