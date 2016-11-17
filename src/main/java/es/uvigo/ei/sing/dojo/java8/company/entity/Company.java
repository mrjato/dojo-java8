package es.uvigo.ei.sing.dojo.java8.company.entity;

import static java.util.Collections.unmodifiableSet;
import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Company {
	private final String name;
	private final Set<Department> departments;
	
	public Company(String name, Collection<Department> departments) {
		this.name = requireNonNull(name);
		this.departments = new HashSet<>(departments);
	}
	
	public String getName() {
		return name;
	}
	
	public Set<Department> getDepartments() {
		return unmodifiableSet(this.departments);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departments == null) ? 0 : departments.hashCode());
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
		Company other = (Company) obj;
		if (departments == null) {
			if (other.departments != null)
				return false;
		} else if (!departments.equals(other.departments))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
