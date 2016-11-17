package es.uvigo.ei.sing.dojo.java8.company.entity;

import static java.util.Collections.unmodifiableSet;
import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Department {
	private final String name;
	private final Set<Employee> employees;
	
	public Department(String name, Collection<Employee> employees) {
		this.name = requireNonNull(name);
		this.employees = new HashSet<>(employees);
	}
	
	public String getName() {
		return this.name;
	}

	public Set<Employee> getEmployees() {
		return unmodifiableSet(this.employees);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
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
		Department other = (Department) obj;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
