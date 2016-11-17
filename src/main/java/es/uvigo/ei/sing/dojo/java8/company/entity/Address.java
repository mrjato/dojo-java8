package es.uvigo.ei.sing.dojo.java8.company.entity;

import static java.util.Objects.requireNonNull;

public class Address {
	private final String name;
	private final StreetType streetType;
	private final String addressLine1;
	private final String addressLine2;
	private final int postalCode;
	private final String country;
	private final Phone phone;

	public Address(
		String name,
		StreetType streetType,
		String addressLine1,
		String addressLine2,
		int postalCode,
		String country,
		Phone phone
	) {
		this.name = requireNonNull(name);
		this.streetType = streetType;
		this.addressLine1 = requireNonNull(addressLine1);
		this.addressLine2 = addressLine2;
		this.postalCode = postalCode;
		this.country = requireNonNull(country);
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public StreetType getStreetType() {
		return streetType;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public String getCountry() {
		return country;
	}

	public Phone getPhone() {
		return phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressLine1 == null) ? 0 : addressLine1.hashCode());
		result = prime * result + ((addressLine2 == null) ? 0 : addressLine2.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + postalCode;
		result = prime * result + ((streetType == null) ? 0 : streetType.hashCode());
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
		Address other = (Address) obj;
		if (addressLine1 == null) {
			if (other.addressLine1 != null)
				return false;
		} else if (!addressLine1.equals(other.addressLine1))
			return false;
		if (addressLine2 == null) {
			if (other.addressLine2 != null)
				return false;
		} else if (!addressLine2.equals(other.addressLine2))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (postalCode != other.postalCode)
			return false;
		if (streetType != other.streetType)
			return false;
		return true;
	}

}
