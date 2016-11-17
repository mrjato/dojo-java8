package es.uvigo.ei.sing.dojo.java8.company.entity;

public enum EmployCategory {
	INTERN(10_000d),
	TEMPORARY(15_000d),
	JUNIOR(20_000d),
	SENIOR(30_000d),
	MANAGEMENT(50_000d);
	
	private final double baseSalary;
	
	private EmployCategory(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public double getBaseSalary() {
		return baseSalary;
	}
}
