package model;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class Dojo implements Serializable {

	private static final long serialVersionUID = 1;
	//atributes
	private String save_path_file_excel;
	private String adress;
	private String nit;
	private String ceo;
	private String email;
	private String phone;
	private String emailEnvio;
	private String claveEmail;
	private String pathStudentFiles;
	private String pathReportes;
	//Relations
	private User usuario;
	private List<Student> students;



	public Dojo(String adress, String nit, String ceo, String email, String phone, String emailEnvio, String clave, String pathStudentFiles, String pathReportes, String pathExcel) {
		this.adress = adress;
		this.nit = nit;
		this.ceo = ceo;
		this.email = email;
		this.phone = phone;
		this.emailEnvio=emailEnvio;
		this.claveEmail=clave;
		this.pathStudentFiles=pathStudentFiles;
		this.save_path_file_excel=pathExcel;
		this.pathReportes=pathReportes;
		usuario= new User("ADMINISTRADOR", "123");
		students= new ArrayList<>();
	}


	public String getSAVE_PATH_FILE_EXCEL() {
		return save_path_file_excel;
	}


	public void setSAVE_PATH_FILE_EXCEL(String sAVE_PATH_FILE_EXCEL) {
		save_path_file_excel = sAVE_PATH_FILE_EXCEL;
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
		Dialog<String> dialog = new Dialog<>();
		ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(type);
		return dialog;
	}

	public void fileCopy(String sourceFile, String destinationFile) {
		Path origenPath = FileSystems.getDefault().getPath(sourceFile);
        Path destinoPath = FileSystems.getDefault().getPath(destinationFile);

        try {
        	Files.copy(origenPath, destinoPath.resolve(origenPath.getFileName()), StandardCopyOption.REPLACE_EXISTING);
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

			File directorio = new File(getPathStudentFiles()+"\\"+name+id); //ADENTRO IRIA DONDE SE QUIERE CREAR EL DIRECTORIO
			directorio.mkdir();

			if (!directorio.exists()) {
	            if (directorio.mkdirs()) {
	            	Dialog<String> dialog = createDialog();
        			dialog.setTitle("Carpeta del estudiante creada");
        			dialog.setContentText("La carpeta del estudiante ha sido creada "+directorio);
        			dialog.show();
	            } else {
	            	Dialog<String> dialog = createDialog();
        			dialog.setTitle("Error, carpeta del estudiante no fue creada");
        			dialog.setContentText("No ha sido posible crear la carpeta del estudiante porque puede que la ruta est� incorrecta o ya exista una carpeta con ese nombre, ruta Carpeta que fall�: "+directorio);
        			dialog.show();
	            }
	        }

			for (String element : filesPath) {
				fileCopy(element, (directorio.getAbsolutePath()));
			}


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
		for(int i=0;i<students.size() && !exit;i++) {
			if(students.get(i).getId().equals(id)) {
				student=students.get(i);
				exit=true;
			}
		}
		return student;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}


	public String getPathStudentFiles() {
		return pathStudentFiles;
	}


	public void setPathStudentFiles(String pathStudentFiles) {
		this.pathStudentFiles = pathStudentFiles;
	}


	public String getPathReportes() {
		return pathReportes;
	}


	public void setPathReportes(String pathReportes) {
		this.pathReportes = pathReportes;
	}


	public String getSave_path_file_excel() {
		return save_path_file_excel;
	}


	public void setSave_path_file_excel(String save_path_file_excel) {
		this.save_path_file_excel = save_path_file_excel;
	}



}
