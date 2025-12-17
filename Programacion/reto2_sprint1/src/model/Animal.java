package model;

public class Animal {
	// Atributos
	private String name;
	private String type;
	private int age;
	private String breed;
	private String medicalHistory;
	private String caracteristics;
	private String specialNeeds;
	
	// Constructores
	public Animal(String name, String type, int age, String breed) {
		this.name = name;
		this.type = type;
		this.age = age;
		this.breed = breed;
		// Por defecto
		this.medicalHistory = "No hay historial medico.";
		this.caracteristics = "No se ha detallado caracteristicas.";
		this.specialNeeds = "No se ha detallado necesidades especiales.";
	}
	
	public Animal(String name, String type, int age, String breed, String medicalHistory, String caracteristics, String specialNeeds) {
		this.name = name;
		this.type = type;
		this.age = age;
		this.breed = breed;
		this.medicalHistory = medicalHistory;
		this.caracteristics = caracteristics;
		this.specialNeeds = specialNeeds;
	}
	
	// Metodos y funciones
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getType() {
		return type;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public String getCaracteristics() {
		return caracteristics;
	}

	public void setCaracteristics(String caracteristics) {
		this.caracteristics = caracteristics;
	}

	public String getSpecialNeeds() {
		return specialNeeds;
	}

	public void setSpecialNeeds(String specialNeeds) {
		this.specialNeeds = specialNeeds;
	}

	public String getName() {
		return name;
	}

	public String getBreed() {
		return breed;
	}

	@Override
	public String toString() {
		String result = "Nombre: "+this.name
				+"\nTipo de animal: "+this.type
				+"\nEdad: "+this.age
				+"\nRaza: "+this.breed
				+"\nHistorial medico:\n"
				+this.medicalHistory
				+"\nCaracteristicas:\n"
				+this.caracteristics
				+"\nNecesidades especiales:\n"
				+this.specialNeeds;
		return result;
	}
	
}
