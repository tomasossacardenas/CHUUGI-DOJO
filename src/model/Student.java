package model;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
	//Constants	
	private static final long serialVersionUID = 1;
	//Attributes
	private String name;
	private String RH;
	private String sex;
	private String bornDate;
	private String bornPlace;
	private String id;
	private String profilePicture;
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
	private String filesDescription;
	private List<String> filesPath;
	
	//Constructor
	public Student(String name,String rh, String sex, String bornDate, String bornPlace, String id, String profilePicture, String idType,
			String eps, String ocupation, String fatherName, String fatherPhone, String fatherEmail, String motherName,
			String motherPhone, String motherEmail, String adress, String neighborhood, String registerDate,
			double valueMensualidad, String planPagoEntreno, List<String> trainDays, List<String> scheduleDays,
			String observations, boolean authorization,String filesDescription, List<String> filesPath) {
		
		this.name = name;
		this.RH=rh;
		this.sex=sex;
		this.bornDate = bornDate;
		this.bornPlace = bornPlace;
		this.id = id;
		this.setProfilePicture(profilePicture);
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
		this.filesDescription=filesDescription;
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

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", bornDate=" + bornDate + ", bornPlace=" + bornPlace + ", id=" + id
				+ ", profilePicture=" + profilePicture + ", idType=" + idType + ", eps=" + eps + ", ocupation="
				+ ocupation + ", fatherName=" + fatherName + ", fatherPhone=" + fatherPhone + ", fatherEmail="
				+ fatherEmail + ", motherName=" + motherName + ", motherPhone=" + motherPhone + ", motherEmail="
				+ motherEmail + ", adress=" + adress + ", neighborhood=" + neighborhood + ", registerDate="
				+ registerDate + ", valueMensualidad=" + valueMensualidad + ", planPagoEntreno=" + planPagoEntreno
				+ ", trainDays=" + trainDays + ", scheduleDays=" + scheduleDays + ", observations=" + observations
				+ ", authorization=" + authorization + ", filesPath=" + filesPath + "]";
	}

	public String getFilesDescription() {
		return filesDescription;
	}

	public void setFilesDescription(String filesDescription) {
		this.filesDescription = filesDescription;
	}

	public String getRH() {
		return RH;
	}

	public void setRH(String rH) {
		RH = rH;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
	
	
	

	
}
