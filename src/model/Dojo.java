package model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;

public class Dojo {
	//Relations
	private User usuario;
	private List<Student> students;
	
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
	
	public void createStudent(String name, String surnames, String id, String phoneContact, String payersName, String emailContact) {
		Student student= findStudent(id);
		
		if(student==null) {
			students.add(new Student(name, surnames, id, phoneContact, payersName, emailContact));
		}
		else {
			Dialog<String> dialog = createDialog();
			dialog.setTitle("Error, estudiante existente");
			dialog.setContentText("El usuario con la identificacion "+id+" ya existe.");
			dialog.show();
		}
	}
	
	public void deleteStudent(String id) {
		Student student= findStudent(id);
		
		if(student!=null) {
			students.remove(student);
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
	
}
