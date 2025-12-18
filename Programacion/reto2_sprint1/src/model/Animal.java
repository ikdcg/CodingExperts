package model;

public class Animal {
	// Atributos
	private String name;
	private int age;
	private String breed;
	private String caracteristics;
	private String specialNeeds;
	
	// Constructor 1
	public Animal(String name, int age, String breed) {
		this.name = name;
		this.age = age;
		this.breed = breed;
		// Por defecto
		this.caracteristics = "No se ha detallado caracteristicas.";
		this.specialNeeds = "No se ha detallado necesidades especiales.";
	}
	// Constructor 2
	public Animal(String name, int age, String breed, String caracteristics, String specialNeeds) {
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.caracteristics = caracteristics;
		this.specialNeeds = specialNeeds;
	}
	
	// Getters & setters
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
	
	// Metodos y funciones
	@Override
	public String toString() {
		String result = "Nombre: "+this.name
				+"\nEdad: "+this.age
				+"\nRaza: "+this.breed
				+"\nCaracteristicas:\n"
				+this.caracteristics
				+"\nNecesidades especiales:\n"
				+this.specialNeeds;
		return result;
	}
	
}
