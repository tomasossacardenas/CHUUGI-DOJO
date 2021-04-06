package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.util.Callback;

public class Dojo implements Serializable {
	private static final long serialVersionUID = 1;
	//atributes
	private String adress;
	private String nit;
	private String ceo;
	private String email;
	private String phone;
	private String emailEnvio;
	private String claveEmail;
	//Relations
	private User usuario;
	private List<Student> students;
	
	public final static String SAVE_PATH_FILE_STUDENTS="data/students.ap2";
	public final static String SAVE_PATH_FILE_USER="data/user.ap2";
	

	public Dojo(String adress, String nit, String ceo, String email, String phone, String emailEnvio, String clave) {
		this.adress = adress;
		this.nit = nit;
		this.ceo = ceo;
		this.email = email;
		this.phone = phone;
		this.emailEnvio=emailEnvio;
		this.claveEmail=clave;
		usuario= new User("ADMINISTRADOR", "123");
		students= new ArrayList<>();
	}
	

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailEnvio() {
		return emailEnvio;
	}

	public void setEmailEnvio(String emailEnvio) {
		this.emailEnvio = emailEnvio;
	}

	public String getClaveEmail() {
		return claveEmail;
	}

	public void setClaveEmail(String claveEmail) {
		this.claveEmail = claveEmail;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	public Dialog<String> createDialog() {
		Dialog<String> dialog = new Dialog<String>();
		ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(type);
		return dialog;
	}
	
	public void fileCopy(String sourceFile, String destinationFile) {
		Path origenPath = FileSystems.getDefault().getPath(sourceFile);
        Path destinoPath = FileSystems.getDefault().getPath(destinationFile);
        
        try {
        	Path copiar= Files.copy(origenPath, destinoPath.resolve(origenPath.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        	System.out.println("SE COPIO A LA DIRECCION "+destinoPath);
        }catch(IOException e) {
        	
        }

    }
	
	public void createStudent(String name,String rh, String sex,  String bornDate, String bornPlace, String id, String profilePicture, String idType,
			String eps, String ocupation, String fatherName, String fatherPhone, String fatherEmail, String motherName,
			String motherPhone, String motherEmail, String adress, String neighborhood, String registerDate,
			double valueMensualidad, String planPagoEntreno, List<String> trainDays, List<String> scheduleDays,
			String observations, boolean authorization,String filesDescription, List<String> filesPath) throws IOException {
		
		Student student= findStudent(id);
		
		
		if(student==null) {
			students.add(new Student(name,rh, sex, bornDate, bornPlace, id, profilePicture, idType, eps, ocupation, fatherName, fatherPhone, fatherEmail
					, motherName, motherPhone, motherEmail, adress, neighborhood, registerDate, valueMensualidad, planPagoEntreno, 
					trainDays, scheduleDays, observations, authorization,filesDescription,filesPath));
			
			File directorio = new File("data/"+name+id); //ADENTRO IRIA DONDE SE QUIERE CREAR EL DIRECTORIO
			directorio.mkdir();
			
			for(int i=0;i<filesPath.size();i++) {
				fileCopy(filesPath.get(i), (directorio.getAbsolutePath()));
			}
			
			saveStudentsData();
			
     		Dialog<String> dialog = createDialog();
     		dialog.setTitle("Estudiante creado");
     		dialog.setContentText("El estudiante ha sido creado satisfactoriamente");
     		dialog.show(); 
		}
		else {
			Dialog<String> dialog = createDialog();
			dialog.setTitle("Error, estudiante existente");
			dialog.setContentText("El usuario con la identificacion "+id+" ya existe.");
			dialog.show();
		}
	}
	
	public void deleteStudent(String id) throws IOException {
		Student student= findStudent(id);
		
		if(student!=null) {
			students.remove(student);
			saveStudentsData();
			Dialog<String> dialog = createDialog();
			dialog.setTitle("El estudiante ha sido eliminado");
			dialog.setContentText("El estudiante con la identificacion "+id+" ha sido eliminado del dojo.");
			dialog.show();
		}
		else {
			Dialog<String> dialog = createDialog();
			dialog.setTitle("Error, estudiante inexistente");
			dialog.setContentText("El estudiante con la identificacion "+id+" no existe.");
			dialog.show();
		}
	}

	public Student findStudent(String id) {
		boolean exit=false;
		Student student=null;
		for(int i=0;i<students.size() && exit==false;i++) {
			if(students.get(i).getId().equals(id)) {
				student=students.get(i);
				exit=true;
			}
		}
		return student;
	}
	
	 //Import students Data (serializacion)
	 @SuppressWarnings("unchecked")
	 public boolean loadStudentsData() throws IOException, ClassNotFoundException{
		 File f = new File(SAVE_PATH_FILE_STUDENTS);
		 boolean loaded = false;
		 if(f.exists()){
			 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			 students = (List<Student>)ois.readObject();
			 ois.close();
			 loaded = true;
		 }		 
		 return loaded;	
	 }

	 //Export students Data (serializacion)
	 public void saveStudentsData() throws IOException{
		 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_STUDENTS));
		 oos.writeObject(students);
		 oos.close();
	 }
	 
	 @SuppressWarnings("unchecked")
	 public boolean loadUserData() throws IOException, ClassNotFoundException{
		 File f = new File(SAVE_PATH_FILE_USER);
		 boolean loaded = false;
		 if(f.exists()){
			 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			 usuario = (User)ois.readObject();
			 ois.close();
			 loaded = true;
		 }		 
		 return loaded;	
	 }

	 //Export students Data (serializacion)
	 public void saveUserData() throws IOException{
		 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_USER));
		 oos.writeObject(usuario);
		 oos.close();
	 }

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}


	
}
