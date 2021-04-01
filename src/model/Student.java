package model;

public class Student {
	//Attributes
	private String name;
	private String surnames;
	private String id;
	private String phoneContact;
	private String payersName;
	private String emailContact;
	
	public Student(String name, String surnames,String id, String phoneContact, String payersName, String emailContact) {
		this.name = name;
		this.surnames = surnames;
		this.id=id;
		this.phoneContact = phoneContact;
		this.payersName = payersName;
		this.emailContact= emailContact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getPhoneContact() {
		return phoneContact;
	}

	public void setPhoneContact(String phoneContact) {
		this.phoneContact = phoneContact;
	}

	public String getPayersName() {
		return payersName;
	}

	public void setPayersName(String payersName) {
		this.payersName = payersName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmailContact() {
		return emailContact;
	}

	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}
	
	
	
	
}
