package es.uvigo.ei.sing.dojo.java8.company.entity;

import static java.util.Collections.unmodifiableList;
import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Employee {
	private final String name;
	private final EmployCategory category;
	private final List<Address> addresses;
	private final List<ComplementarySalary> complementarySalaries;
	
	public Employee(
		String name,
		EmployCategory category,
		Collection<Address> addresses,
		Collection<ComplementarySalary> complementarySalaries
	) {
		this.name = requireNonNull(name);
		this.category = requireNonNull(category);
		this.addresses = new ArrayList<>(addresses);
		this.complementarySalaries = new ArrayList<>(complementarySalaries);
	}

	public String getName() {
		return this.name;
	}
	
	public EmployCategory getCategory() {
		return this.category;
	}

	public List<Address> getAddresses() {
		return unmodifiableList(this.addresses);
	}
	
	public Address getMainAddress() {
		return this.addresses.stream().findFirst().orElse(null);
	}
	
	public double getGrossSalary() {
		return this.getBaseSalary() + this.getComplementarySalary();
	}
	
	public double getBaseSalary() {
		return this.category.getBaseSalary();
	}
	
	public double getComplementarySalary() {
		return this.complementarySalaries.stream()
			.mapToDouble(ComplementarySalary::getAmount)
		.sum();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((complementarySalaries == null) ? 0 : complementarySalaries.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (category != other.category)
			return false;
		if (complementarySalaries == null) {
			if (other.complementarySalaries != null)
				return false;
		} else if (!complementarySalaries.equals(other.complementarySalaries))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
