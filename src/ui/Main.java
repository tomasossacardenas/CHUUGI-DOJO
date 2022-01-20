package ui;

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Dojo;

public class Main extends Application {
	
	//Relations
	Dojo dojo;
	DojoGUI chuugiDojo;
	
	public Main() {
		dojo = new Dojo("Calle 68 No. 4AN - 87 esquina Barrio Calima", "67007645-6.", "LUZ EDITH ORTIZ C", "info@chuugidojo.com", "(310 650 7454)-(313 559 2722).", "tomasossaefcsl@gmail.com", "Tomas123*", "C:\\Users\\tomas\\eclipse-workspace\\jfx-ChuugiDojo\\data", "C:\\Users\\tomas\\eclipse-workspace\\jfx-ChuugiDojo\\Reportes", "C:\\Users\\USER\\Nextcloud\\L-Ortiz\\App Chuugi Dojo");
		chuugiDojo=new DojoGUI(dojo );

		try {
			chuugiDojo.loadDojoData();	
		}catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Dojo Data");
    		alert.setContentText("Error al cargar los datos del dojo");
			alert.showAndWait();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login2.fxml"));
		fxmlLoader.setController(chuugiDojo);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		Image icon = new Image(getClass().getResource("/icons/escudo.png").toExternalForm(), false);  
		primaryStage.getIcons().add(icon);
		primaryStage.setTitle("Chuugi Dojo");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

}
