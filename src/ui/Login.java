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
		
		String passwordString = "asdf";
		String usernameString = "abcd";
		
		if(userName.getText().toString().equals(usernameString) 
				&& passwordField.getText().toString().equals(passwordString)) {
			wrongLogin.setText("Sucess!");
			
			m.changeScene("afterLogin.fxml");
		}
		else {
			userName.setText("");
			passwordField.setText(""); 
			wrongLogin.setText("Wrong credentials!");
		}
	}
	
	
}






