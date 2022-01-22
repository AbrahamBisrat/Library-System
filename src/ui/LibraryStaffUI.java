package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import business.Librarian;
import business.Roles;
import business.Stuff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class LibraryStaffUI implements Initializable {
	@FXML
	TextField txtFirstName;
	@FXML
	TextField txtLastName;
	@FXML
	ComboBox cmbRole;
	@FXML
	Button btnClear;
	@FXML
	Button btnSaveStaff;
	
	@FXML
	Button btnCancel;
	
	@FXML
	Label lblMessage;
	
	@FXML
	Label lblMessage2;
	
	@FXML
	Button btnGoToPanel;
	SaveForAdmin adminsaver = new SaveForAdmin();
	
	ObservableList<String> roles = FXCollections.observableArrayList("Librarian");
	
	
	//@override
	//public void initialize() {
		
	//}
	
	
	public void AddNewStaff()
	{
		lblMessage2.setText("");
		SaveForAdmin admin = new SaveForAdmin();
		Librarian l;
	
		if (txtFirstName.getText()=="" || txtLastName.getText()=="")
		{
			lblMessage2.setText("Enter correct with names. Blank name are not allowed");
			return;
		}
		admin.Save().addLibrarian(txtFirstName.getText(),txtLastName.getText(), txtFirstName.getText(),txtLastName.getText());
		lblMessage2.setText("new librarian has been created with firstname and surname as username and password respectively");
		clearData();
		
	}
	
	public void clearData()
	{
		txtFirstName.clear();
		txtLastName.clear();
	
	}
	
	public void goToLogin() throws IOException {
		Main m = new Main();
		m.changeScene("Admin.fxml");
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		cmbRole.setItems(roles);
		
	}
}
