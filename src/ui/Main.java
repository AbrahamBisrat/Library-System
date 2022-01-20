package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{
	
	private static Stage usableStage;
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override public void start(Stage primaryStage) throws Exception {
		usableStage = primaryStage;
		primaryStage.setResizable(false);
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		primaryStage.setTitle("Library System");
		primaryStage.setScene(new Scene(root, 600, 400));
		primaryStage.show();
	}

	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		usableStage.getScene().setRoot(pane);
	}
}