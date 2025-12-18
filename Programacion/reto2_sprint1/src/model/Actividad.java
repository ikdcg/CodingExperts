package model;

public class Actividad {
	// Atributos
	private String nombre;
	private boolean disponibilidad;
	private String requisitos;
	
	// Constructor 1
	public Actividad(String nombre) {
		super();
		this.nombre = nombre;
	}
	// Constructor 2
	public Actividad(String nombre, boolean disponibilidad, String requisitos) {
		super();
		this.nombre = nombre;
		this.disponibilidad = disponibilidad;
		this.requisitos = requisitos;
	}
	
	// Getters & setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	
	// Metodos y funciones
	@Override
	public String toString() {
		String result = "Nombre: "+this.nombre
				+"\nDisponible: "+this.disponibilidad
				+"\nRequisitos: "+this.requisitos;
		return result;
	}
	
}
