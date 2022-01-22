package ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	private static Stage usableStage;
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override public void start(Stage primaryStage) throws Exception {
		usableStage = primaryStage;
		primaryStage.setResizable(true);
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		primaryStage.setTitle("Library System");
		primaryStage.setScene(new Scene(root, 800,  400));
		primaryStage.show();
	}

	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		usableStage.getScene().setRoot(pane);
	}
	public void changeScene(String fxml, int x, int y) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		usableStage.setWidth(y);
		usableStage.setHeight(x);
		usableStage.getScene().setRoot(pane);
	}
}