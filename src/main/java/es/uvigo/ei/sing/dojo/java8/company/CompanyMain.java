package es.uvigo.ei.sing.dojo.java8.company;

import static es.uvigo.ei.sing.dojo.java8.company.entity.EmployCategory.INTERN;
import static es.uvigo.ei.sing.dojo.java8.company.entity.EmployCategory.JUNIOR;
import static es.uvigo.ei.sing.dojo.java8.company.entity.EmployCategory.MANAGEMENT;
import static es.uvigo.ei.sing.dojo.java8.company.entity.EmployCategory.SENIOR;
import static es.uvigo.ei.sing.dojo.java8.company.entity.EmployCategory.TEMPORARY;
import static es.uvigo.ei.sing.dojo.java8.company.entity.StreetType.ALLEY;
import static es.uvigo.ei.sing.dojo.java8.company.entity.StreetType.AVENUE;
import static es.uvigo.ei.sing.dojo.java8.company.entity.StreetType.BACKROAD;
import static es.uvigo.ei.sing.dojo.java8.company.entity.StreetType.CRESCENT;
import static es.uvigo.ei.sing.dojo.java8.company.entity.StreetType.CUL_DE_SAC;
import static es.uvigo.ei.sing.dojo.java8.company.entity.StreetType.DRIVEWAY;
import static es.uvigo.ei.sing.dojo.java8.company.entity.StreetType.GRAVELROAD;
import static es.uvigo.ei.sing.dojo.java8.company.entity.StreetType.LIVINGSTREET;
import static java.util.Arrays.asList;

import es.uvigo.ei.sing.dojo.java8.company.entity.Address;
import es.uvigo.ei.sing.dojo.java8.company.entity.Company;
import es.uvigo.ei.sing.dojo.java8.company.entity.ComplementarySalary;
import es.uvigo.ei.sing.dojo.java8.company.entity.Department;
import es.uvigo.ei.sing.dojo.java8.company.entity.Employee;
import es.uvigo.ei.sing.dojo.java8.company.entity.Phone;

public class CompanyMain {
	public static void main(String[] args) {
		final Company company = buildCompany();
		
		
	}
	
	private static Company buildCompany() {
		final ComplementarySalary fiveYears = new ComplementarySalary("5 years", 2_000d);
		final ComplementarySalary tenYears = new ComplementarySalary("10 years", 10_000d);
		final ComplementarySalary twentyYears = new ComplementarySalary("20 years", 20_000d);
		final ComplementarySalary paternity = new ComplementarySalary("Paternity", 5_000d);

		return new Company("ESEI Company", asList(
			new Department("Accounting", asList(
				new Employee("Chris Jackson", JUNIOR, asList(), asList(twentyYears)),
				new Employee("Howard Mitchell", JUNIOR, asList(
					new Address("Address 0", BACKROAD, "Cruz Greiner", null, 38524, "France", null)
				), asList(fiveYears)),
				new Employee("Heather Young", SENIOR, asList(
					new Address("Address 0", DRIVEWAY, "Karlyn Pollock", null, 16942, "UK", null),
					new Address("Address 1", AVENUE, "Tam Swartz", null, 36363, "UK", new Phone("+44", "911405798"))
				), asList()),
				new Employee("Mark Stewart", JUNIOR, asList(
					new Address("Address 0", CRESCENT, "Wes Mayers", null, 52808, "France", new Phone("+33", "947003117"))
				), asList(tenYears, paternity)),
				new Employee("Norma Smith", SENIOR, asList(
					new Address("Address 0", DRIVEWAY, "Cathryn Strunk", null, 91765, "France", null)
				), asList(twentyYears)),
				new Employee("Julia Hughes", JUNIOR, asList(
					new Address("Address 0", ALLEY, "Hyo Stallworth", null, 38556, "France", null),
					new Address("Address 1", LIVINGSTREET, "Noel Keys", null, 27727, "France", new Phone("+33", "922303917"))
				), asList(tenYears)),
				new Employee("Ryan Jones", TEMPORARY, asList(), asList(fiveYears)),
				new Employee("Cynthia Perez", SENIOR, asList(
					new Address("Address 0", BACKROAD, "Evonne Knudson", null, 14480, "France", new Phone("+33", "959917987"))
				), asList(twentyYears))
			)),
			new Department("Management", asList(
				new Employee("Elizabeth Jenkins", TEMPORARY, asList(), asList(tenYears)),
				new Employee("Donald King", SENIOR, asList(), asList(twentyYears)),
				new Employee("Wanda Sanchez", MANAGEMENT, asList(
					new Address("Address 0", null, "Katharina Albright", null, 60309, "Ireland", null)
				), asList()),
				new Employee("Timothy Hernandez", TEMPORARY, asList(), asList(tenYears)),
				new Employee("Jimmy Brooks", INTERN, asList(), asList(twentyYears)),
				new Employee("Howard Mitchell", SENIOR, asList(), asList()),
				new Employee("Ann Foster", JUNIOR, asList(), asList(fiveYears))
			)),
			new Department("Information Technology", asList(
				new Employee("Gerald Garcia", SENIOR, asList(), asList(twentyYears, paternity)),
				new Employee("Dennis Bryant", TEMPORARY, asList(
					new Address("Address 0", CUL_DE_SAC, "Lashunda Traylor", null, 70972, "UK", new Phone("+44", "941110739"))
				), asList()),
				new Employee("Dorothy Henderson", MANAGEMENT, asList(), asList(fiveYears, paternity)),
				new Employee("Kenneth Anderson", JUNIOR, asList(
					new Address("Address 0", null, "Verda Barrows", null, 25225, "France", null)
				), asList(tenYears)),
				new Employee("Fred Walker", MANAGEMENT, asList(), asList(twentyYears, paternity)),
				new Employee("Ralph Bailey", TEMPORARY, asList(
					new Address("Address 0", CUL_DE_SAC, "Olympia Hager", null, 39227, "Ireland", new Phone("+353", "951894784")),
					new Address("Address 1", GRAVELROAD, "Babara Keyes", "Second Building", 79462, "France", null)
				), asList(tenYears)),
				new Employee("Julia Hughes", SENIOR, asList(), asList(tenYears)),
				new Employee("Kenneth Anderson", TEMPORARY, asList(), asList(tenYears))
			))
		));
	}

}
