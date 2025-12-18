package model;

public class Comida {
	// Atributo
	private String nombre;
	private double calorias;	//Kcal por 100g
	private String contenidos;
	private int stock;
	private String proveedor;
	
	// Constructor 1
	public Comida(String nombre, int calorias, String contenidos, int stock, String proveedor) {
		this.nombre = nombre;
		this.calorias = calorias;
		this.contenidos = contenidos;
		this.stock = stock;
		this.proveedor = proveedor;
	}

	// Getters & setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getCalorias() {
		return calorias;
	}

	public String getContenidos() {
		return contenidos;
	}
	
	public String getProveedor() {
		return proveedor;
	}

		// Metodos y funciones
		@Override
	public String toString() {
		String result = "Nombre: "+this.nombre
				+"\nCalorias: "+this.calorias
				+"\nContenidos: "+this.contenidos
				+"\nStock: "+this.stock
				+"\nProveedor: "+this.proveedor;
		return result;
	}
}
