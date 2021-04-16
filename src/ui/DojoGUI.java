package ui;

import java.io.File;
import java.io.FileInputStream;
import javafx.scene.image.Image;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import model.Dojo;
import model.Student;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;

public class DojoGUI {
 //constants
	public final static String SAVE_DOJO_PATH_FILE="C:\\Users\\tomas\\OneDrive\\Escritorio\\ChuugiDojo\\Datos ChuugiDojo";

 //Relations
	Dojo dojo;
	
	public DojoGUI(Dojo dojo) {
		this.dojo=dojo;
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
    
//createStudent fxml

    @FXML
    private Pane PaneCreateStudent;

    @FXML
    private TextField txtStudentName;

    @FXML
    private TextField txtStudentBornPlace;

    @FXML
    private TextField txtStudentId;

    @FXML
    private TextField txtStudentEPS;
    
    @FXML
    private TextField txtStudentRH;
    
    @FXML
    private TextField txtStudentSex;

    @FXML
    private TextField txtStudentOcupation;

    @FXML
    private TextField txtStudentFatherName;

    @FXML
    private TextField txtStudentMotherName;

    @FXML
    private TextField txtStudentFatherPhone;

    @FXML
    private TextField txtStudentMotherPhone;

    @FXML
    private TextField txtStudentFatherEmail;

    @FXML
    private TextField txtStudentMotherEmail;

    @FXML
    private TextField txtStudentAdress;

    @FXML
    private TextField txtStudentNeighborhood;

    @FXML
    private CheckBox tarjetaIdentidad;

    @FXML
    private CheckBox cedula;

    @FXML
    private DatePicker txtStudentBornDate;

    @FXML
    private DatePicker txtStudentRegisterDate;

    @FXML
    private TextField txtStudentMensualidad;

    @FXML
    private CheckBox mensualidad;

    @FXML
    private CheckBox horaEntrenada;

    @FXML
    private CheckBox lunes;

    @FXML
    private CheckBox martes;

    @FXML
    private CheckBox miercoles;

    @FXML
    private CheckBox jueves;

    @FXML
    private CheckBox viernes;
    
    @FXML
    private CheckBox sabado;

    @FXML
    private CheckBox fiveToSix;

    @FXML
    private CheckBox sixToSeven;

    @FXML
    private CheckBox sevenToEight;

    @FXML
    private CheckBox twoToThree;

    @FXML
    private CheckBox si;

    @FXML
    private CheckBox no;

    @FXML
    private TextArea txtStudentObservations;

    @FXML
    private TextArea txtStudentAddedFiles;

    @FXML
    private Label LabelRutaArchivos;

    @FXML
    private Label LabelRutaFoto;
    
    @FXML
    private ImageView profilePicture;
    
    private List<String>filesOfStudent= new ArrayList<>();
   
//UpdateStudent fxml
    @FXML
    private Pane PaneUpdateStudent;

    @FXML
    private ImageView updateProfilePicture;

    @FXML
    private TextField txtUpdateStudentName;

    @FXML
    private TextField txtUpdateStudentBornPlace;

    @FXML
    private TextField txtUpdateStudentId;

    @FXML
    private TextField txtUpdateStudentEPS;

    @FXML
    private TextField txtUpdateStudentOcupation;

    @FXML
    private TextField txtUpdateStudentFatherName;

    @FXML
    private TextField txtUpdateStudentMotherName;

    @FXML
    private TextField txtUpdateStudentFatherPhone;

    @FXML
    private TextField txtUpdateStudentMotherPhone;

    @FXML
    private TextField txtUpdateStudentFatherEmail;

    @FXML
    private TextField txtUpdateStudentMotherEmail;

    @FXML
    private TextField txtUpdateStudentAdress;

    @FXML
    private TextField txtUpdateStudentNeighborhood;

    @FXML
    private TextField txtUpdateStudentMensualidad;
    
    @FXML
    private TextField txtDiferenciablePdf;

    @FXML
    private CheckBox updateMensualidad;

    @FXML
    private CheckBox updateHoraEntrenada;

    @FXML
    private CheckBox updateLunes;

    @FXML
    private CheckBox updateMartes;

    @FXML
    private CheckBox updateMiercoles;

    @FXML
    private CheckBox updateJueves;

    @FXML
    private CheckBox updateViernes;

    @FXML
    private CheckBox updateFiveToSix;

    @FXML
    private CheckBox updateSixToSeven;

    @FXML
    private CheckBox updateSevenToEight;

    @FXML
    private CheckBox updateTwoToThree;
    
    @FXML
    private CheckBox updateSi;

    @FXML
    private CheckBox updateNo;

    @FXML
    private TextArea txtUpdateObservations;

    @FXML
    private TextArea txtUpdateStudentAddedFiles;

    @FXML
    private Label LabelUpdateRutaArchivos;

    @FXML
    private Label LabelUpdateRutaFoto;

    @FXML
    private CheckBox updateSabado;

    @FXML
    private TextField txtUpdateStudentRH;

    @FXML
    private TextField txtUpdateStudentSex;
    
    @FXML
    private CheckBox updateTarjetaIdentidad;

    @FXML
    private CheckBox updateCedula;
    
    List<String> updateFilesOfStudent= new ArrayList<>();
    
//updateDojo fxml
    @FXML
    private Pane PaneUpdateDojo;

    @FXML
    private TextField txtUpdateDojoAdress;

    @FXML
    private TextField txtUpdateDojoNIT;

    @FXML
    private TextField txtUpdateDojoCEO;

    @FXML
    private TextField txtUpdateDojoEmail;

    @FXML
    private TextField txtUpdateDojoPhone;

    @FXML
    private TextField txtUpdateDojoEmailEnvio;

    @FXML
    private TextField txtUpdateDojoEmailClave;
    
    @FXML
    private TextField txtUpdateDojoPathStudents;

    @FXML
    private TextField txtUpdateDojoPathRecibos;
    @FXML
    private TextField txtRutaArchivoExcel;
    


//generateReciboEmailfxml

    @FXML
    private Pane PaneGenerateRecibo;

    @FXML
    private TextField txtEmailDestino;

    @FXML
    private TextField txtEmailPadre;

    @FXML
    private TextField txtEmailMadre;

    @FXML
    private TextArea txtEmailMessage;

    @FXML
    private TextField txtAcudienteName;
    
    @FXML
    private TextField txtDiferenciableArchivo;
    
    @FXML
    private TextField txtConceptoRecibo;
    
    @FXML
    private Label reciboNombreEstudiante;
    
    @FXML
    private Label LabelMessage;
    
    private Student studentFactura;
    
    Calendar calendar = new GregorianCalendar();
    
    private String fecha=String.valueOf(calendar.get(Calendar.DATE))+"-"+String.valueOf(calendar.get(Calendar.MONTH)+1)+"-"+String.valueOf(calendar.get(Calendar.YEAR));
    
//deleteStudentfxml
    @FXML
    private Pane PaneDeleteStudent;

    @FXML
    private TextField txtDeleteStudentId;

//studentsList fxml
    @FXML
    private Pane PaneStudentsList;

    @FXML
    private TableView<Student> tableViewStudentsList;

    @FXML
    private TableColumn<Student, String> columnName;

    @FXML
    private TableColumn<Student, String> columnId;

    @FXML
    private TableColumn<Student, String> columnMensualidad;

    @FXML
    private TableColumn<Student, String> columnAuthorization;

    @FXML
    private TableColumn<Student, String> columnBornDate;

    @FXML
    private TableColumn<Student, String> columnRegisterDate;
    
    
    
 // Method to create a dialog window
 	public Dialog<String> createDialog() {
 		Dialog<String> dialog = new Dialog<String>();
 		ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
 		dialog.getDialogPane().getButtonTypes().add(type);
 		return dialog;
 	}
 	
 	public boolean loadDojoData() throws IOException, ClassNotFoundException{
 		File f = new File(SAVE_DOJO_PATH_FILE+"\\dojo.ap2");
 		boolean loaded = false;
 		if(f.exists()){
 			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
 			dojo = (Dojo)ois.readObject();
 			ois.close();
 			loaded = true;
 		}		 
 		return loaded;	
 	}
 	public void saveDojoData() throws IOException{
 		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_DOJO_PATH_FILE+"\\dojo.ap2"));
 		oos.writeObject(dojo);
 		oos.close();
 	}



//optionsWindow methods
    @FXML
    void openLoginScreen(ActionEvent event) throws IOException {
		FXMLLoader login = new FXMLLoader(getClass().getResource("Login.fxml"));
		login.setController(this);
		Parent rootLogin = login.load();
		OptionsWindow.getChildren().setAll(rootLogin);
		txtLoginUsername.getScene().getWindow().setWidth(666);
		txtLoginUsername.getScene().getWindow().setHeight(488);
    }
    
    @FXML
    void openUpdateDojo(ActionEvent event) throws IOException {
		FXMLLoader login = new FXMLLoader(getClass().getResource("UpdateDojo.fxml"));
		login.setController(this);
		Parent rootLogin = login.load();
		PaneOptionsWindow.getChildren().setAll(rootLogin);
		
		txtUpdateDojoAdress.setText(dojo.getAdress());
		txtUpdateDojoCEO.setText(dojo.getCeo());
		txtUpdateDojoNIT.setText(dojo.getNit());
		txtUpdateDojoPhone.setText(dojo.getPhone());
		txtUpdateDojoEmail.setText(dojo.getEmail());
		txtUpdateDojoEmailEnvio.setText(dojo.getEmailEnvio());
		txtUpdateDojoPathStudents.setText(dojo.getPathStudentFiles());
		txtUpdateDojoPathRecibos.setText(dojo.getPathReportes());
		txtRutaArchivoExcel.setText(dojo.getSAVE_PATH_FILE_EXCEL());
		
		txtUpdateDojoAdress.getScene().getWindow().setWidth(700);
		txtUpdateDojoAdress.getScene().getWindow().setHeight(530);
    }
    
    @FXML
    void openCreateStudent(ActionEvent event) throws IOException {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("CreateStudent.fxml"));
		fxml.setController(this);
		Parent root= fxml.load();
		PaneOptionsWindow.getChildren().setAll(root);
		LabelRutaFoto.getScene().getWindow().setWidth(610);
		LabelRutaFoto.getScene().getWindow().setHeight(700);
		filesOfStudent.clear();
    }
   
    @FXML
    void openDeleteStudent(ActionEvent event) throws IOException {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("DeleteStudent.fxml"));
		fxml.setController(this);
		Parent root= fxml.load();
		PaneOptionsWindow.getChildren().setAll(root);
		
		txtDeleteStudentId.getScene().getWindow().setWidth(666);
		txtDeleteStudentId.getScene().getWindow().setHeight(435);
		
    }
    @FXML
    void openStudentsList(ActionEvent event) throws IOException {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("StudentsList.fxml"));
		fxml.setController(this);
		Parent root= fxml.load();
		PaneOptionsWindow.getChildren().setAll(root);
		
		tableViewStudentsList.getScene().getWindow().setWidth(700);
		tableViewStudentsList.getScene().getWindow().setHeight(520);
		initializeStudentTableView();
    }
    
    @FXML //This method will be used when button generateRecibo in updateStudent is clicked, The screen GenerateRecibo does the process to send email
    public void openGenerateRecibo(ActionEvent event) throws IOException {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("GenerateRecibo.fxml"));
		fxml.setController(this);
		Parent root= fxml.load();
		PaneUpdateStudent.getChildren().setAll(root);
		txtEmailMadre.getScene().getWindow().setWidth(677);
		txtEmailMadre.getScene().getWindow().setHeight(529);
		
		
    	Student student=dojo.findStudent(txtUpdateStudentId.getText());
    	txtEmailMadre.setText(student.getMotherEmail());
    	txtEmailPadre.setText(student.getFatherEmail());
    	txtAcudienteName.setText(student.getMotherName());
    	txtEmailDestino.setText(student.getMotherEmail());
    	reciboNombreEstudiante.setText(student.getName());
    	studentFactura=student;
    	txtEmailMessage.setText("Adjunto recibo de la fecha de "+fecha);
    	
    }


//login methods
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
				OptionsWindow.getScene().getWindow().setWidth(615);
				OptionsWindow.getScene().getWindow().setHeight(450);
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
    
//Method to fill the pdf file of RECIBO
    public void addMetaData(Document document, Student student, String aNombreDe, String concepto) throws DocumentException {
    	com.itextpdf.text.Image fotoLogo=null;
   
        try
        {
        	
        	fotoLogo = com.itextpdf.text.Image.getInstance("icons/CHUUGI JKA.jpg");
        	fotoLogo.scaleToFit(200, 200);
        	fotoLogo.setAlignment(Element.ALIGN_LEFT);
        	
        }
        catch ( Exception e )
        {
        	e.printStackTrace();
        }

        
        Paragraph p = new Paragraph(dojo.getAdress()+"\n"
        							+ "NIT: "+dojo.getNit()+"\n"
        							+ dojo.getCeo()+"\n"
        							+ dojo.getEmail()+"\n"
        							+ "CELULAR:"+dojo.getPhone()+"\n\n");
        p.setFont(FontFactory.getFont("Tahoma", 18));
        
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell(p.getContent(), Element.ALIGN_LEFT));
        table.addCell(getCell(fotoLogo, Element.ALIGN_RIGHT));
        document.add(table);
        
        document.add(new Paragraph("\n\n"));
        
        Calendar calendar = new GregorianCalendar();
        
        Paragraph parrafoPagoR = new Paragraph();
        parrafoPagoR.add(concepto+"\n"+
        				String.valueOf(calendar.get(Calendar.DATE))+"/"+String.valueOf(calendar.get(Calendar.MONTH)+1)+"/"+String.valueOf(calendar.get(Calendar.YEAR))+
        				"\n"+student.getName() +" "+student.getId()+
        				"\n"+"RECIBIDO DE "+aNombreDe);
        parrafoPagoR.setFont(FontFactory.getFont("Tahoma", 18));
        
        PdfPTable tablePago = new PdfPTable(2);
        tablePago.setWidthPercentage(70);
        tablePago.addCell(getCell("CONCEPTO", Element.ALIGN_CENTER)).setBackgroundColor(BaseColor.RED);
        tablePago.addCell(getCell("VALOR", Element.ALIGN_CENTER)).setBackgroundColor(BaseColor.RED);
        tablePago.addCell(getCell(parrafoPagoR.getContent(), Element.ALIGN_CENTER)).setMinimumHeight(50);
        tablePago.addCell(getCell("$"+String.valueOf(student.getValueMensualidad()), Element.ALIGN_CENTER));
        tablePago.addCell(getCell("TOTAL", Element.ALIGN_CENTER)).setBackgroundColor(BaseColor.LIGHT_GRAY);
        tablePago.addCell(getCell("$"+String.valueOf(student.getValueMensualidad()), Element.ALIGN_CENTER)).setBackgroundColor(BaseColor.LIGHT_GRAY);
                
        document.add(tablePago);
        
        document.add(new Paragraph("\n\n"));
        
        Paragraph parrafoAviso = new Paragraph("Los pagos se recibirán los cinco primeros días del mes según lo acordado"
        		+ " en el Reglamento Interno, después del quinto día tendrá un sobrecosto del 10%");
        parrafoAviso.setFont(FontFactory.getFont(FontFactory.TIMES_ITALIC, 12));
        document.add(parrafoAviso);
    }

//methods to configurate the cell of a table in pdf
    public static PdfPCell getCell(String text, int alignment) {//Configuracion de la celda del texto (izquierda)
        PdfPCell cell = new PdfPCell(new Phrase(text));
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setMinimumHeight(18);
        return cell;
    }
    
    public static PdfPCell getCell(com.itextpdf.text.Image img, int alignment) {//configuracion de la celda de la imagen (derecha)
        PdfPCell cell = new PdfPCell();
        cell.addElement(img);
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(Rectangle.NO_BORDER);
        return cell;
    }
    
//createStudent methods  
    @FXML
    void addProfilePicture(ActionEvent event) {
    	if(!LabelRutaFoto.getText().equals("")) {
    		File file = new File(LabelRutaFoto.getText());
    		Image img = new Image(file.toURI().toString());
    		profilePicture.setImage(img);
    	}
    	else {
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error, no hay foto elegida");
    		dialog.setContentText("Debe elegir una foto de su computador previamente en el boton buscar Foto y luego si añadirla");
    		dialog.show();
    	}
    }

    @FXML
    void addFileToStudent(ActionEvent event) {
    	if(!LabelRutaArchivos.getText().equals("")) {
    		filesOfStudent.add(LabelRutaArchivos.getText());
    		
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Archivo Añadido");
    		dialog.setContentText("El archivo "+LabelRutaArchivos.getText()+" ha sido añadido a la lista de archivos del estudiante");
    		dialog.show();
    		
    		LabelRutaArchivos.setText("");
    	}
    	else {
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error, archivo requerido");
    		dialog.setContentText("Debe escoger algún archivo para añadirlo a los archivos del estudiante ");
    		dialog.show();
    	}
    }

	@FXML
    void createStudent(ActionEvent event) throws BadElementException, MalformedURLException, IOException {
    	String name= txtStudentName.getText();
    	String rh=txtStudentRH.getText();
    	String sex=txtStudentSex.getText();
    	String bornDate;
    	String bornPlace= txtStudentBornPlace.getText();
    	String id= txtStudentId.getText();
    	String profilePicture=LabelRutaFoto.getText();
    	String idType= getIdType();
    	String eps=txtStudentEPS.getText();
    	String ocupation=txtStudentOcupation.getText();
    	String fatherName=txtStudentFatherName.getText();
    	String fatherPhone=txtStudentFatherPhone.getText();
    	String fatherEmail=txtStudentFatherEmail.getText();
    	String motherName= txtStudentMotherName.getText();
    	String motherPhone=txtStudentMotherPhone.getText();
    	String motherEmail=txtStudentMotherEmail.getText();
    	String adress=txtStudentAdress.getText();
    	String neighborhood=txtStudentNeighborhood.getText();
    	String registerDate;
    	String planPagoEntreno= getPlanPago();
    	List<String> trainDays=getTrainDays();
    	List<String> scheduleDays=getScheduleDays();
    	String observations=txtStudentObservations.getText();
    	boolean authorization=getAuthorization();//por determinado esta en false
    	String filesDescription= txtStudentAddedFiles.getText();
    	List<String> filesPath= filesOfStudent;
    	double valueMensualidad=0;
    	
    	try {//Intente si se escogió una fecha
    		registerDate=txtStudentRegisterDate.getValue().toString();
    	}catch(NullPointerException e) {
    		registerDate="";
    	}

    	try {//Intente si el valor es parseable a un double
    		valueMensualidad=Double.parseDouble(txtStudentMensualidad.getText());
    	}catch(Exception e) {
    		valueMensualidad=0;
    	}
    	
    	try {//intente si se escogio una fecha de nacimiento
    		bornDate= txtStudentBornDate.getValue().toString();
    	}catch(NullPointerException e) {
    		bornDate="";
    	}

    	if(valueMensualidad!=0) {
    		if(!id.equals("")) {
    			if(!LabelRutaFoto.getText().equals("") && !LabelRutaFoto.getText().equals("Ruta de la foto")) {
    				if(!bornDate.isEmpty() && !registerDate.isEmpty()) {
    					if(!eps.equals("") && !rh.equals("") && !sex.equals("")) {
    						dojo.createStudent(name,rh, sex, bornDate, bornPlace, id, profilePicture, idType, eps, 
    								ocupation, fatherName, fatherPhone, fatherEmail, motherName, motherPhone, 
    								motherEmail, adress, neighborhood, registerDate, valueMensualidad, planPagoEntreno, 
    								trainDays, scheduleDays, observations, authorization,filesDescription, filesPath);
    						saveDojoData();
    					     
    						filesOfStudent.clear();
    					}
    					else {
            				Dialog<String> dialog = createDialog();
                			dialog.setTitle("Error, la informacion de salud es necesaria");
                			dialog.setContentText("Recuerde que la infromacion de eps, rh y sexo"
                					+ "} son necesarias para crear el estudiante");
                			dialog.show();
    					}
    				}
    				else {
        				Dialog<String> dialog = createDialog();
            			dialog.setTitle("Error, el campo de fecha de nacimiento y de registro es necesario");
            			dialog.setContentText("Recuerde que las fechas de nacimiento y registro son necesarias para crear el estudiante");
            			dialog.show();
    				}
    			}
    			else {
    				Dialog<String> dialog = createDialog();
        			dialog.setTitle("Error, la foto es necesaria");
        			dialog.setContentText("Recuerde que la foto de perfil es necesaria para crear el estudiante");
        			dialog.show();
    			}
    		}
    		else {
    			Dialog<String> dialog = createDialog();
    			dialog.setTitle("Error, la identificación es necesaria");
    			dialog.setContentText("Recuerde que el campo de id es necesario para crear el estudiante");
    			dialog.show();
    		}
    	}
    	else {
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error, valor mensualidad incorrecto");
    		dialog.setContentText("Recuerde que el valor de mensualidad debe ser un numero real (utilizar separador .)");
    		dialog.show(); 
    	}
    }
	
    @FXML //Method that creates the new pdf in the student
    public void createNewPdf(ActionEvent event){
    	
    	try {
    		if(!txtDiferenciablePdf.getText().equals("")) {
    			FileOutputStream archivo= new FileOutputStream(dojo.getPathStudentFiles()+"\\"+txtUpdateStudentName.getText()+txtUpdateStudentId.getText()+"\\"
    					+"constancia "+txtDiferenciablePdf.getText()+".pdf");

    			Document document= new Document();  


    			try {//
    				PdfWriter.getInstance(document, archivo);
    				document.open();
    				addMatriculaFormat(document, LabelUpdateRutaFoto.getText(), txtUpdateStudentId.getText());
    				Dialog<String> dialog = createDialog();
    				dialog.setTitle("Pdf generado" );
    				dialog.setContentText("El pdf con la informacion del estudiante ha sido generado y guardado en la carpeta del estudiante");
    				dialog.show(); 
    			} catch (DocumentException e) {
    				e.printStackTrace();
    			}
    			document.close();
    		}
    		else {
    			Dialog<String> dialog = createDialog();
    			dialog.setTitle("Error, diferenciable requerido" );
    			dialog.setContentText("Debe llenar el campo de texto del diferenciable del archivo");
    			dialog.show(); 
    		}
    	}catch(FileNotFoundException e) {
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error, directorio no encontrado" );
    		dialog.setContentText("No se ha encontrado el directorio "+dojo.getPathStudentFiles()+"\\"+txtStudentName.getText()+txtStudentId.getText()+" para poder añadir el pdf");
    		dialog.show(); 
    	}
    }

    @FXML //Method that creates the own directory of the student and the CONSTANCIAMATRICULA of the new Student
    public void generateCreatePDF(ActionEvent event){
    	
    	try {
    	FileOutputStream archivo= new FileOutputStream(dojo.getPathStudentFiles()+"\\"+txtStudentName.getText()+txtStudentId.getText()+"\\"+"constanciaMatricula"+".pdf");
    	
    	Document document= new Document();  
    	
    	try {//
			PdfWriter.getInstance(document, archivo);
			document.open();
			addMatriculaFormat(document, LabelRutaFoto.getText(), txtStudentId.getText());
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Matricula generada" );
    		dialog.setContentText("La matricula del estudiante ha sido generada y guardada en la carpeta del estudiante");
    		dialog.show(); 
		} catch (DocumentException e) {
			e.printStackTrace();
		}
    	document.close();
    	}catch(FileNotFoundException e) {
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error, directorio no encontrado" );
    		dialog.setContentText("No se ha encontrado el directorio "+dojo.getPathStudentFiles()+"\\"+txtStudentName.getText()+txtStudentId.getText()+" para poder añadir la constancia de matricula");
    		dialog.show(); 
    	}
    }

    public void addMatriculaFormat(Document document, String imageRuta, String studentId) throws DocumentException {
    	com.itextpdf.text.Image fotoLogo=null;
    	com.itextpdf.text.Image fotoPerfil=null;
    	   
        try
        {
        	fotoPerfil = com.itextpdf.text.Image.getInstance(imageRuta);
        	fotoPerfil.scaleToFit(100, 100);
        	fotoPerfil.setAlignment(Element.ALIGN_RIGHT);
        	
        	fotoLogo = com.itextpdf.text.Image.getInstance("icons/CHUUGI JKA.jpg");
        	fotoLogo.scaleToFit(200, 200);
        	fotoLogo.setAlignment(Element.ALIGN_LEFT);
        	
        }catch ( Exception e ){
        	e.printStackTrace();
        	Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error al generar encabezado del pdf de matricula" );
    		dialog.setContentText("No se pudo cargar la imagen del CHUUGI JKA o la foto de perfil del estudiante");
    		dialog.show(); 
        }
        
        if(fotoPerfil!=null && fotoLogo!=null) {
        	PdfPTable tableHeader = new PdfPTable(2);
        	tableHeader.setWidthPercentage(100);
        	tableHeader.addCell(getCell(fotoLogo, Element.ALIGN_LEFT));
        	tableHeader.addCell(getCell(fotoPerfil, Element.ALIGN_RIGHT));
        	document.add(tableHeader);
        }
        
        document.add(new Paragraph("\n\n"));
        
        Student student=dojo.findStudent(studentId);
        
        PdfPTable tableConstancia = new PdfPTable(2);
        tableConstancia.setWidthPercentage(70);
        tableConstancia.addCell(getCellBorder("NOMBRE DEL ESTUDIANTE", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getName(), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("FECHA DE NACIMIENTO", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getBornDate(), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("LUGAR DE NACIMIENTO", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getBornPlace(), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("DOCUMENTO DE IDENTIDAD", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getIdType()+":"+student.getId(), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("SALUD", Element.ALIGN_CENTER)).setMinimumHeight(40);
        tableConstancia.addCell(getCellBorder("Entidad: "+student.getEps()+"\n"+"RH: "+student.getRH()+"\n"+"Sexo: "+student.getSex()+"\n", Element.ALIGN_LEFT)).setMinimumHeight(40);;
        tableConstancia.addCell(getCellBorder("OCUPACION", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getOcupation(), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("NOMBRE DEL PADRE", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getFatherName(), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("TELEFONO DEL PADRE", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getFatherPhone(), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("EMAIL DEL PADRE", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getFatherEmail(), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("NOMBRE DE LA MADRE", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getMotherName(), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("TELEFONO DE LA MADRE", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getMotherPhone(), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("EMAIL DE LA MADRE", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getMotherEmail(), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("DIRECCION", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getAdress(), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("BARRIO:", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getNeighborhood(), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("FECHA DE INGRESO", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getRegisterDate(), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("VALOR MENSUALIDAD", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(String.valueOf(student.getValueMensualidad()), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("PLAN PAGO ENTRENO", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getPlanPagoEntreno(), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("DIAS DE ENTRENO", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(String.valueOf(student.getTrainDays()), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("HORARIOS DE ENTRENO", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(String.valueOf(student.getScheduleDays()), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("OBSERVACIONES", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getObservations(), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("AUTORIZACION PARA EL USO DE SU IMAGEN EN PUBLICACIONES EN REDES SOCIALES:", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(String.valueOf(student.isAuthorization()), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("ARCHIVOS ADJUNTADOS", Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getFilesDescription(), Element.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("ACUDIENTE RESPONSABLE", Element.ALIGN_MIDDLE)).setMinimumHeight(50);
        tableConstancia.addCell(getCellBorder("NOMBRE:___________________\n"+"CEDULA:___________________\n "+"FIRMA:___________________", Element.ALIGN_CENTER)).setMinimumHeight(50);
        document.add(tableConstancia);
        	
	}
    
    public static PdfPCell getCellBorder(String text, int alignment) {//configuracion de la celda del texto (izquierda)
    	Phrase phrase= new Phrase(text);
        PdfPCell cell = new PdfPCell(phrase);
        cell.setPadding(0);
        cell.setMinimumHeight(20);
        cell.setHorizontalAlignment(alignment);
        return cell;
    }

	@FXML
    public void openFileChooserPicture(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File selectedFile= fc.showOpenDialog(null);
        
        if(selectedFile!=null) {
        	LabelRutaFoto.setText(selectedFile.getAbsolutePath());
        }
    }
    
    @FXML
    public void openFileChooserFiles(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File selectedFile= fc.showOpenDialog(null);
        
        if(selectedFile!=null) {
        	LabelRutaArchivos.setText(selectedFile.getAbsolutePath());
        }
    }
    
    
    public String getIdType() {
    	String idType="";
    	if(cedula.isSelected()==true) {
    		idType="CC";
    	}
    	else if(tarjetaIdentidad.isSelected()==true) {
    		idType="TI";
    	}
		return idType;
    	
    }
    public String getPlanPago() {
    	String plan="";
    	if(mensualidad.isSelected()==true) {
    		plan="Mensualidad";
    	}
    	else if(horaEntrenada.isSelected()==true){
    		plan="Hora Entrenada";
    	}
    	
    	return plan;
    }
    public List<String> getTrainDays(){
    	List<String> trainDays=new ArrayList<>();
    	if(lunes.isSelected()==true) {
    		trainDays.add("lunes");
    	}
    	if(martes.isSelected()==true) {
    		trainDays.add("martes");
    	}
    	if(miercoles.isSelected()==true) {
    		trainDays.add("miercoles");
    	}
    	if(jueves.isSelected()==true) {
    		trainDays.add("jueves");
    	}
    	if(viernes.isSelected()==true) {
    		trainDays.add("viernes");
    	}
    	if(sabado.isSelected()==true) {
    		trainDays.add("sabado");
    	}
    	
    	return trainDays;
    }
    public List<String> getScheduleDays(){
    	List<String> trainDays=new ArrayList<>();
    	
    	if(twoToThree.isSelected()==true) {
    		trainDays.add("2-3");
    	}
    	if(fiveToSix.isSelected()==true) {
    		trainDays.add("5-6");
    	}
    	if(sevenToEight.isSelected()==true) {
    		trainDays.add("7-8");
    	}
    	if(sixToSeven.isSelected()==true) {
    		trainDays.add("6-7");
    	}
    	
    	return trainDays;
    }
    public boolean getAuthorization() {
    	boolean aut=false;
    	if(si.isSelected()==true) {
    		aut=true;
    	}
    	else if(no.isSelected()==true) {
    		aut=false;
    	}
    	return aut;
    }

    
  //Method to initialize the values in Clients Tableview in user screen
  	public void initializeStudentTableView() {
  		
  		ObservableList<Student> studentsList = FXCollections.observableArrayList(dojo.getStudents());

  		columnName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
  		columnId.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
  		columnMensualidad.setCellValueFactory(new PropertyValueFactory<Student, String>("valueMensualidad"));
  		columnAuthorization.setCellValueFactory(new PropertyValueFactory<Student, String>("authorization"));
  		columnBornDate.setCellValueFactory(new PropertyValueFactory<Student, String>("bornDate"));
  		columnRegisterDate.setCellValueFactory(new PropertyValueFactory<Student, String>("registerDate"));

  		tableViewStudentsList.setItems(studentsList);

  		tableViewStudentsList.setRowFactory(tv -> {
  			TableRow<Student> row = new TableRow<>();
  			row.setOnMouseClicked(event -> {
  				if (event.getClickCount() == 2 && (!row.isEmpty())) {
  					Student student = row.getItem();
  					try {
  						FXMLLoader updateStudentFxml = new FXMLLoader(getClass().getResource("UpdateStudent.fxml"));
  						updateStudentFxml.setController(this);
  						Parent root = updateStudentFxml.load();
  						PaneStudentsList.getChildren().setAll(root);
  						txtUpdateStudentAdress.getScene().getWindow().setWidth(610);
  						txtUpdateStudentAdress.getScene().getWindow().setHeight(700);
  						
  			    		File file = new File(student.getProfilePicture());
  			    		Image img = new Image(file.toURI().toString());
  						updateProfilePicture.setImage(img);
  						txtUpdateStudentName.setText(student.getName());
  						LabelUpdateRutaFoto.setText(student.getProfilePicture());
  						txtUpdateStudentBornPlace.setText(student.getBornPlace());
  						txtUpdateStudentId.setText(student.getId());
  						
  						if(getUpdateIdType().equals("TI")) {
  							updateTarjetaIdentidad.setSelected(true);
  						}
  						else {
  							updateCedula.setSelected(true);
  						}
  						
  						txtUpdateStudentEPS.setText(student.getEps());
  						txtUpdateStudentRH.setText(student.getRH());
  						txtUpdateStudentSex.setText(student.getSex());
  						txtUpdateStudentOcupation.setText(student.getOcupation());
  						txtUpdateStudentFatherName.setText(student.getFatherName());
  						txtUpdateStudentFatherPhone.setText(student.getFatherPhone());
  						txtUpdateStudentFatherEmail.setText(student.getFatherEmail());
  						txtUpdateStudentMotherName.setText(student.getMotherName());
  						txtUpdateStudentMotherPhone.setText(student.getMotherPhone());
  						txtUpdateStudentMotherEmail.setText(student.getMotherEmail());
  						txtUpdateStudentAdress.setText(student.getAdress());
  						txtUpdateStudentNeighborhood.setText(student.getNeighborhood());
  						txtUpdateStudentMensualidad.setText(String.valueOf(student.getValueMensualidad()));
  						
  						if(getUpdatePlanPago().equals("Mensualidad")) {
  							updateMensualidad.setSelected(true);
  						}
  						else {
  							updateHoraEntrenada.setSelected(true);
  						}
  						List<String> trainDays= student.getTrainDays();
  						for(int i=0;i<trainDays.size();i++) {
  							if(trainDays.get(i).equals("lunes")) {
  								updateLunes.setSelected(true);
  							}
  							else if(trainDays.get(i).equals("martes")) {
  								updateMartes.setSelected(true);
  							}
  							else if(trainDays.get(i).equals("miercoles")) {
  								updateMiercoles.setSelected(true);
  							}
  							else if(trainDays.get(i).equals("jueves")) {
  								updateJueves.setSelected(true);
  							}
  							else if(trainDays.get(i).equals("viernes")) {
  								updateViernes.setSelected(true);
  							}
  							else if(trainDays.get(i).equals("sabado")) {
  								updateSabado.setSelected(true);
  							}
  						}
  						List<String> scheduleDays= student.getScheduleDays();
  						for(int i=0;i<scheduleDays.size();i++) {
  							if(scheduleDays.get(i).equals("2-3")) {
  								updateTwoToThree.setSelected(true);
  							}
  							else if(scheduleDays.get(i).equals("5-6")) {
  								updateFiveToSix.setSelected(true);
  							}
  							else if(scheduleDays.get(i).equals("6-7")) {
  								updateSixToSeven.setSelected(true);
  							}
  							else if(scheduleDays.get(i).equals("7-8")) {
  								updateSevenToEight.setSelected(true);
  							}
  						}
  						txtUpdateObservations.setText(student.getObservations());
  						
  						if(student.isAuthorization()==true) {
  							updateSi.setSelected(true);
  						}
  						else {
  							updateNo.setSelected(true);
  						}
  						txtUpdateStudentAddedFiles.setText(student.getFilesDescription());

  					} catch (IOException e) {
  						e.printStackTrace();
  					}

  				}
  			});
  			return row;
  		});
  	}
  	
    @FXML
    void updateAddFileToStudent(ActionEvent event) {
    	if(!LabelUpdateRutaArchivos.getText().equals("")) {
    		updateFilesOfStudent.add(LabelUpdateRutaArchivos.getText());
    		
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Archivo Añadido");
    		dialog.setContentText("El archivo "+LabelUpdateRutaArchivos.getText()+" ha sido añadido a la lista de archivos del estudiante");
    		dialog.show();
    		
    		LabelUpdateRutaArchivos.setText("");
    	}
    	else {
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error, archivo requerido");
    		dialog.setContentText("Debe escoger algún archivo para añadirlo a los archivos del estudiante ");
    		dialog.show();
    	}
    }

    @FXML
    void updateGeneratePDF(ActionEvent event) {

    }

    @FXML
    void updateProfilePcture(ActionEvent event) {
    	if(!LabelUpdateRutaFoto.getText().equals("")) {
    		File file = new File(LabelUpdateRutaFoto.getText());
    		Image img = new Image(file.toURI().toString());
    		updateProfilePicture.setImage(img);
    	}
    	else {
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error, no hay foto elegida");
    		dialog.setContentText("Debe elegir una foto de su computador previamente en el boton buscar Foto y luego si actualizarla");
    		dialog.show();
    	}
    }

    @FXML
    void updateStudent(ActionEvent event) {
    	Student student= dojo.findStudent(txtUpdateStudentId.getText());
    	boolean mensualidadCorrecta=false;
    	
    	try {
        	student.setValueMensualidad(Double.parseDouble(txtUpdateStudentMensualidad.getText()));
        	mensualidadCorrecta=true;
        	
    	}catch(Exception e) {
    	
    	}
    	
    	if(mensualidadCorrecta==true) {
    		student.setAdress(txtUpdateStudentAdress.getText());
    		student.setAuthorization(getUpdateAuthorization());
    		student.setEps(txtUpdateStudentEPS.getText());
    		student.setFatherPhone(txtUpdateStudentFatherPhone.getText());
    		student.setFatherEmail(txtUpdateStudentFatherEmail.getText());
    		student.setFilesDescription(txtUpdateStudentAddedFiles.getText());

    		List<String> existingFilesPath= student.getFilesPath();
    		for (int i=0;i<updateFilesOfStudent.size();i++) {
    			existingFilesPath.add(updateFilesOfStudent.get(i));
    		}
    		student.setFilesPath(existingFilesPath);
    		student.setIdType(getUpdateIdType());
    		student.setMotherPhone(txtUpdateStudentMotherPhone.getText());
    		student.setMotherEmail(txtUpdateStudentMotherEmail.getText());
    		student.setNeighborhood(txtUpdateStudentNeighborhood.getText());
    		student.setObservations(txtUpdateObservations.getText());
    		student.setOcupation(txtUpdateStudentOcupation.getText());
    		student.setPlanPagoEntreno(getUpdatePlanPago());
    		if(!LabelUpdateRutaFoto.getText().equals("Ruta de la foto")) {
    			student.setProfilePicture(LabelUpdateRutaFoto.getText());
    		}
    		student.setScheduleDays(getUpdateScheduleDays());
    		student.setTrainDays(getUpdateTrainDays());

			File directorio = new File(dojo.getPathStudentFiles()+"\\"+student.getName()+student.getId()); //ADENTRO IRIA DONDE SE QUIERE CREAR EL DIRECTORIO
    		
			for(int i=0;i<updateFilesOfStudent.size();i++) {
				dojo.fileCopy(updateFilesOfStudent.get(i), (directorio.getAbsolutePath()));
			}
			
			try {
				saveDojoData();
			} catch (IOException e) {
	    		Dialog<String> dialog = createDialog();
	    		dialog.setTitle("La información no se pudo serializar");
	    		dialog.setContentText("Imposible serializar la nueva informacion del estudiante");
	    		dialog.show();
			}
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Informacion actualizada");
    		dialog.setContentText("Se ha actualizado satisfactoriamente la información del estudiante");
    		dialog.show();
    	}
    	else {
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error mensualidad incorrecta");
    		dialog.setContentText("Debe ingresar una mensualidad correcta, recuerde usar como separador decimal el .");
    		dialog.show();
    	}

    }
    
    @FXML
    public void openUpdateFileChooserPicture(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File selectedFile= fc.showOpenDialog(null);
        
        if(selectedFile!=null) {
        	LabelUpdateRutaFoto.setText(selectedFile.getAbsolutePath());
        }
    }
    
    @FXML
    public void openUpdateFileChooserFiles(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File selectedFile= fc.showOpenDialog(null);
        
        if(selectedFile!=null) {
        	LabelUpdateRutaArchivos.setText(selectedFile.getAbsolutePath());
        }
    }
    public String getUpdateIdType() {
    	String idType="";
    	if(updateCedula.isSelected()==true) {
    		idType="CC";
    	}
    	else if(updateTarjetaIdentidad.isSelected()==true) {
    		idType="TI";
    	}
		return idType;
    	
    }
    public String getUpdatePlanPago() {
    	String plan="";
    	if(updateMensualidad.isSelected()==true) {
    		plan="Mensualidad";
    	}
    	else if(updateHoraEntrenada.isSelected()==true){
    		plan="Hora Entrenada";
    	}
    	
    	return plan;
    }
    public List<String> getUpdateTrainDays(){
    	List<String> trainDays=new ArrayList<>();
    	if(updateLunes.isSelected()==true) {
    		trainDays.add("lunes");
    	}
    	if(updateMartes.isSelected()==true) {
    		trainDays.add("martes");
    	}
    	if(updateMiercoles.isSelected()==true) {
    		trainDays.add("miercoles");
    	}
    	if(updateJueves.isSelected()==true) {
    		trainDays.add("jueves");
    	}
    	if(updateViernes.isSelected()==true) {
    		trainDays.add("viernes");
    	}
    	if(updateSabado.isSelected()==true) {
    		trainDays.add("sabado");
    	}
    	
    	return trainDays;
    }
    public List<String> getUpdateScheduleDays(){
    	List<String> trainDays=new ArrayList<>();
    	
    	if(updateTwoToThree.isSelected()==true) {
    		trainDays.add("2-3");
    	}
    	if(updateFiveToSix.isSelected()==true) {
    		trainDays.add("5-6");
    	}
    	if(updateSevenToEight.isSelected()==true) {
    		trainDays.add("7-8");
    	}
    	if(updateSixToSeven.isSelected()==true) {
    		trainDays.add("6-7");
    	}
    	
    	return trainDays;
    }
    public boolean getUpdateAuthorization() {
    	boolean aut=false;
    	if(updateSi.isSelected()==true) {
    		aut=true;
    	}
    	else if(updateNo.isSelected()==true) {
    		aut=false;
    	}
    	return aut;
    }



    @FXML
    public void deleteStudent(ActionEvent event) throws IOException {
    	if(!txtDeleteStudentId.getText().equals("")) {
    		dojo.deleteStudent(txtDeleteStudentId.getText());
    		saveDojoData();
    	}
    	else {
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error, campos incompletos");
    		dialog.setContentText("Debe ingresar la identificación del estudiante a eliminar");
    		dialog.show();
    	}
    }
    @FXML
    public void createRecibo(ActionEvent event) throws FileNotFoundException {
    	FileOutputStream archivo= new FileOutputStream(dojo.getPathReportes()+"\\"+studentFactura.getName()+" "+studentFactura.getId()+" "+fecha+" "+txtDiferenciableArchivo.getText()+" "+"Recibo.pdf");
    	FileOutputStream archivoCarpetaEstudiante= new FileOutputStream(dojo.getPathStudentFiles()+"\\"+studentFactura.getName()+studentFactura.getId()+"\\"+fecha+" "+txtDiferenciableArchivo.getText()+" "+"Recibo.pdf");
    	
    	Document document= new Document();  
    	Document document2= new Document();  
    	
    	try {//
			PdfWriter.getInstance(document, archivo);
			document.open();
			addMetaData(document, studentFactura, txtAcudienteName.getText(), txtConceptoRecibo.getText());
			
			PdfWriter.getInstance(document2, archivoCarpetaEstudiante);
			document2.open();
			addMetaData(document2, studentFactura, txtAcudienteName.getText(), txtConceptoRecibo.getText());
			
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Recibo creado satisfactoriamente");
    		dialog.setContentText("El recibo ha sido creado en la carpeta de Recibos y en la carpeta del estudiante");
    		dialog.show();
		} catch (DocumentException e) {
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error, ha ocurrido un error al crear el pdf del recibo");
    		dialog.setContentText("El pdf de recibo no ha podido ser creado por algun elemento");
    		dialog.show();
		}catch(Exception e) {
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error, ha ocurrido un error al crear el pdf del recibo");
    		dialog.setContentText("El pdf de recibo no ha podido ser creado");
    		dialog.show();
		}
    	document.close();
    	document2.close();
    }

    @FXML
    public void generateReciboEmail(ActionEvent event) throws FileNotFoundException {

    	Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");// a que servidor nos vamos a conectar, en este caso gmail
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");//puerto por el que nos vamos a conectar (el puerto que nos da gmail es el 587)
        propiedad.setProperty("mail.smpt.auth", "true");
        propiedad.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        Session sesion = Session.getDefaultInstance(propiedad);
        String correoEnvia = dojo.getEmailEnvio();
        String contrasena = dojo.getClaveEmail();
        String receptor = txtEmailDestino.getText();
        
        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (receptor));
            
            BodyPart parteTexto= new MimeBodyPart();
            parteTexto.setContent(txtEmailMessage.getText(), "text/html");
            BodyPart parteArchivo= new MimeBodyPart();
            parteArchivo.setDataHandler(new DataHandler(new FileDataSource(dojo.getPathReportes()+"\\"
            											+studentFactura.getName()+" "+studentFactura.getId()+" "+fecha+" "+txtDiferenciableArchivo.getText()+" "+"Recibo.pdf")));
            parteArchivo.setFileName("Recibo "+fecha+".pdf");
            
            MimeMultipart multiPart= new MimeMultipart();
            multiPart.addBodyPart(parteTexto);
            multiPart.addBodyPart(parteArchivo);
            
            mail.setContent(multiPart);
            
            Transport transportar = sesion.getTransport("smtp");
            transportar.connect(correoEnvia,contrasena);
            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
            transportar.close();
            
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Correo Enviado");
    		dialog.setContentText("El recibo ha sido generado en la carpeta de Recibos y ha sido enviado al correo");
    		dialog.show();
            
            
        } catch (AddressException ex) {
        	ex.printStackTrace();
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error, el correo no ha podido ser enviado");
    		dialog.setContentText("Revise los correos, puede que esten digitados incorrectamente");
    		dialog.show();
        } catch (MessagingException ex) {
        	ex.printStackTrace();
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error, correo no ha podido ser enviado");
    		dialog.setContentText("verifique la existencia del recibo adjunto en la carpeta Recibos o el correo de origen");
    		dialog.show();
        }
        
    }
    

    @FXML
    void updateDojo(ActionEvent event) {
    	dojo.setAdress(txtUpdateDojoAdress.getText());
    	dojo.setCeo(txtUpdateDojoCEO.getText());
    	dojo.setEmail(txtUpdateDojoEmail.getText());
    	dojo.setNit(txtUpdateDojoNIT.getText());
    	dojo.setPhone(txtUpdateDojoPhone.getText());
    	dojo.setEmailEnvio(txtUpdateDojoEmailEnvio.getText());
    	dojo.setPathStudentFiles(txtUpdateDojoPathStudents.getText());
    	dojo.setPathReportes(txtUpdateDojoPathRecibos.getText());
    	dojo.setSAVE_PATH_FILE_EXCEL(txtRutaArchivoExcel.getText());
    	
    	if(!txtUpdateDojoEmailClave.getText().equals("")) {
    		dojo.setClaveEmail(txtUpdateDojoEmailClave.getText());
    	}
    	try {
			saveDojoData();
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Datos del dojo actualizados");
    		dialog.setContentText("Los datos del dojo han sido actualizados satisfactoriamente");
    		dialog.show();
		} catch (IOException e) {
			e.printStackTrace();
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error, al guardar datos del dojo");
    		dialog.setContentText("Los datos del dojo no se pudieron serializar");
    		dialog.show();
		}
    }
    
    @FXML
    public void exportStudentsData(ActionEvent event) throws FileNotFoundException {
    	try {
    		exportEmployeesData(dojo.getSAVE_PATH_FILE_EXCEL()+"\\Lista Estudiantes.csv", ";");
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Datos Estudiantes exportados");
    		dialog.setContentText("Se ha generado el archivo excel con la lista de estudiantes");
    		dialog.show();
    	}catch(Exception e) {
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error, algo salio mal al exportar datos");
    		dialog.setContentText("No se ha podido generar el archivo de excel con los datos de los alumnos");
    		dialog.show();
    	}
    }
    
    public void exportEmployeesData(String fileName, String sep) throws FileNotFoundException {

    	PrintWriter pw= new PrintWriter(fileName);

    	pw.println("Nombre"+sep+"Tipo Id"+sep+"Identificacion"+sep+"Fecha de Nacimiento"+sep+"Lugar de nacimiento"+
    			sep+"Salud"+sep+"RH"+sep+"Sexo"+sep+"Ocupacion"+sep+"Nombre Padre"+sep+"Telefono Padre"+sep+"Email Padre"+
    			sep+"Nombre Madre"+sep+"Telefono Madre"+sep+"Email Madre"+sep+"Direccion"+sep+"Barrio"+sep+"Fecha Ingreso"+sep+"Mensualidad"+
    			sep+"Plan Pago Entreno"+sep+"Dias de Entreno"+sep+"Horario"+sep+"Observaciones"+sep+"Autorizacion");

    	for(int i=0;i<dojo.getStudents().size();i++) {
    		Student student= dojo.getStudents().get(i);

    		pw.println(student.getName()+sep+student.getIdType()+sep+student.getId()+sep+student.getBornDate()+sep+student.getBornPlace()
    		+sep+student.getEps()+sep+student.getRH()+sep+student.getSex()+sep+student.getOcupation()+sep+student.getFatherName()+
    		sep+student.getFatherPhone()+sep+student.getFatherEmail()+sep+student.getMotherName()+sep+student.getMotherPhone()+sep+student.getMotherEmail()+
    		sep+student.getAdress()+sep+student.getNeighborhood()+sep+student.getRegisterDate()+sep+student.getValueMensualidad()+
    				sep+student.getPlanPagoEntreno()+sep+student.getTrainDays().toString()+sep+student.getScheduleDays().toString()+
    				sep+student.getObservations()+sep+student.isAuthorization());		 
    	}
    	pw.close();
    }
}


