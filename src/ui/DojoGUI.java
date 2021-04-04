package ui;

import java.io.File;
import javafx.scene.image.Image;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

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
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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

//optionsWindow methods
    @FXML
    void openLoginScreen(ActionEvent event) throws IOException {
		FXMLLoader login = new FXMLLoader(getClass().getResource("Login.fxml"));
		login.setController(this);
		Parent rootLogin = login.load();
		OptionsWindow.getChildren().setAll(rootLogin);
		txtLoginUsername.getScene().getWindow().setWidth(610);
		txtLoginUsername.getScene().getWindow().setHeight(425);
    }
    
    @FXML
    void openCreateStudent(ActionEvent event) throws IOException {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("CreateStudent.fxml"));
		fxml.setController(this);
		Parent root= fxml.load();
		PaneOptionsWindow.getChildren().setAll(root);
		LabelRutaFoto.getScene().getWindow().setWidth(620);
		LabelRutaFoto.getScene().getWindow().setHeight(695);
		filesOfStudent.clear();
    }
   
    @FXML
    void openDeleteStudent(ActionEvent event) throws IOException {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("DeleteStudent.fxml"));
		fxml.setController(this);
		Parent root= fxml.load();
		PaneOptionsWindow.getChildren().setAll(root);
    }
    @FXML
    void openStudentsList(ActionEvent event) throws IOException {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("StudentsList.fxml"));
		fxml.setController(this);
		Parent root= fxml.load();
		PaneOptionsWindow.getChildren().setAll(root);
		
		initializeStudentTableView();
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
    
    @FXML
    public void generatePDF(ActionEvent event) throws FileNotFoundException {//method of the button createStudent its TEMPORAL
    	FileOutputStream archivo= new FileOutputStream("C:\\Users\\tomas\\eclipse-workspace\\jfx-ChuugiDojo\\Reportes\\"+txtStudentId.getText()+".pdf");
    	
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
    	com.itextpdf.text.Image fotoLogo=null;
   
        try
        {
        	
        	fotoLogo = com.itextpdf.text.Image.getInstance("C:\\Users\\tomas\\eclipse-workspace\\jfx-ChuugiDojo\\src\\icons\\CHUUGI JKA.jpg");
        	fotoLogo.scaleToFit(200, 200);
        	fotoLogo.setAlignment(Chunk.ALIGN_LEFT);
        	
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
        table.addCell(getCell(fotoLogo, PdfPCell.ALIGN_RIGHT));
        document.add(table);
        
        document.add(new Paragraph("\n\n\n\n"));
        
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
        tablePago.setWidthPercentage(70);
        tablePago.addCell(getCell(parrafoPago.getContent(), PdfPCell.ALIGN_CENTER));
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
    
    public static PdfPCell getCell(com.itextpdf.text.Image img, int alignment) {//configuracion de la celda de la imagen (derecha)
        PdfPCell cell = new PdfPCell();
        cell.addElement(img);
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
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

    @SuppressWarnings("unused")
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
    				dojo.createStudent(name,rh, sex, bornDate, bornPlace, id, profilePicture, idType, eps, 
    						ocupation, fatherName, fatherPhone, fatherEmail, motherName, motherPhone, 
    						motherEmail, adress, neighborhood, registerDate, valueMensualidad, planPagoEntreno, 
    						trainDays, scheduleDays, observations, authorization,filesDescription, filesPath);
    				System.out.println(dojo.findStudent(id).toString());
    				filesOfStudent.clear();
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

    @FXML
    public void generateCreatePDF(ActionEvent event){
    	
    	try {
    	FileOutputStream archivo= new FileOutputStream("C:\\Users\\tomas\\eclipse-workspace\\jfx-ChuugiDojo\\data\\"+txtStudentName.getText()+txtStudentId.getText()+"\\"+"constanciaMatricula"+".pdf");
    	
    	Document document= new Document();  
    	
    	try {//
			PdfWriter.getInstance(document, archivo);
			document.open();
			addMatriculaFormat(document);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
    	document.close();
    	}catch(FileNotFoundException e) {
    		Dialog<String> dialog = createDialog();
    		dialog.setTitle("Error, directorio no encontrado" );
    		dialog.setContentText("No se ha encontrado el directorio "+txtStudentName.getText()+txtStudentId.getText()+" para poder añadir la constancia de matricula");
    		dialog.show(); 
    	}
    }

    public void addMatriculaFormat(Document document) throws DocumentException {
    	com.itextpdf.text.Image fotoLogo=null;
    	com.itextpdf.text.Image fotoPerfil=null;
    	   
        try
        {
        	fotoLogo = com.itextpdf.text.Image.getInstance("C:\\Users\\tomas\\eclipse-workspace\\jfx-ChuugiDojo\\src\\icons\\CHUUGI JKA.jpg");
        	fotoLogo.scaleToFit(200, 200);
        	fotoLogo.setAlignment(Chunk.ALIGN_LEFT);

        	fotoPerfil = com.itextpdf.text.Image.getInstance(LabelRutaFoto.getText());
        	fotoPerfil.scaleToFit(100, 100);
        	fotoPerfil.setAlignment(Chunk.ALIGN_RIGHT);
        	
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
        	tableHeader.addCell(getCell(fotoLogo, PdfPCell.ALIGN_LEFT));
        	tableHeader.addCell(getCell(fotoPerfil, PdfPCell.ALIGN_RIGHT));
        	document.add(tableHeader);
        }
        
        document.add(new Paragraph("\n\n"));
        
        Student student=dojo.findStudent(txtStudentId.getText());
        
        PdfPTable tableConstancia = new PdfPTable(2);
        tableConstancia.setWidthPercentage(70);
        tableConstancia.addCell(getCellBorder("NOMBRE DEL ESTUDIANTE", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getName(), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("FECHA DE NACIMIENTO", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getBornDate(), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("LUGAR DE NACIMIENTO", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getBornPlace(), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("DOCUMENTO DE IDENTIDAD", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getIdType()+":"+student.getId(), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("SALUD", PdfPCell.ALIGN_CENTER)).setMinimumHeight(40);
        tableConstancia.addCell(getCellBorder("Entidad: "+student.getEps()+"\n"+"RH: "+student.getRH()+"\n"+"Sexo: "+student.getSex()+"\n", PdfPCell.ALIGN_LEFT)).setMinimumHeight(40);;
        tableConstancia.addCell(getCellBorder("OCUPACION", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getOcupation(), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("NOMBRE DEL PADRE", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getFatherName(), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("TELEFONO DEL PADRE", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getFatherPhone(), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("EMAIL DEL PADRE", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getFatherEmail(), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("NOMBRE DE LA MADRE", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getMotherName(), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("TELEFONO DE LA MADRE", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getMotherPhone(), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("EMAIL DE LA MADRE", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getMotherEmail(), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("DIRECCION", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getAdress(), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("BARRIO:", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getNeighborhood(), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("FECHA DE INGRESO", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getRegisterDate(), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("VALOR MENSUALIDAD", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(String.valueOf(student.getValueMensualidad()), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("PLAN PAGO ENTRENO", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getPlanPagoEntreno(), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("DIAS DE ENTRENO", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(String.valueOf(student.getTrainDays()), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("HORARIOS DE ENTRENO", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(String.valueOf(student.getScheduleDays()), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("OBSERVACIONES", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getObservations(), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("AUTORIZACION PARA EL USO DE SU IMAGEN EN PUBLICACIONES EN REDES SOCIALES:", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(String.valueOf(student.isAuthorization()), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("ARCHIVOS ADJUNTADOS", PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder(student.getFilesDescription(), PdfPCell.ALIGN_CENTER));
        tableConstancia.addCell(getCellBorder("ACUDIENTE RESPONSABLE", PdfPCell.ALIGN_MIDDLE)).setMinimumHeight(50);
        tableConstancia.addCell(getCellBorder("NOMBRE:___________________\n"+"CEDULA:___________________\n "+"FIRMA:___________________", PdfPCell.ALIGN_CENTER)).setMinimumHeight(50);
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
    private TableColumn<Student, String> columnFatherName;

    @FXML
    private TableColumn<Student, String> columnMotherName;
    
  //Method to initialize the values in Clients Tableview in user screen
  	public void initializeStudentTableView() {
  		
  		ObservableList<Student> studentsList = FXCollections.observableArrayList(dojo.getStudents());

  		columnName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
  		columnId.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
  		columnMensualidad.setCellValueFactory(new PropertyValueFactory<Student, String>("valueMensualidad"));
  		columnAuthorization.setCellValueFactory(new PropertyValueFactory<Student, String>("authorization"));
  		columnFatherName.setCellValueFactory(new PropertyValueFactory<Student, String>("fatherName"));
  		columnMotherName.setCellValueFactory(new PropertyValueFactory<Student, String>("motherName"));

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
  						
  			    		File file = new File(student.getProfilePicture());
  			    		Image img = new Image(file.toURI().toString());
  						updateProfilePicture.setImage(img);
  						txtUpdateStudentName.setText(student.getName());
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
    

    @FXML
    void updateAddFileToStudent(ActionEvent event) {

    }

    @FXML
    void updateGeneratePDF(ActionEvent event) {

    }

    @FXML
    void updateProfilePcture(ActionEvent event) {

    }

    @FXML
    void updateStudent(ActionEvent event) {

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

}


