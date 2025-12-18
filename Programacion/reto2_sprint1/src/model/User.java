package model;

public class User {
	// Atributos
	private String name;
	private String password;
	private boolean admin;
	
	// Constructor 1
	public User(String name, String password) {
		this.name = name;
		this.password = password;
		// Por defecto
		this.admin = false;
	}
	// Constructor 2
	public User(String name, String password, boolean admin) {
		this.name = name;
		this.password = password;
		this.admin = admin;
	}
	
	// Getters & setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	// Metodos y funciones
	@Override
	public String toString() {
		String result = "Nombre: "+this.name
				+"\nContraseña: "+this.password
				+"\nEs adminstrador: "+this.admin;
		return result;
	}
	
}
