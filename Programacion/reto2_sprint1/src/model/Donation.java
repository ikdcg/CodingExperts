package model;

public class Donation {
	// Atributos
	private String name;
	private String email;
	private double amount;
	private String paymentMethod;
	
	// Constructor 1
	public Donation(String name, String email, double amount, String paymentMethod) {
		this.name = name;
		this.email = email;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
	}
	
	// Getters & setters
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public double getAmount() {
		return amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	// Metodos y funciones
	@Override
	public String toString() {
		String result = "Nombre: "+this.name
				+"\nCorreo Electrónico: "+this.email
				+"\nImporte: "+this.amount
				+"\nMetodo de pago: "+this.paymentMethod;
		return result;
	}
	
}
