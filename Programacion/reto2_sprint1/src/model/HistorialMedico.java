package model;

public class HistorialMedico {
	// Atributos
	private String data;
	
	// Constructor 1
	public HistorialMedico() {
		// Por defecto
		this.data = "No hay datos.";
	}
	// Constructor 2
	public HistorialMedico(String data) {
		this.data = data;
	}
	
	// Getters & setters
		public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	// Metodos y funciones
	@Override
	public String toString() {
		String result = "Datos del historial medico:\n"+this.data;
		return result;
	}
	
	
}
