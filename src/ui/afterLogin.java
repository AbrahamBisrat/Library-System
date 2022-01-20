package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class afterLogin {
	
	public afterLogin() {
		// code
	}
	
	@FXML
	private Button logout;
	
	public void logoutSession() throws IOException {
		checkoutUser();
	}

	private void checkoutUser() throws IOException {
		Main m = new Main();
		
		m.changeScene("login.fxml");
	}
}
