package model;

public class MonetaryDonation {
	// Atributos
	private double amount;
	private String paymentMethod;
	
	// Constructor 1
	public MonetaryDonation(double amount, String paymentMethod) {
		this.amount = amount;
		this.paymentMethod = paymentMethod;
	}

	// Getters & setters
	public double getAmount() {
		return amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	// Metodos y funciones
	@Override
	public String toString() {
		String result = "Cantidad de donación: "+this.amount
				+"\nMetodo de pago: "+this.paymentMethod;
		return result;
	}
	
}
