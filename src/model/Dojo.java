package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;

public class Dojo {
	//Relations
	private User usuario;
	private List<Student> students;
	
	public final static String SAVE_PATH_FILE_STUDENTS="data/students.ap2";
	
	public Dojo() {
		usuario= new User("ADMINISTRADOR", "123");
		students= new ArrayList<>();
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
	
	public void createStudent(String name, String bornDate, String bornPlace, String id, Image profilePicture, String idType,
			String eps, String ocupation, String fatherName, String fatherPhone, String fatherEmail, String motherName,
			String motherPhone, String motherEmail, String adress, String neighborhood, String registerDate,
			double valueMensualidad, String planPagoEntreno, List<String> trainDays, List<String> scheduleDays,
			String observations, boolean authorization, List<String> filesPath) throws IOException {
		
		Student student= findStudent(id);
		
		if(student==null) {
			students.add(new Student(name, bornDate, bornPlace, id, profilePicture, idType, eps, ocupation, fatherName, fatherPhone, fatherEmail
					, motherName, motherPhone, motherEmail, adress, neighborhood, registerDate, valueMensualidad, planPagoEntreno, 
					trainDays, scheduleDays, observations, authorization, filesPath));
			
			saveStudentsData();
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
		}
		else {
			Dialog<String> dialog = createDialog();
			dialog.setTitle("Error, estudiante inexistente");
			dialog.setContentText("El usuario con la identificacion "+id+" no existe.");
			dialog.show();
		}
	}

	private Student findStudent(String id) {
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
	
	 //Import users types Data (serializacion)
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

	 //Export users types Data (serializacion)
	 public void saveStudentsData() throws IOException{
		 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_STUDENTS));
		 oos.writeObject(students);
		 oos.close();
	 }
	
}
