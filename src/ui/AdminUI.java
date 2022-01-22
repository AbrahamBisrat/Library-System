package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminUI implements Initializable {
	@SuppressWarnings("unused")
	private Stage stage;
	private Scene scene;
	private Parent root; 
	public void goToAddBook(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("AddBook.fxml");
		
		
	}
	
	
	
	public AdminUI() {
		// code
	}
	
	@FXML
	private Button logAdminOut;
	
	@FXML
	private Button btnLibRoles;
	
	@FXML
	private Button btnNewMember;
	
	@FXML
	private Button btnNewBook;
	
	@FXML
	private Button btnNewStaff;
	
	public void adminLogout() throws IOException {
		Main m = new Main();
		m.changeScene("login.fxml");
	}
	
	public void goToAddLibraryMember() throws IOException {
		Main m = new Main();
		m.changeScene("LibraryMember.fxml");
	}
	
	public void goToAddLibraryStaff() throws IOException {
		Main m = new Main();
		m.changeScene("LibraryStaff.fxml");
	}
	
	public void goToAddLibrarianRoles() throws IOException {
		Main m = new Main();
			
		m.changeScene("LibrarianTasks.fxml");
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if (LoggedIn.roles==3)
		{
			btnLibRoles.setVisible(true);
		}
		else
		{
			btnLibRoles.setVisible(false);
			
		}
		
	}
	
	
}
