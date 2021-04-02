package ui;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;

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

// CreateStudent fxml
    
    @FXML
    private Pane PaneCreateStudent;

    @FXML
    private TextField txtCreateStudentName;

    @FXML
    private TextField txtCreateStudentSurnames;

    @FXML
    private TextField txtCreateStudentId;

    @FXML
    private TextField txtCreateStudentPhoneContact;

    @FXML
    private TextField txtCreateStudentPayersName;

    @FXML
    private TextField txtCreateStudentEmail;

    @FXML
    void openLoginScreen(ActionEvent event) throws IOException {
		FXMLLoader login = new FXMLLoader(getClass().getResource("Login.fxml"));
		login.setController(this);
		Parent rootLogin = login.load();
		OptionsWindow.getChildren().setAll(rootLogin);
    }
    
    @FXML
    void openCreateStudent(ActionEvent event) throws IOException {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("CreateStudent.fxml"));
		fxml.setController(this);
		Parent root= fxml.load();
		PaneOptionsWindow.getChildren().setAll(root);
    }
    
    @FXML
    void openDeleteStudent(ActionEvent event) throws IOException {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("DeleteStudent.fxml"));
		fxml.setController(this);
		Parent root= fxml.load();
		PaneOptionsWindow.getChildren().setAll(root);
    }

    @FXML
    public void buttonSignIn(ActionEvent event) throws IOException {
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
    
    @FXML
    void generatePDF(ActionEvent event) throws FileNotFoundException {//method of the button createStudent its TEMPORAL
    	FileOutputStream archivo= new FileOutputStream("C:\\Users\\tomas\\eclipse-workspace\\jfx-ChuugiDojo\\Reportes\\"+txtCreateStudentId.getText()+".pdf");
    	
    	Document document= new Document();  
    	
    	try {//
			PdfWriter.getInstance(document, archivo);
			document.open();
			addMetaData(document);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
    	document.close();
    	
    	
    }
    
    private static void addMetaData(Document document) throws DocumentException {
    	Image foto=null;
   
        try
        {
        	foto = Image.getInstance("C:\\Users\\tomas\\eclipse-workspace\\jfx-ChuugiDojo\\src\\icons\\CHUUGI JKA.jpg");
        	foto.scaleToFit(200, 200);
        	foto.setAlignment(Chunk.ALIGN_CENTER);
        }
        catch ( Exception e )
        {
        	e.printStackTrace();
        }
        
        Paragraph p = new Paragraph("EDIFICIO LOS GUADUALES\n"
        							+ "NIT:67007645-6\n"
        							+ "LUZ EDITH ORTIZ C. \n"
        							+ "info@chuugidojo.com \n"
        							+ "Celular:(310 650 7454)-(313 559 2722) \n\n");
        p.setFont(FontFactory.getFont("Tahoma", 18));
        
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell(p.getContent(), PdfPCell.ALIGN_LEFT));
        table.addCell(getCell(foto, PdfPCell.ALIGN_RIGHT));
        document.add(table);
        
        document.add(new Paragraph(""));
        document.add(new Paragraph(""));
        document.add(new Paragraph(""));
        document.add(new Paragraph(""));
        document.add(new Paragraph(""));
        
        Paragraph parrafoPago = new Paragraph();
        parrafoPago.add("FECHA: \n"+
        				"RECIBÍ DE: \n"+
        				"LA SUMA DE: \n");
        parrafoPago.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD));
        
        Paragraph parrafoPagoR = new Paragraph();
        parrafoPagoR.add("fecha Actual\n"+
        				"Persona quien paga\n"+
        				"Total que pagó \n");
        parrafoPagoR.setFont(FontFactory.getFont("Tahoma", 18));
        
        PdfPTable tablePago = new PdfPTable(2);
        tablePago.setWidthPercentage(100);
        tablePago.addCell(getCell(parrafoPago.getContent(), PdfPCell.ALIGN_RIGHT));
        tablePago.addCell(getCell(parrafoPagoR.getContent(), PdfPCell.ALIGN_LEFT));
        document.add(tablePago);
        
        
        
        
    }
    public static PdfPCell getCell(String text, int alignment) {//configuracion de la celda del texto (izquierda)
        PdfPCell cell = new PdfPCell(new Phrase(text));
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }
    public static PdfPCell getCell(Image img, int alignment) {//configuracion de la celda de la imagen (derecha)
        PdfPCell cell = new PdfPCell();
        cell.addElement(img);
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }

}
