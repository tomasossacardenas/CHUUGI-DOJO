package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.Pane;
import model.Dojo;

public class DojoGUI {
	
	//Relations
	Dojo dojo;
	
	public DojoGUI(Dojo dojo) {
		this.dojo=dojo;
	}

// Method to create a dialog window
	public Dialog<String> createDialog() {
		Dialog<String> dialog = new Dialog<String>();
		ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(type);
		return dialog;
	}

//Login fxml
    @FXML
    private Pane mainPaneLogin;

    @FXML
    private TextField txtLoginUsername;

    @FXML
    private PasswordField txtLoginPassword;
    
// OptionsWindow fxml

    @FXML
    private Pane OptionsWindow;

    @FXML
    private Pane PaneOptionsWindow;

    @FXML
    void openLoginScreen(ActionEvent event) throws IOException {
		FXMLLoader login = new FXMLLoader(getClass().getResource("Login.fxml"));
		login.setController(this);
		Parent rootLogin = login.load();
		OptionsWindow.getChildren().setAll(rootLogin);
    }

    @FXML
    void buttonSignIn(ActionEvent event) throws IOException {
    	String dojoUserUsername= dojo.getUsuario().getUsername();
    	String dojoUserPassword= dojo.getUsuario().getPassword();

    	if(!txtLoginUsername.getText().equals("") && !txtLoginPassword.getText().equals("")) {

    		if(txtLoginUsername.getText().equals(dojoUserUsername) && txtLoginPassword.getText().equals(dojoUserPassword)) {
				FXMLLoader optionsFxml = new FXMLLoader(getClass().getResource("OptionsWindow.fxml"));
				optionsFxml.setController(this);
				Parent opWindow = optionsFxml.load();
				mainPaneLogin.getChildren().setAll(opWindow);
    		}
    		
    		else {
    			Dialog<String> dialog = createDialog();
    			dialog.setTitle("Error, datos incorrectos");
    			dialog.setContentText("El nombre de usuario o contraseña son incorrectos");
    			dialog.show();
    		}
    	}
    	else {
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error al guardar datos");
    		dialog.setContentText("Todos los campos son requeridos");
    		dialog.show();
    	}

    }

}
