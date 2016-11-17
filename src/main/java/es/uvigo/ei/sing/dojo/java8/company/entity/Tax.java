package es.uvigo.ei.sing.dojo.java8.company.entity;

public enum Tax {
	LOW(0.1d),
	MEDIUM(0.15d),
	HIGH(0.2d);
	
	private final double taxRate;
	
	private Tax(double taxRate) {
		this.taxRate = taxRate;
	}
	
	public double getTaxRate() {
		return taxRate;
	}
	
	public static Tax forGrossSalary(double grossSalary) {
		if (grossSalary < 12_000d) {
			return LOW;
		} else if (grossSalary < 24_000d) {
			return MEDIUM;
		} else {
			return HIGH;
		}
	}
}
