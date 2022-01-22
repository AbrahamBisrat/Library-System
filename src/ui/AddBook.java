package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import business.Address;
import business.Author;
import business.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddBook implements Initializable {
	
	@FXML
	public Label lblMessage = new Label();
	
	@FXML
	public Button btnAddBook;
	@FXML
	public Button btnClearBook;
	
	@FXML
	public Button btnClearAuthor;
	@FXML
	private Button btnCancel;
	
	@FXML
	private Button btnAddAuthor;
	
	@FXML
	Label lblAuthors;
	
	@FXML
	public TextField txtDuration;
	@FXML
	public TextField txtTitle;
	@FXML
	public TextField txtISBN;
	@FXML
	private TextField txtCopies;
	
	@FXML
	private TextArea txtAuthors;
	
	@FXML
	public TextField txtPhoneNo;
	@FXML
	public TextField txtEmail;
	@FXML
	public TextField txtBio;
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
	List<Author> authorList = new ArrayList <Author>();
	public AddBook()
	{
		
		
	}
	
	public void clearBook(ActionEvent event)
	{
		authorsclear();
		
		
	}
	public void clearAuthor(ActionEvent event)
	{
		addressclear();
		clearnames();
		
	}
	public void addAuthor(ActionEvent event)
	{
		Author author;
		if (txtFirstName.getText() =="") {
			
			return;
		}
		if (txtLastName.getText()=="")
		{
			return;
		}
		if (txtBio.getText()=="")
		{
			return;
		}
		if (txtPhoneNo.getText()=="")
		{
			
			return;
		}
		
		if (checkAddress() != null)
		{
			//String firstName, String lastName, String phoneNumber, 
			//Address thatAddress, String shortBio
			author = new Author(txtFirstName.getText(),txtLastName.getText(),txtPhoneNo.getText(),checkAddress(),txtBio.getText());
			authorList.add(author);
			clearnames();
			getAllAuthors();
			
		}
		//lblMessage.setText("trying to add author");
		//txtZip.setText("98449");
		
	}
	public Address checkAddress()
	{
		if (txtZip.getText()=="") {
			return null;	
		}
		if (txtState.getText()=="")
		{
			return null;
		}
		if (txtCity.getText()=="")
		{
			return null;
		}
		if (txtStreet.getText()=="") {
			return null;
		}
		//String street, String city, String state, String zip
		
		return new Address(txtStreet.getText(),txtCity.getText(),txtState.getText(),txtZip.getText());
	}
	public void AddBookDetails(ActionEvent event)
	{
		
		if (txtTitle.getText()=="") {
			return;
		}
		if (txtISBN.getText()=="")
		{
			return;
		}
		if (txtCopies.getText()=="" || txtCopies.getText()=="0")
		{
			return;
		}
		if (authorList.size()==0)
		{
			lblMessage.setText("You have to add authors to the book");
			return;
		}
		int dur = Integer.parseInt(txtDuration.getText());
	    //String iSBN, String thatTitle, int numberOfCopies, List<Author> authorList
	    Book b = new Book(txtISBN.getText(),txtTitle.getText(),Integer.parseInt(txtCopies.getText()),authorList,dur);
	    SaveForAdmin admin = new SaveForAdmin();
	    admin.Save().addBook(txtISBN.getText(),txtTitle.getText(),Integer.parseInt(txtCopies.getText()),authorList,dur);
	    authorList.clear();
	    addressclear();
	    getAllAuthors();
	    lblMessage.setText("New Book Added: "+ b.toString());
	    clearAll();
		
		
	
		
	}
	private void getAllAuthors()
	{
		for (int x=0;x<=authorList.size()-1;x++)
		{
			lblAuthors.setText(lblAuthors.getText() + " " + authorList.get(x).getName() + "; "  );
		}
	}
	public void goToLogin() throws IOException {
		Main m = new Main();
		m.changeScene("Admin.fxml");
	}
	public boolean check(ActionEvent event)
	{
		return false;
		
		
	}
	public void clearAll()
	{
		authorsclear();
		addressclear();
		clearnames();
		
	}
	public void authorsclear()
	{
		txtTitle.clear();
		txtISBN.clear();
		txtCopies.clear();
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		lblAuthors.setText("");
		txtDuration.setText("21");
		
	}
	

}
