package model;

public class VoluntaryForm {
	// Atributos
	private String name;
	private String surname;
	private String email;
	private int phoneNum;
	private String activity;
	private String availability;
	private String reason;
	
	// Constructor 1
	public VoluntaryForm(String name, String surname, String email, int phoneNum, String activity, String availability) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phoneNum = phoneNum;
		this.activity = activity;
		this.availability = availability;
		// Por defecto
		this.reason = null;
	}
	// Constructor 2
	public VoluntaryForm(String name, String surname, String email, int phoneNum, String activity, String availability, String reason) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phoneNum = phoneNum;
		this.activity = activity;
		this.availability = availability;
		this.reason = reason;
	}
	
	// Getters & setters
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

	public String getActivity() {
		return activity;
	}

	public String getAvailability() {
		return availability;
	}

	public String getReason() {
		return reason;
	}

	// Metodos y funciones
	@Override
	public String toString() {
		String result = "Nombre: "+this.name
				+"\nApellido: "+this.surname
				+"\nCorreo electrónico: "+this.email
				+"\nTelefono: "+this.phoneNum
				+"\nAvtividad: "+this.activity
				+"\nDisponibilidad: "+this.availability
				+"\nRazon: "+this.reason;
		return result;
	}
	
}
