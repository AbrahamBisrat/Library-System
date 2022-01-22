package ui;
import java.io.IOException;

import business.Address;


import business.Address;
import business.Author;
import business.Book;
import business.Librarian;
import business.LibraryMember;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LibraryMemberUI {
	SaveForAdmin admin = new SaveForAdmin();
	@FXML
	public Label lblMessage ;
	
	@FXML
	public Button btnAddMember;
	@FXML
	public Button btnClearDetails;
	
	
	@FXML
	private Button btnCancel;
	
	
	
	@FXML
	public TextField txtPhoneNo;
	@FXML
	public TextField txtEmail;
	
	@FXML
	public TextField txtFirstName;
	@FXML
	public TextField txtLastName;
	@FXML
	public TextField txtZip;
	@FXML
	public TextField txtStreet;
	@FXML
	public TextField txtCity;
	@FXML
	public TextField txtState;
	
	@FXML
	public TextField txtMemberID;
	
	public void ClearAll()
	{
		clearnames();
		addressclear();
		
	}
	
	public void saveNewMember()
	{
		
		if (checkDetails())
		{
			//String memId, String fName, String lName, String phoneNum, Address thatAddress
			
			LibraryMember member = new LibraryMember(txtMemberID.getText(),txtFirstName.getText(),txtLastName.toString(),txtPhoneNo.toString(),getAddress());
			// modify to pass member only
			admin.Save().addMember(txtMemberID.getText(),txtFirstName.getText(),txtLastName.toString(),txtPhoneNo.toString(),getAddress());
			lblMessage.setText("Library Member has been added successfully.");
			ClearAll();
		}
	}
	public Address getAddress()
	{
		return new Address(txtStreet.getText(),txtCity.getText(),txtState.getText(),txtZip.getText());
		
	}
	public boolean checkDetails()
	{
		lblMessage.setText("");
		if (txtMemberID.getText()=="")
		{
		
			lblMessage.setText("Enter the member's ID");
			return false;
		}
		if (txtFirstName.getText() =="") {
			
			lblMessage.setText("Enter first Name of member");
			return false;
		}
		if (txtLastName.getText()=="")
		{
			lblMessage.setText("Enter the last name");
			return false;
		}
	
		if (txtPhoneNo.getText()=="")
		{
			lblMessage.setText("enter phone number");
			return false;
		}
		if (txtZip.getText()=="") {
			lblMessage.setText("You have to enter the ZIP code");
			return false;	
		}
		if (txtState.getText()=="")
		{
			lblMessage.setText("Indicate the state");
			return false;
		}
		if (txtCity.getText()=="")
		{
			lblMessage.setText("You have to enter the city name");
			return false;
		}
		if (txtStreet.getText()=="") {
			lblMessage.setText("Street field can not be left blank");
			return false;
		}
		return true;
	}
	public void goToLogin() throws IOException {
		Main m = new Main();
		m.changeScene("Admin.fxml");
	}
	
	public void addressclear()
	{
		txtZip.clear();
		txtStreet.clear();
		txtState.clear();
		txtCity.clear();
	}
	
	public void clearnames()
	{
		txtFirstName.clear();
		txtLastName.clear();
		txtEmail.clear();
		txtPhoneNo.clear();
	}

}
