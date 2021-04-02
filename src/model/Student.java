package model;

import java.io.Serializable;
import java.util.List;

import javafx.scene.image.Image;

public class Student implements Serializable {
	//Constants	
	private static final long serialVersionUID = 1;
	//Attributes
	private String name;
	private String bornDate;
	private String bornPlace;
	private String id;
	private Image profilePicture;
	private String idType;
	private String eps;
	private String ocupation;
	private String fatherName;
	private String fatherPhone;
	private String fatherEmail;
	private String motherName;
	private String motherPhone;
	private String motherEmail;
	private String adress;
	private String neighborhood;
	private String registerDate;
	private double valueMensualidad;
	private String planPagoEntreno;
	private List<String> trainDays;
	private List<String> scheduleDays;
	private String observations;
	private boolean authorization;
	private List<String> filesPath;
	
	//Constructor
	public Student(String name, String bornDate, String bornPlace, String id, Image profilePicture, String idType,
			String eps, String ocupation, String fatherName, String fatherPhone, String fatherEmail, String motherName,
			String motherPhone, String motherEmail, String adress, String neighborhood, String registerDate,
			double valueMensualidad, String planPagoEntreno, List<String> trainDays, List<String> scheduleDays,
			String observations, boolean authorization, List<String> filesPath) {
		
		this.name = name;
		this.bornDate = bornDate;
		this.bornPlace = bornPlace;
		this.id = id;
		this.profilePicture = profilePicture;
		this.idType = idType;
		this.eps = eps;
		this.ocupation = ocupation;
		this.fatherName = fatherName;
		this.fatherPhone = fatherPhone;
		this.fatherEmail = fatherEmail;
		this.motherName = motherName;
		this.motherPhone = motherPhone;
		this.motherEmail = motherEmail;
		this.adress = adress;
		this.neighborhood = neighborhood;
		this.registerDate = registerDate;
		this.valueMensualidad = valueMensualidad;
		this.planPagoEntreno = planPagoEntreno;
		this.trainDays = trainDays;
		this.scheduleDays = scheduleDays;
		this.observations = observations;
		this.authorization = authorization;
		this.filesPath = filesPath;
	}
	
	//Getters y Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBornDate() {
		return bornDate;
	}

	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}

	public String getBornPlace() {
		return bornPlace;
	}

	public void setBornPlace(String bornPlace) {
		this.bornPlace = bornPlace;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Image getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Image profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getOcupation() {
		return ocupation;
	}

	public void setOcupation(String ocupation) {
		this.ocupation = ocupation;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherPhone() {
		return fatherPhone;
	}

	public void setFatherPhone(String fatherPhone) {
		this.fatherPhone = fatherPhone;
	}

	public String getFatherEmail() {
		return fatherEmail;
	}

	public void setFatherEmail(String fatherEmail) {
		this.fatherEmail = fatherEmail;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherPhone() {
		return motherPhone;
	}

	public void setMotherPhone(String motherPhone) {
		this.motherPhone = motherPhone;
	}

	public String getMotherEmail() {
		return motherEmail;
	}

	public void setMotherEmail(String motherEmail) {
		this.motherEmail = motherEmail;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public double getValueMensualidad() {
		return valueMensualidad;
	}

	public void setValueMensualidad(double valueMensualidad) {
		this.valueMensualidad = valueMensualidad;
	}

	public String getPlanPagoEntreno() {
		return planPagoEntreno;
	}

	public void setPlanPagoEntreno(String planPagoEntreno) {
		this.planPagoEntreno = planPagoEntreno;
	}

	public List<String> getTrainDays() {
		return trainDays;
	}

	public void setTrainDays(List<String> trainDays) {
		this.trainDays = trainDays;
	}

	public List<String> getScheduleDays() {
		return scheduleDays;
	}

	public void setScheduleDays(List<String> scheduleDays) {
		this.scheduleDays = scheduleDays;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public boolean isAuthorization() {
		return authorization;
	}

	public void setAuthorization(boolean authorization) {
		this.authorization = authorization;
	}

	public List<String> getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(List<String> filesPath) {
		this.filesPath = filesPath;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	

	
}
