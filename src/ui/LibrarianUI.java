package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LibrarianUI {
	
	public LibrarianUI() {
		// code
	}
	
	@FXML
	private Button logOutLibrarian;
	
	public void logLibrarianOut() throws IOException {
		Main m = new Main();
		
		m.changeScene("login.fxml");
	}
}
