package model;

public class ItemDonation {
	// Atributos
	private String name;
	private int minItems;
	
	// Constructor 1
	public ItemDonation(String name, int minItems) {
		this.name = name;
		this.minItems = minItems;
	}

	// Getters & setters
	public String getName() {
		return name;
	}

	public int getMinItems() {
		return minItems;
	}

	// Metodos y funciones
	@Override
	public String toString() {
		String result = "Nombre: "+this.name
				+"\nObjetos minimos: "+this.minItems;
		return result;
	}
	
}
