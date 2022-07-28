package ui;

import java.io.File;
import java.io.FileInputStream;
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
import javax.mail.AuthenticationFailedException;
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

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar.ButtonData;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Dojo;
import model.Student;

public class DojoGUI {
 //constants
	//public final static String SAVE_DOJO_PATH_FILE="G:\\Mi unidad\\LEOC\\App Chuugi Dojo\\Datos ChuugiDojo";//nuevo compputador de luz

	//public final static String SAVE_DOJO_PATH_FILE="G:\\Mi unidad\\LEOC\\App Chuugi Dojo\\Datos ChuugiDojo";//nuevo compputador de luz
	//public final static String SAVE_DOJO_PATH_FILE="C:\\Users\\USER\\Nextcloud\\L-Ortiz\\App Chuugi Dojo\\Datos ChuugiDojo";// para la laptop de luz
	//public final static String SAVE_DOJO_PATH_FILE="C:\\Users\\tomas\\eclipse-workspace\\jfx-ChuugiDojo\\data";
	public final static String SAVE_DOJO_PATH_FILE="C:\\Users\\tomas\\Desktop\\Tomas\\App Chuugi Dojo\\Datos Chuugi Dojo";

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

    @FXML
    public void homeCreateStudent(MouseEvent event) throws IOException {
    	FXMLLoader optionsFxml = new FXMLLoader(getClass().getResource("Menu2.fxml"));
		optionsFxml.setController(this);
		Parent opWindow = optionsFxml.load();
		Stage stage= (Stage) PaneCreateStudent.getScene().getWindow();
		stage.setScene(new Scene(opWindow));
    }
    @FXML
    public void homeDeleteStudent(MouseEvent event) throws IOException {
    	FXMLLoader optionsFxml = new FXMLLoader(getClass().getResource("Menu2.fxml"));
		optionsFxml.setController(this);
		Parent opWindow = optionsFxml.load();
		Stage stage= (Stage) PaneDeleteStudent.getScene().getWindow();
		stage.setScene(new Scene(opWindow));
    }
    @FXML
    public void homeGenerarRecibo(MouseEvent event) throws IOException {
    	FXMLLoader optionsFxml = new FXMLLoader(getClass().getResource("Menu2.fxml"));
		optionsFxml.setController(this);
		Parent opWindow = optionsFxml.load();
		Stage stage= (Stage) PaneGenerateRecibo.getScene().getWindow();
		stage.setScene(new Scene(opWindow));
    }
    @FXML
    public void homeStudentsList(MouseEvent event) throws IOException {
    	FXMLLoader optionsFxml = new FXMLLoader(getClass().getResource("Menu2.fxml"));
		optionsFxml.setController(this);
		Parent opWindow = optionsFxml.load();
		Stage stage= (Stage) tableViewStudentsList.getScene().getWindow();
		stage.setScene(new Scene(opWindow));
    }

    @FXML
    public void homeUpdateDojo(MouseEvent event) throws IOException {
    	FXMLLoader optionsFxml = new FXMLLoader(getClass().getResource("Menu2.fxml"));
		optionsFxml.setController(this);
		Parent opWindow = optionsFxml.load();
		Stage stage= (Stage) PaneUpdateDojo.getScene().getWindow();
		stage.setScene(new Scene(opWindow));
    }
    @FXML
    public void homeUpdateStudent(MouseEvent event) throws IOException {
    	FXMLLoader optionsFxml = new FXMLLoader(getClass().getResource("Menu2.fxml"));
		optionsFxml.setController(this);
		Parent opWindow = optionsFxml.load();
		Stage stage= (Stage) PaneUpdateStudent.getScene().getWindow();
		stage.setScene(new Scene(opWindow));;
    }


// OptionsWindow fxml

    //@FXML
    //private Pane PaneOptionsWindow;


    @FXML

    private BorderPane PaneOptionsWindow;


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
    private CheckBox masculino;

    @FXML
    private CheckBox femenino;

    @FXML
    private CheckBox otrosexo;

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

    List<File> selectedFiles=new ArrayList<>();
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


@FXML
    private AnchorPane PaneGenerateRecibo;

    @FXML
    private Label reciboNombreEstudiante;

    @FXML
    private TextField txtAcudienteName;

    @FXML
    private TextField txtConceptoRecibo;

    @FXML
    private TextField txtDiferenciableArchivo;

    @FXML
    private TextField txtEmailDestino;

    @FXML
    private TextField txtEmailMadre;

    @FXML
    private TextArea txtEmailMessage;

    @FXML
    private TextField txtEmailPadre;

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
 		Dialog<String> dialog = new Dialog<>();
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
    void openLoginScreen(MouseEvent event) throws IOException {
		FXMLLoader login = new FXMLLoader(getClass().getResource("Login2.fxml"));
		login.setController(this);
		Parent rootLogin = login.load();
		Stage stage= (Stage) MenuLabel.getScene().getWindow();
		stage.setScene(new Scene(rootLogin));
		txtLoginUsername.getScene().getWindow().setWidth(705);
		txtLoginUsername.getScene().getWindow().setHeight(460);
    }

    @FXML
    void openUpdateDojo(MouseEvent event) throws IOException {
		FXMLLoader login = new FXMLLoader(getClass().getResource("UpdateDojo.fxml"));
		login.setController(this);
		Parent rootLogin = login.load();
		Stage stage= (Stage) MenuLabel.getScene().getWindow();
		stage.setScene(new Scene(rootLogin));

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
		txtUpdateDojoAdress.getScene().getWindow().setHeight(515);
    }

    @FXML
    void openCreateStudent(MouseEvent event) throws IOException {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("CreateStudent.fxml"));
		fxml.setController(this);
		Parent root= fxml.load();
		Stage stage= (Stage) MenuLabel.getScene().getWindow();
		stage.setScene(new Scene(root));
		LabelRutaFoto.getScene().getWindow().setWidth(610);
		LabelRutaFoto.getScene().getWindow().setHeight(685);
		filesOfStudent.clear();

    }

    @FXML
    void openDeleteStudent(MouseEvent event) throws IOException {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("DeleteStudent2.fxml"));
		fxml.setController(this);
		Parent root= fxml.load();
		Stage stage= (Stage) MenuLabel.getScene().getWindow();
		stage.setScene(new Scene(root));

		txtDeleteStudentId.getScene().getWindow().setWidth(705);
		txtDeleteStudentId.getScene().getWindow().setHeight(460);

    }
    @FXML
    private Label MenuLabel;
    
    @FXML
    void openStudentsList(MouseEvent event) throws IOException {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("StudentsList.fxml"));
		fxml.setController(this);
		Parent root= fxml.load();
		Stage stage= (Stage) MenuLabel.getScene().getWindow();
		stage.setScene(new Scene(root));

		tableViewStudentsList.getScene().getWindow().setWidth(800);
		tableViewStudentsList.getScene().getWindow().setHeight(520);
		initializeStudentTableView();
    }

    @FXML //This method will be used when button generateRecibo in updateStudent is clicked, The screen GenerateRecibo does the process to send email
    public void openGenerateRecibo(ActionEvent event) throws IOException {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("CreateReciboResponsive.fxml"));
		fxml.setController(this);
		Parent root= fxml.load();
		Stage stage= (Stage) PaneUpdateStudent.getScene().getWindow();
		stage.setScene(new Scene(root));
		PaneGenerateRecibo.getScene().getWindow().setWidth(1200);
		PaneGenerateRecibo.getScene().getWindow().setHeight(800);


    	Student student=dojo.findStudent(txtUpdateStudentId.getText());
    	txtEmailMadre.setText(student.getMotherEmail());
    	txtEmailPadre.setText(student.getFatherEmail());
    	txtAcudienteName.setText(student.getMotherName());
    	txtEmailDestino.setText(student.getMotherEmail());

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
				FXMLLoader optionsFxml = new FXMLLoader(getClass().getResource("Menu2.fxml"));
				optionsFxml.setController(this);
				Parent opWindow = optionsFxml.load();
				Stage stage= (Stage) mainPaneLogin.getScene().getWindow();
				stage.setScene(new Scene(opWindow));


    		}

    		else {
    			Dialog<String> dialog = createDialog();
    			dialog.setTitle("Error, datos incorrectos");
    			dialog.setContentText("El nombre de usuario o contrase�a son incorrectos");
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

        	fotoLogo = com.itextpdf.text.Image.getInstance("src/icons/CHUUGI JKA.jpg");
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

        Paragraph parrafoAviso = new Paragraph("Los pagos se recibir�n los cinco primeros d�as del mes seg�n lo acordado"
        		+ " en el Reglamento Interno, despu�s del quinto d�a tendr� un sobrecosto del 10%");
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
    		dialog.setContentText("Debe elegir una foto de su computador previamente en el boton buscar Foto y luego si a�adirla");
    		dialog.show();
    	}
    }

    @FXML
    void addFileToStudent(ActionEvent event) {
    	if(!LabelRutaArchivos.getText().equals("")) {
    		filesOfStudent.add(LabelRutaArchivos.getText());

    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Archivo A�adido");
    		dialog.setContentText("El archivo "+LabelRutaArchivos.getText()+" ha sido a�adido a la lista de archivos del estudiante");
    		dialog.show();

    		LabelRutaArchivos.setText("");
    	}
    	else {
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error, archivo requerido");
    		dialog.setContentText("Debe escoger alg�n archivo para a�adirlo a los archivos del estudiante ");
    		dialog.show();
    	}
    }

	@FXML
    void createStudent(ActionEvent event) throws BadElementException, MalformedURLException, IOException {
    	String name= txtStudentName.getText();
    	String rh=txtStudentRH.getText();
    	String sex=getSexType();
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
    	List<String> filesPath= new ArrayList<>();
    	double valueMensualidad=0;

    	if(!selectedFiles.isEmpty()) {
    		for(int i=0;i<selectedFiles.size();i++) {
        		filesPath.add(selectedFiles.get(i).getAbsolutePath());
    		}
    	}

    	try {//Intente si se escogi� una fecha
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
    						try {
    							dojo.createStudent(name,rh, sex, bornDate, bornPlace, id, profilePicture, idType, eps,
    									ocupation, fatherName, fatherPhone, fatherEmail, motherName, motherPhone,
    									motherEmail, adress, neighborhood, registerDate, valueMensualidad, planPagoEntreno,
    									trainDays, scheduleDays, observations, authorization,filesDescription, filesPath);
    							saveDojoData();
    						}
    						catch(Exception e) {
    							Dialog<String> dialog = createDialog();
    							dialog.setTitle("Ha ocurrido un error");
    							dialog.setContentText("No ha sido posible crear el estudiante");
    						}

    						selectedFiles= new ArrayList<>();
    					}
    					else {
            				Dialog<String> dialog = createDialog();
                			dialog.setTitle("Error, la informacion de salud es necesaria");
                			dialog.setContentText("Recuerde que la infromacion de eps, rh y sexo"
                					+ " son necesarias para crear el estudiante");
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
    			dialog.setTitle("Error, la identificaci�n es necesaria");
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
    		dialog.setContentText("No se ha encontrado el directorio "+dojo.getPathStudentFiles()+"\\"+txtStudentName.getText()+txtStudentId.getText()+" para poder a�adir el pdf");
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
    		dialog.setContentText("No se ha encontrado el directorio "+dojo.getPathStudentFiles()+"\\"+txtStudentName.getText()+txtStudentId.getText()+" para poder a�adir la constancia de matricula");
    		dialog.show();
    	}
    }

    public void addMatriculaFormat(Document document, String imageRuta, String studentId) throws DocumentException {
    	com.itextpdf.text.Image fotoLogo=null;
    	com.itextpdf.text.Image fotoPerfil=null;
    	com.itextpdf.text.Image marcaAgua=null;


        try
        {
        	fotoPerfil = com.itextpdf.text.Image.getInstance(imageRuta);
        	fotoPerfil.scaleToFit(100, 100);
        	fotoPerfil.setAlignment(Element.ALIGN_RIGHT);

        	fotoLogo = com.itextpdf.text.Image.getInstance("src/icons/CHUUGI JKA.jpg");
        	fotoLogo.scaleToFit(200, 200);
        	fotoLogo.setAlignment(Element.ALIGN_LEFT);

        	marcaAgua = com.itextpdf.text.Image.getInstance("icons/icons/waterMark.png");
        	marcaAgua.scaleToFit(200, 200);
        	marcaAgua.setAlignment(Element.ALIGN_LEFT);

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

        	marcaAgua.setAbsolutePosition(80f, 220f);
        	marcaAgua.scaleToFit(500, 500);
        	document.add(marcaAgua);
        }

        //document.add(new Paragraph("\n\n"));

        Student student=dojo.findStudent(studentId);

        float [] pointColumnWidths = {105F, 200F};
        PdfPTable tableConstancia = new PdfPTable(pointColumnWidths);
        tableConstancia.setWidthPercentage(85);
        tableConstancia.addCell(getCellBorder("PRACTICANTE", Element.ALIGN_CENTER)).setExtraParagraphSpace(3);
        tableConstancia.addCell(getCellBorder(student.getName(), Element.ALIGN_LEFT)).setIndent(5);
        tableConstancia.addCell(getCellBorder("FECHA DE NACIMIENTO", Element.ALIGN_CENTER)).setExtraParagraphSpace(3);
        tableConstancia.addCell(getCellBorder(student.getBornDate(), Element.ALIGN_LEFT)).setIndent(5);
        tableConstancia.addCell(getCellBorder("LUGAR DE NACIMIENTO", Element.ALIGN_CENTER)).setExtraParagraphSpace(3);
        tableConstancia.addCell(getCellBorder(student.getBornPlace(), Element.ALIGN_LEFT)).setIndent(5);
        tableConstancia.addCell(getCellBorder("DOCUMENTO", Element.ALIGN_CENTER)).setExtraParagraphSpace(3);
        tableConstancia.addCell(getCellBorder(student.getIdType()+":"+student.getId(), Element.ALIGN_LEFT)).setIndent(5);
        tableConstancia.addCell(getCellBorder("SALUD", Element.ALIGN_CENTER)).setMinimumHeight(40);
        tableConstancia.addCell(getCellBorder("ENTIDAD: "+student.getEps()+"\n"+"RH: "+student.getRH()+"\n"+"SEXO: "+student.getSex()+"\n", Element.ALIGN_LEFT)).setIndent(5);
        tableConstancia.addCell(getCellBorder("OCUPACION", Element.ALIGN_CENTER)).setExtraParagraphSpace(3);
        tableConstancia.addCell(getCellBorder(student.getOcupation(), Element.ALIGN_LEFT)).setIndent(5);

        tableConstancia.addCell(getCellBorder("DATOS DEL PADRE", Element.ALIGN_CENTER)).setMinimumHeight(40);
        tableConstancia.addCell(getCellBorder("NOMBRE: "+student.getFatherName()+"\n"+"TELEFONO: "+student.getFatherPhone()+"\n"+"EMAIL: "+student.getFatherEmail()+"\n", Element.ALIGN_LEFT)).setIndent(5);

        tableConstancia.addCell(getCellBorder("DATOS DE LA MADRE", Element.ALIGN_CENTER)).setMinimumHeight(40);
        tableConstancia.addCell(getCellBorder("NOMBRE: "+student.getMotherName()+"\n"+"TELEFONO: "+student.getMotherPhone()+"\n"+"EMAIL: "+student.getMotherEmail()+"\n", Element.ALIGN_LEFT)).setIndent(5);

        tableConstancia.addCell(getCellBorder("DIRECCION", Element.ALIGN_CENTER)).setExtraParagraphSpace(3);
        tableConstancia.addCell(getCellBorder(student.getAdress(), Element.ALIGN_LEFT)).setIndent(5);
        tableConstancia.addCell(getCellBorder("BARRIO:", Element.ALIGN_CENTER)).setExtraParagraphSpace(3);
        tableConstancia.addCell(getCellBorder(student.getNeighborhood(), Element.ALIGN_LEFT)).setIndent(5);
        tableConstancia.addCell(getCellBorder("FECHA DE INGRESO", Element.ALIGN_CENTER)).setExtraParagraphSpace(3);
        tableConstancia.addCell(getCellBorder(student.getRegisterDate(), Element.ALIGN_LEFT)).setIndent(5);
        tableConstancia.addCell(getCellBorder("VALOR MENSUALIDAD", Element.ALIGN_CENTER)).setExtraParagraphSpace(3);
        tableConstancia.addCell(getCellBorder(String.valueOf(student.getValueMensualidad()), Element.ALIGN_LEFT)).setIndent(5);
        tableConstancia.addCell(getCellBorder("PLAN PAGO ENTRENO", Element.ALIGN_CENTER)).setExtraParagraphSpace(3);
        tableConstancia.addCell(getCellBorder(student.getPlanPagoEntreno(), Element.ALIGN_LEFT)).setIndent(5);
        tableConstancia.addCell(getCellBorder("DIAS DE ENTRENO", Element.ALIGN_CENTER)).setExtraParagraphSpace(3);
        tableConstancia.addCell(getCellBorder(String.valueOf(student.getTrainDays()), Element.ALIGN_LEFT)).setIndent(5);
        tableConstancia.addCell(getCellBorder("HORARIOS DE ENTRENO", Element.ALIGN_CENTER)).setExtraParagraphSpace(3);
        tableConstancia.addCell(getCellBorder(String.valueOf(student.getScheduleDays()), Element.ALIGN_LEFT)).setIndent(5);
        tableConstancia.addCell(getCellBorder("OBSERVACIONES", Element.ALIGN_CENTER)).setExtraParagraphSpace(3);
        tableConstancia.addCell(getCellBorder(student.getObservations(), Element.ALIGN_LEFT)).setIndent(5);
        tableConstancia.addCell(getCellBorder("AUTORIZO USO DE IMAGEN Y PUBLICACION EN REDES", Element.ALIGN_CENTER)).setExtraParagraphSpace(3);
        tableConstancia.addCell(getCellBorder(String.valueOf(student.isAuthorization()), Element.ALIGN_LEFT)).setIndent(5);
        tableConstancia.addCell(getCellBorder("ARCHIVOS ADJUNTOS", Element.ALIGN_CENTER)).setExtraParagraphSpace(3);
        PdfPCell cell= new PdfPCell(getCellBorder(student.getFilesDescription(), Element.ALIGN_LEFT));
        cell.setIndent(5);cell.setExtraParagraphSpace(3);
        tableConstancia.addCell(cell);
        tableConstancia.addCell(getCellBorder("ACUDIENTE RESPONSABLE", Element.ALIGN_CENTER)).setMinimumHeight(60);
        tableConstancia.addCell(getCellBorder("NOMBRE:___________________\n"+" CEDULA:___________________\n\n"+"    FIRMA:___________________", Element.ALIGN_LEFT)).setIndent(5);
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
        selectedFiles= fc.showOpenMultipleDialog(null);

        if(!selectedFiles.isEmpty()) {
        	for (File selectedFile : selectedFiles) {
        		txtStudentAddedFiles.setText(txtStudentAddedFiles.getText()+"\n"+selectedFile.getName());
        	}
        }
    }


    public String getIdType() {
    	String idType="";
    	if(cedula.isSelected()) {
    		idType="CC";
    	}
    	else if(tarjetaIdentidad.isSelected()) {
    		idType="TI";
    	}
		return idType;

    }

    public String getSexType() {
    	String sex="";
    	if(masculino.isSelected()) {
    		sex="MASCULINO";
    	}
    	else if(femenino.isSelected()) {
    		sex="FEMENINO";
    	}
    	else {
    		sex="OTRO";
    	}
    	return sex;
    }
    public String getPlanPago() {
    	String plan="";
    	if(mensualidad.isSelected()) {
    		plan="Mensualidad";
    	}
    	else if(horaEntrenada.isSelected()){
    		plan="Hora Entrenada";
    	}

    	return plan;
    }
    public List<String> getTrainDays(){
    	List<String> trainDays=new ArrayList<>();
    	if(lunes.isSelected()) {
    		trainDays.add("lunes");
    	}
    	if(martes.isSelected()) {
    		trainDays.add("martes");
    	}
    	if(miercoles.isSelected()) {
    		trainDays.add("miercoles");
    	}
    	if(jueves.isSelected()) {
    		trainDays.add("jueves");
    	}
    	if(viernes.isSelected()) {
    		trainDays.add("viernes");
    	}
    	if(sabado.isSelected()) {
    		trainDays.add("sabado");
    	}

    	return trainDays;
    }
    public List<String> getScheduleDays(){
    	List<String> trainDays=new ArrayList<>();

    	if(twoToThree.isSelected()) {
    		trainDays.add("2-3");
    	}
    	if(fiveToSix.isSelected()) {
    		trainDays.add("5-6");
    	}
    	if(sevenToEight.isSelected()) {
    		trainDays.add("7-8");
    	}
    	if(sixToSeven.isSelected()) {
    		trainDays.add("6-7");
    	}

    	return trainDays;
    }
    public boolean getAuthorization() {
    	boolean aut=false;
    	if(si.isSelected()) {
    		aut=true;
    	}
    	else if(no.isSelected()) {
    		aut=false;
    	}
    	return aut;
    }

 @FXML
 private TextField filterField;

  //Method to initialize the values in Clients Tableview in user screen
  	public void initializeStudentTableView() {
  		 ObservableList<Student> studentsList = FXCollections.observableArrayList(dojo.getStudents());

  		columnName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
  		columnId.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
  		columnMensualidad.setCellValueFactory(new PropertyValueFactory<Student, String>("valueMensualidad"));
  		columnAuthorization.setCellValueFactory(new PropertyValueFactory<Student, String>("authorization"));
  		columnBornDate.setCellValueFactory(new PropertyValueFactory<Student, String>("bornDate"));
  		columnRegisterDate.setCellValueFactory(new PropertyValueFactory<Student, String>("registerDate"));

  		//PARA EL TEXTFIELD DE BUSCAR ALUMNO POR NOMBRE
  		FilteredList<Student> filteredData= new FilteredList<>(studentsList, b -> true);

  		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
  			filteredData.setPredicate(student ->{
  				//If filter text is empty, display all people.
  				if(newValue==null || newValue.isEmpty()) {
  					System.out.println("INICIALIZO");
  					return true;
  				}

  				//Compare first name and last name of every person with filter text
  				String lowerCaseFilter= newValue.toLowerCase();

  				if(student.getName().toLowerCase().indexOf(lowerCaseFilter) !=-1) {
  					System.out.println("MATCHES");
  					return true;//filter matches first name
  				}else {
  					System.out.println("DOES NOT MATCH");
  					return false;
  				}



  			});
  		});

  		//Wrap the filtered list in a sortedList
  		SortedList<Student> sortedData= new SortedList<>(filteredData);

  		sortedData.comparatorProperty().bind(tableViewStudentsList.comparatorProperty());
  		tableViewStudentsList.setItems(sortedData);


  		//PARA CUANDO SE LE DE DOBLE CLICK A UN ESTUDIANTE DE LA LISTA
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

  						if(student.getIdType().equals("TI")) {
  							updateTarjetaIdentidad.setSelected(true);
  						}
  						else {
  							updateCedula.setSelected(true);
  						}

  						if(student.getSex().equalsIgnoreCase("MASCULINO")) {
  							txtUpdateStudentSex.setText("MASCULINO");
  						}
  						else if(student.getSex().equalsIgnoreCase("FEMENINO")){
  							txtUpdateStudentSex.setText("FEMENINO");
  						}
  						else {
  							txtUpdateStudentSex.setText("OTRO");
  						}

  						txtUpdateStudentEPS.setText(student.getEps());
  						txtUpdateStudentRH.setText(student.getRH());
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

  						if(student.getPlanPagoEntreno().equals("Mensualidad")) {
  							updateMensualidad.setSelected(true);
  						}
  						else {
  							updateHoraEntrenada.setSelected(true);
  						}
  						List<String> trainDays= student.getTrainDays();
  						for (String trainDay : trainDays) {
  							if(trainDay.equals("lunes")) {
  								updateLunes.setSelected(true);
  							}
  							else if(trainDay.equals("martes")) {
  								updateMartes.setSelected(true);
  							}
  							else if(trainDay.equals("miercoles")) {
  								updateMiercoles.setSelected(true);
  							}
  							else if(trainDay.equals("jueves")) {
  								updateJueves.setSelected(true);
  							}
  							else if(trainDay.equals("viernes")) {
  								updateViernes.setSelected(true);
  							}
  							else if(trainDay.equals("sabado")) {
  								updateSabado.setSelected(true);
  							}
  						}
  						List<String> scheduleDays= student.getScheduleDays();
  						for (String scheduleDay : scheduleDays) {
  							if(scheduleDay.equals("2-3")) {
  								updateTwoToThree.setSelected(true);
  							}
  							else if(scheduleDay.equals("5-6")) {
  								updateFiveToSix.setSelected(true);
  							}
  							else if(scheduleDay.equals("6-7")) {
  								updateSixToSeven.setSelected(true);
  							}
  							else if(scheduleDay.equals("7-8")) {
  								updateSevenToEight.setSelected(true);
  							}
  						}
  						txtUpdateObservations.setText(student.getObservations());

  						if(student.isAuthorization()) {
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

    	if(mensualidadCorrecta) {
    		student.setAdress(txtUpdateStudentAdress.getText());
    		student.setAuthorization(getUpdateAuthorization());
    		student.setEps(txtUpdateStudentEPS.getText());
    		student.setFatherPhone(txtUpdateStudentFatherPhone.getText());
    		student.setFatherEmail(txtUpdateStudentFatherEmail.getText());

    		List<String> existingFilesPath= student.getFilesPath();
    		for (int i=0;i<selectedFiles.size();i++) {
    			existingFilesPath.add(selectedFiles.get(i).getAbsolutePath());
    		}
    		student.setFilesPath(existingFilesPath);
    		student.setFilesDescription(txtUpdateStudentAddedFiles.getText());
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

			for (File selectedFile : selectedFiles) {
				dojo.fileCopy(selectedFile.getAbsolutePath(), (directorio.getAbsolutePath()));
			}

			selectedFiles=new ArrayList<>();

			try {
				saveDojoData();
			} catch (IOException e) {
	    		Dialog<String> dialog = createDialog();
	    		dialog.setTitle("La informaci�n no se pudo guardada");
	    		dialog.setContentText("Imposible guardar la nueva informacion del estudiante");
	    		dialog.show();
			}
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Informacion actualizada");
    		dialog.setContentText("Se ha actualizado satisfactoriamente la informaci�n del estudiante");
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
        selectedFiles= fc.showOpenMultipleDialog(null);

        if(!selectedFiles.isEmpty()) {
        	for (File selectedFile : selectedFiles) {
        		txtUpdateStudentAddedFiles.setText(txtUpdateStudentAddedFiles.getText()+"\n"+selectedFile.getName());
        	}
        }
    }

    public String getUpdateIdType() {
    	String idType="";
    	if(updateCedula.isSelected()) {
    		idType="CC";
    	}
    	else if(updateTarjetaIdentidad.isSelected()) {
    		idType="TI";
    	}
		return idType;

    }
    public String getUpdatePlanPago() {
    	String plan="";
    	if(updateMensualidad.isSelected()) {
    		plan="Mensualidad";
    	}
    	else if(updateHoraEntrenada.isSelected()){
    		plan="Hora Entrenada";
    	}

    	return plan;
    }
    public List<String> getUpdateTrainDays(){
    	List<String> trainDays=new ArrayList<>();
    	if(updateLunes.isSelected()) {
    		trainDays.add("lunes");
    	}
    	if(updateMartes.isSelected()) {
    		trainDays.add("martes");
    	}
    	if(updateMiercoles.isSelected()) {
    		trainDays.add("miercoles");
    	}
    	if(updateJueves.isSelected()) {
    		trainDays.add("jueves");
    	}
    	if(updateViernes.isSelected()) {
    		trainDays.add("viernes");
    	}
    	if(updateSabado.isSelected()) {
    		trainDays.add("sabado");
    	}

    	return trainDays;
    }
    public List<String> getUpdateScheduleDays(){
    	List<String> trainDays=new ArrayList<>();

    	if(updateTwoToThree.isSelected()) {
    		trainDays.add("2-3");
    	}
    	if(updateFiveToSix.isSelected()) {
    		trainDays.add("5-6");
    	}
    	if(updateSevenToEight.isSelected()) {
    		trainDays.add("7-8");
    	}
    	if(updateSixToSeven.isSelected()) {
    		trainDays.add("6-7");
    	}

    	return trainDays;
    }
    public boolean getUpdateAuthorization() {
    	boolean aut=false;
    	if(updateSi.isSelected()) {
    		aut=true;
    	}
    	else if(updateNo.isSelected()) {
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
    		dialog.setContentText("Debe ingresar la identificaci�n del estudiante a eliminar");
    		dialog.show();
    	}
    }
    @FXML
    public void createRecibo(ActionEvent event){
    	FileOutputStream archivo = null;
		try {
			archivo = new FileOutputStream(dojo.getPathReportes()+"\\"+studentFactura.getName()+" "+studentFactura.getId()+" "+fecha+" "+txtDiferenciableArchivo.getText()+" "+"Recibo.pdf");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error con la ruta");
    		dialog.setContentText("Ruta no encontrada "+dojo.getPathReportes()+"\\"+studentFactura.getName()+" "+studentFactura.getId()+" "+fecha+" "+txtDiferenciableArchivo.getText()+" "+"Recibo.pdf");
    		dialog.show();
		}
    	FileOutputStream archivoCarpetaEstudiante = null;
		try {
			archivoCarpetaEstudiante = new FileOutputStream(dojo.getPathStudentFiles()+"\\"+studentFactura.getName()+studentFactura.getId()+"\\"+fecha+" "+txtDiferenciableArchivo.getText()+" "+"Recibo.pdf");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
    		Dialog<String> dialog = createDialog();
    		dialog.setResizable(true);
    		dialog.setTitle("Error con la ruta");
    		dialog.setContentText("Ruta no encontrada "+dojo.getPathStudentFiles()+"\\"+studentFactura.getName()+studentFactura.getId()+"\\"+fecha+" "+txtDiferenciableArchivo.getText()+" "+"Recibo.pdf");
    		dialog.show();
		}

    	Document document= new Document();
    	Document document2= new Document();

    	try {//
    		if(archivo!=null & archivoCarpetaEstudiante!=null) {
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
    		}else {
        		Dialog<String> dialog = createDialog();
        		dialog.setTitle("Error con los archivos");
        		dialog.setContentText("Ocurrio algun error con las carpetas de recibos o de estudiantes y el pdf no pudo ser creado");
        		dialog.show();
    		}

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
    public void generateReciboEmail(ActionEvent event) {

    	Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");// a que servidor nos vamos a conectar, en este caso gmail
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");//puerto por el que nos vamos a conectar (el puerto que nos da gmail es el 587)
        propiedad.setProperty("mail.smpt.auth", "true");
        //propiedad.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        propiedad.put("mail.smtp.ssl.trust", "*");
        propiedad.put("mail.smtp.starttls.enable", "true");
        propiedad.put("mail.smtp.ssl.protocols", "TLSv1.2");

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
    		dialog.setContentText("El recibo ha sido enviado al correo "+receptor);
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
    		Dialog<String> dialog2 = createDialog();
    		dialog2.setResizable(true);
    		dialog2.setTitle("Error, correo no ha podido ser enviado");
    		dialog2.setContentText(ex.toString());
    		dialog2.show();
        }

    }


    @FXML
    void updateDojo(ActionEvent event) throws MessagingException {
    	dojo.setAdress(txtUpdateDojoAdress.getText());
    	dojo.setCeo(txtUpdateDojoCEO.getText());
    	dojo.setEmail(txtUpdateDojoEmail.getText());
    	dojo.setNit(txtUpdateDojoNIT.getText());
    	dojo.setPhone(txtUpdateDojoPhone.getText());
    	dojo.setEmailEnvio(txtUpdateDojoEmailEnvio.getText());
    	dojo.setPathStudentFiles(txtUpdateDojoPathStudents.getText());
    	dojo.setPathReportes(txtUpdateDojoPathRecibos.getText());
    	dojo.setSAVE_PATH_FILE_EXCEL(txtRutaArchivoExcel.getText());

    	if(!txtUpdateDojoEmailClave.getText().equals("")) {//SI EL TEXTFIELD DE CONTRASENA TIENE ALGO
    		 Transport transport;
    		 try {// EN ESTE TRY SE HACE LA VALIDACION DEL CORREO ELECTRONICO Y CONSTRASENA
    			 Properties propiedad = new Properties();
    			 propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");// a que servidor nos vamos a conectar, en este caso gmail
    			 propiedad.setProperty("mail.smtp.starttls.enable", "true");
    			 propiedad.setProperty("mail.smtp.port", "587");//puerto por el que nos vamos a conectar (el puerto que nos da gmail es el 587)
    			 propiedad.setProperty("mail.smpt.auth", "true");
    			 //propiedad.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    			 propiedad.put("mail.smtp.ssl.trust", "*");
    			 propiedad.put("mail.smtp.starttls.enable", "true");
    			 propiedad.put("mail.smtp.ssl.protocols", "TLSv1.2");

    			 Session sesion = Session.getDefaultInstance(propiedad);
    			 transport = sesion.getTransport("smtp");
    			 transport.connect("smtp.gmail.com", txtUpdateDojoEmailEnvio.getText(), txtUpdateDojoEmailClave.getText());
    			 transport.close();

    			 //SI TODOS LOS DATOS ESTAN BIEN Y EL CORREO TAMBIEN LOS DATOS DEL DOJO SE ACTUALIZAN
    			 try {
    				 saveDojoData();
    				 Dialog<String> dialog = createDialog();
    				 dialog.setTitle("Datos del dojo actualizados");
    				 dialog.setContentText("Los datos del dojo han sido actualizados satisfactoriamente y el correo electronico y constrasena son validos");
    				 dialog.show();
    			 } catch (IOException e) {
    				 e.printStackTrace();
    				 Dialog<String> dialog = createDialog();
    				 dialog.setTitle("Error, al guardar datos del dojo");
    				 dialog.setContentText("Los datos del dojo no se pudieron serializar");
    				 dialog.show();
    			 }

    			 //Authentication success
    		 } catch (AuthenticationFailedException e) {
    			 	Dialog<String> dialog = createDialog();
    	       		dialog.setTitle("E-mail y contrasena invalidos");
    	       		dialog.setContentText("El e-mail y la contrasena estan incorrectos, la conexion fue imposible de lograr, DESCRIPCION DEL ERROR: "+ e.getLocalizedMessage());
    	       		dialog.show();
    		 }

    	}

    }

    @FXML
    public void exportStudentsData(MouseEvent event) throws FileNotFoundException {
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

    	for (Student student : dojo.getStudents()) {
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


