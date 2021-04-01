package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Dojo;

public class Main extends Application {
	
	//Relations
	Dojo dojo;
	DojoGUI chuugiDojo;
	
	public Main() {
		dojo = new Dojo();
		chuugiDojo=new DojoGUI(dojo);
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
		fxmlLoader.setController(chuugiDojo);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Chuugi Dojo");
		primaryStage.show();
	}

}
