package ui;

import java.io.IOException;

import business.Credentials;
import dataaccess.Auth;
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
		
		String username = userName.getText();
		String password = passwordField.getText();
				
		Auth role = 
			Credentials.whoIsThisUser(username, password);
		
		
		// you can use a list and contains method for the real side
		if(role.equals(Auth.ADMIN)) {
			wrongLogin.setText("Sucess!");
			
			m.changeScene("Admin.fxml");
		}
		else if(role.equals(Auth.LIBRARIAN)) {
			
			wrongLogin.setText("Welcome Librarian");
			
			m.changeScene("Librarian.fxml");
		}
		else if(role.equals(Auth.BOTH)) {
			System.out.println("That has not been implemented yet");
		}
		else {
			userName.setText("");
			passwordField.setText(""); 
			wrongLogin.setText("Wrong credentials!");
		}
	}
	
	
}






