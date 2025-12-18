package model;

public class RecursoEducativo {
	// Atributos
	private String nombre;
	private String contenido;
	private int codigo;
	
	// Constructor 1
	public RecursoEducativo(String nombre, String contenido, int codigo) {
		this.nombre = nombre;
		this.contenido = contenido;
		this.codigo = codigo;
	}

	// Getters & setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	// Metodos y funciones
	@Override
	public String toString() {
		String result = "Nombre de recurso: "+this.nombre
				+"\nContenido: "+this.contenido
				+"\nCodigo de recurso: "+this.codigo;
		return result;
	}
	
}
