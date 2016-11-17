package es.uvigo.ei.sing.dojo.java8.company.entity;

public class ComplementarySalary {
	private String name;
	private double amount;

	public ComplementarySalary(String name, double amount) {
		this.name = name;
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
