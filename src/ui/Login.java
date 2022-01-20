package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {
	
	public Login() {
		// code
	}
	
	@FXML
	private Button login;
	@FXML
	private Label wrongLogin;
	@FXML
	private TextField userName;
	@FXML
	private PasswordField passwordField;
	
	public void userLogin() throws IOException { // called on button press
		checkLogin();
	}

	private void checkLogin() throws IOException{
		Main m = new Main();
		
		String adminUsername = "a";
		String adminPassword = "a";
		
		String librarianUsername = "s";
		String librarianPassword = "s";
		
		
		// you can use a list and contains method for the real side
		if(userName.getText().toString().equals(adminUsername) 
				&& passwordField.getText().toString().equals(adminPassword)) {
			wrongLogin.setText("Sucess!");
			
			m.changeScene("Admin.fxml");
		}
		else if(userName.getText().toString().equals(librarianUsername) 
				&& passwordField.getText().toString().equals(librarianPassword)) {
			
			wrongLogin.setText("Welcome Librarian");
			
			m.changeScene("Librarian.fxml");
		}
		else {
			userName.setText("");
			passwordField.setText(""); 
			wrongLogin.setText("Wrong credentials!");
		}
	}
	
	
}






