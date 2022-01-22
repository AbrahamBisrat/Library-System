package ui;

import java.io.IOException;

import business.*;
import dataaccess.*;
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

	public void userLogin() throws IOException {
		checkLogin();
	}

	private void checkLogin() throws IOException {
		Main m = new Main();

		String username = userName.getText();
		String password = passwordField.getText();

		Auth role = Credentials.whoIsThisUser(username, password);

		if (role.equals(Auth.ADMIN)) {
			m.changeScene("Admin.fxml");
			LoggedIn.roles = 1;
		}
		else if (role.equals(Auth.LIBRARIAN)) {
			m.changeScene("LibrarianTasks.fxml", 700, 1000);
			LoggedIn.roles = 2;
		}
		else if (role.equals(Auth.BOTH)) {
			m.changeScene("Admin.fxml");
			LoggedIn.roles = 3;
		}
		else {
			wrongLogin.setText("Incorrect username / password, try again.");
		}
	}
}
