package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminUI {
	
	public AdminUI() {
		// code
	}
	
	@FXML
	private Button logAdminOut;
	
	public void adminLogout() throws IOException {
		Main m = new Main();
		m.changeScene("login.fxml");
	}
	
	public void goToAddBook() {
		// nothing yet
	}
	
	public void goToAddLibraryMember() {
		// nothing yet
	}
	
	public void goToAddLibraryStaff() {
		// nothing yet
	}
	
	public void goToAddLibrarianRoles() {
		// nothing yet
	}
}
