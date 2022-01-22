package ui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import business.*;
import dataaccess.Auth;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LibrarianTasksUI implements Initializable{
	
	@FXML private TextField txtFirstname;
    @FXML private TextField txtLastname;
    @FXML private TextField txtEmail;
  
    
    @FXML TabPane librianActions;
	@FXML TextField txtISBN;
	@FXML TextField txtMemberID;
	
	@FXML TextArea txtMemberDetails;
	@FXML TextArea txtBookDetails;
	@FXML TextArea txtCheckoutSummary;
	@FXML TextArea txtCheckinSummary;
	
	@FXML Label lblMessage;
	
	@FXML Button btnCheckoutBook;
	@FXML Button btnAdminRoles;
	@FXML Button btnLogout;
	@FXML Button btnCheckinBook;
	@FXML Button btnClear;
	
	
	@FXML TableView<CheckoutEntry> history_table;
	@FXML TableColumn<CheckoutEntry, String> col_ac;
	@FXML TableColumn<CheckoutEntry, LocalDate> col_checkoutDate;
	@FXML TableColumn<CheckoutEntry, LocalDate> col_checkinDate;
	@FXML TableColumn<CheckoutEntry, String> col_bookTitle;
	@FXML TableColumn<CheckoutEntry, String> col_iSBN;
	@FXML TableColumn<CheckoutEntry, String> col_memberId;
	@FXML TableColumn<CheckoutEntry, String> col_memberName;
	@FXML TableColumn<CheckoutEntry, Boolean> col_returned;
	
	public Librarian l;
	
	Admin admin = new Admin(" >>> Mr.", "XYZ", Auth.ADMIN, "admin", "admin");

	
	public ObservableList<CheckoutEntry> getCheckoutEntry(){
		ObservableList<CheckoutEntry> checkoutEntries = FXCollections.observableArrayList();
		HashMap<String, Book> allBooks = admin.getAllBooks();
		
		for(Book b : allBooks.values())
			for(CheckoutEntry c : b.getCheckoutList())
				checkoutEntries.add(c);
		
		System.out.println("\n\n\n checkoutEntries" + checkoutEntries);
		
		return checkoutEntries;
	}
	
	
	@Override public void initialize(URL arg0, ResourceBundle arg1) {
		
		l = new Librarian("lib", "lib","Lib");
		//txtBookDetails.setText("No Book Selected");
		System.out.println(l.getAllMembers());
		System.out.println("\n Books");
		System.out.println(admin.showBooks().toString());
		
		if (LoggedIn.roles!=3)
		{
			btnAdminRoles.setVisible(false);
		}
		else 
		{
			btnAdminRoles.setVisible(true);
		}
		
		txtBookDetails.setEditable(false);
		txtMemberDetails.setEditable(false);
		txtCheckoutSummary.setEditable(false);

		// history table view
//		col_ac.setCellValueFactory(new PropertyValueFactory<>("currentlyAvailableBooks"));
		col_checkoutDate.setCellValueFactory(new PropertyValueFactory<>("checkoutDate"));
		col_checkinDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
		col_bookTitle.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
		col_iSBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
		col_memberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
		col_memberName.setCellValueFactory(new PropertyValueFactory<>("memberName"));
		col_returned.setCellValueFactory(new PropertyValueFactory<>("returned"));
		
		history_table.setItems(getCheckoutEntry());
		
		history_table.getColumns().addAll(
				col_checkoutDate,
				col_checkinDate,
				col_bookTitle,
				col_iSBN,
				col_memberId,
				col_memberName,
				col_returned
				);
	}

	
	
	public void Clear(ActionEvent action)
	{
		System.out.println("search tested");
		ClearAll();
	}
	
	private boolean verifyCheckOut()
	{
		lblMessage.setText("");
		LibraryMember m = l.getMemberWithId(txtMemberID.getText());
		Book book = l.getBookWithISBN(txtISBN.getText());
		if (m==null || book==null)
		{
			lblMessage.setText("verify the book ISBN and Member ID. check out could not be completed");
			return false;
		}
		if (txtCheckoutSummary.getText().length()==0)
		{
		
			lblMessage.setText("verify the book ISBN and Member ID. check out could not be completed");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	private boolean verifyCheckIn()
	{
		lblMessage.setText("");
		LibraryMember m = l.getMemberWithId(txtMemberID.getText());
		Book book = l.getBookWithISBN(txtISBN.getText());
		if (m==null || book==null)
		{
			lblMessage.setText("verify the book ISBN and Member ID. checkIn could not be completed");
			return false;
		}
		if (txtCheckoutSummary.getText().length()==0)
		{
		
			lblMessage.setText("verify the book ISBN and Member ID. checkIn could not be completed");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public void BookCheckOut(ActionEvent action)
	{
		lblMessage.setText("");
		if (verifyCheckOut())
		{
			
			l.checkout(txtISBN.getText(),txtMemberID.getText());
			lblMessage.setText("Check out successful. ");
			System.out.println(l.getAllMembers());
			System.out.println("\n Books");
			System.out.println(admin.showBooks().toString());
			history_table.setItems(getCheckoutEntry());
		}
		else
		{
			
			lblMessage.setText("Can not check out. Select valid Book and member to continue");
		}
		
	}
	
	public void BookCheckIn(ActionEvent action)
	{
		lblMessage.setText("");
		if (verifyCheckOut()) {
			l.returnBook(txtISBN.getText());
			lblMessage.setText("CheckIn successful. ");
			System.out.println(l.getAllMembers());
			System.out.println("\n Books");
			System.out.println(admin.showBooks().toString());
			history_table.setItems(getCheckoutEntry());
		}
		else {
			lblMessage.setText("Can not checkIn. Select valid Book and member to continue");
		}			
	}
	

	public void goToLogin() throws IOException {
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
	
	public void goToAddAdminRoles() throws IOException {
		Main m = new Main();
		m.changeScene("Admin.fxml");
	}
	
	public void SearchBook(ActionEvent action)
	{
		lblMessage.setText("");
		if (txtISBN.getText().length()< 7)
		{
			lblMessage.setText("Entered ISBN not valid");
			return;
		}
		Book book = l.getBookWithISBN(txtISBN.getText());
		if (book==null)
		{
			txtBookDetails.clear();
			lblMessage.setText("Book not found");
			return;
		}
		else
		{
			txtBookDetails.setText("ISBN: "+  book.getISBN() + " \n Title: "+ book.getTitle() + "\n No of Copies: "+ book.getCopies() + "Authors: ");
			StringBuilder bd = new StringBuilder();
			for (int x=0;x<=book.getAuthors().size()-1;x++)
			{
				bd.append(book.getAuthors().get(x).getName() + "; ");
			}
			txtBookDetails.setText(txtBookDetails.getText() + bd.toString());
			lblMessage.setText("Book Found");
		}
		//lblMessage.setText("You have tried to search for a book");
		//System.out.println("search tested");
		createSummary();
	}
	
	public void SearchMember(ActionEvent action)
	{
		lblMessage.setText("");
		//System.out.println("search tested");
		
		if (txtISBN.getText().length()< 7)
		{
			lblMessage.setText("Entered ISBN not valid");
			return;
		}
	    LibraryMember m = l.getMemberWithId(txtMemberID.getText());
		if (m==null)
		{
			lblMessage.setText("Member not found");
			txtMemberDetails.clear();
			return;
		}
		else
		{
			txtMemberDetails.setText("Name: " + m.getFullName() + "\n ID Number:" + m.getMemberId() + "\n  Check out counts: " + m.getCheckouts().size());
			lblMessage.setText("Member found Found");
		}
		createSummary();
	}
	
	public void createSummary()
	{
		if (txtBookDetails.getText().length()!=0 && txtMemberDetails.getText().length() != 0)
		{
			txtCheckoutSummary.setText("ISSUE: \n "+ txtBookDetails.getText() + "\n\n To Member:\n "+ txtMemberDetails.getText());
			txtCheckinSummary.setText(txtCheckoutSummary.getText());
		}
		else
		{
			txtCheckoutSummary.clear();
			txtCheckinSummary.clear();
		}
	}

	public void ClearAll()
	{
		txtMemberID.clear();
		txtISBN.clear();
		txtMemberDetails.clear();
		txtBookDetails.clear();
		txtCheckinSummary.clear();
		txtCheckoutSummary.clear();
	} 	
}
