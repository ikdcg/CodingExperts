package model;

public class AdoptionForm {
	// Atributos
	private String name;
	private String surname;
	private String email;
	private int phoneNum;
	private String address;
	private String animalName;
	private String reason;
	
	// Constructores
	public AdoptionForm(String name, String surname, String email, int phoneNum, String address, String animalName) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phoneNum = phoneNum;
		this.address = address;
		this.animalName = animalName;
		this.reason = null;
		
	}
	
	public AdoptionForm(String name, String surname, String email, int phoneNum, String address, String animalName,
			String reason) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phoneNum = phoneNum;
		this.address = address;
		this.animalName = animalName;
		this.reason = reason;
	}
	
	// Metodos y funciones
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public String getAnimalName() {
		return animalName;
	}

	public String getReason() {
		return reason;
	}

	@Override
	public String toString() {
		String result = "Nombre: "+this.name
				+"\nApellido: "+this.surname
				+"\nCorreo electrónico: "+this.email
				+"\nTelefono: "+this.phoneNum
				+"\nDirección: "+this.address
				+"\nNombre de animal: "+this.animalName
				+"\nRazon: "+this.reason;
		return result;
	}
	
}

