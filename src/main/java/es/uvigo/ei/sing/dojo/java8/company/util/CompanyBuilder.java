package es.uvigo.ei.sing.dojo.java8.company.util;

import static java.lang.String.format;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import es.uvigo.ei.sing.dojo.java8.company.entity.EmployCategory;
import es.uvigo.ei.sing.dojo.java8.company.entity.StreetType;

public class CompanyBuilder {
	private final Random random;
	
	public CompanyBuilder(long seed) {
		this.random = new Random(seed);
	}

	public int pc() {
		return this.random.nextInt(100_000);
	}
	
	public String phone() {
		return Integer.toString(this.randomBetween(900_000_000, 999_999_999));
	}
	
	public static class Country {
		private final String prefix;
		private final String name;
		
		public Country(String prefix, String name) {
			this.prefix = prefix;
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public String getPrefix() {
			return prefix;
		}
	}
	
	private Country country() {
		return randomValue(new Country[] {
			new Country("+44", "UK"),
			new Country("+353", "Ireland"),
			new Country("+33", "France")
		});
	}
	
	private StreetType streetType() {
		return randomValueOrNull(StreetType.values());
	}
	
	private String name() {
		return randomValue(new String[] { "Brian Williams", "Donald King", "Sarah Martinez", "Chris Jackson",
				"Sandra Howard", "Harry Gonzalez", "Lisa Bennett", "Michelle Butler", "Joe Barnes", "Heather Young",
				"Fred Walker", "Donna Rodriguez", "Maria Gray", "Gregory Davis", "Virginia Evans", "John Lee",
				"Debra Collins", "Matthew Powell", "Nancy Carter", "Wayne Rogers", "Deborah Thompson", "Jane James",
				"Sharon Simmons", "Melissa Taylor", "Mildred Phillips", "Timothy Hernandez", "Roy Flores",
				"Cynthia Perez", "Carol Turner", "Alice Rivera", "Lois Campbell", "Brandon Patterson", "Janet Edwards",
				"Carl Wright", "Kathleen Washington", "Edward Allen", "Christine Hill", "Irene Russell", "Joyce Ross",
				"Louis Roberts", "Walter Martin", "Nicole Miller", "Raymond Adams", "Sara Baker", "Alan Bell",
				"Jacqueline Diaz", "Margaret Cooper", "Ryan Jones", "Frances Clark", "Betty Coleman", "Julia Hughes",
				"Philip Wood", "Christina Perry", "Anna Alexander", "Steven Peterson", "Gary Harris", "Ralph Bailey",
				"Willie Nelson", "Susan Murphy", "Elizabeth Jenkins", "Doris Lopez", "Carlos Morgan", "Terry Torres",
				"Bonnie Gonzales", "Karen Reed", "Jimmy Brooks", "Joan Ramirez", "Norma Smith", "Gerald Garcia",
				"Kathy Thomas", "Paula Moore", "Billy Cox", "Dorothy Henderson", "Johnny Sanders", "Jason Brown",
				"Kelly Morris", "Helen Parker", "Andrew Wilson", "Gloria Scott", "Rebecca Johnson", "Justin Watson",
				"Ruby Price", "Ann Foster", "Kenneth Anderson", "Mark Stewart", "Wanda Sanchez", "Peter Richardson",
				"Emily Lewis", "Henry Hall", "Phyllis Robinson", "Benjamin Griffin", "Sean White", "Dennis Bryant",
				"Robert Ward", "Howard Mitchell", "Jack Cook", "Joseph Long", "Phillip Kelly", "Kathryn Green",
				"Steve Garcia" });
	}
	
	private String street() {
		return randomValue(new String[] { "Harris Cassidy", "Nikole Hastings", "Isadora Myrick", "Deedee Mcnutt",
				"Daron English", "Elvera Sexton", "Katharina Albright", "Hermine Winchester", "Mandie Moe",
				"Maryellen Janes", "Evonne Knudson", "Carolee Beltran", "Saturnina Upton", "Song Geiger",
				"Verda Barrows", "Cathryn Strunk", "Shelli Mcghee", "Wilfredo Dewitt", "Agnus Dover", "Camila Feeney",
				"Rachele Folse", "Luann Archer", "Isaiah Pryor", "Annamarie Groce", "Valentin Waller",
				"Rosalinda Herman", "Delpha Allred", "Alina Armstead", "Cruz Greiner", "Arlean Pike",
				"Albertine Spring", "Long Vandyke", "Vita Glass", "Hyo Stallworth", "Carmelia Batson",
				"Charles Salinas", "Ira Bustamante", "Hong Cooney", "Reva Ramon", "Jude Mccue", "Vonnie Domingo",
				"Flo Deleon", "Mckinley Knapp", "Shelby Mckay", "Mechelle Martz", "Fredericka Cosgrove",
				"Adriene Aguilera", "Meagan Gunther", "Sonny Baines", "Suzann Boynton", "Joesph Gallo", "Joya Zuniga",
				"Olympia Hager", "Connie Russ", "Lashunda Traylor", "Arline Spearman", "Madison Huskey",
				"Renaldo Spriggs", "Greta Melancon", "Usha Ainsworth", "Saran Liles", "Adena Whittaker",
				"William Steadman", "Lecia Beckwith", "Kacey Covey", "Claudine Mackay", "Wes Mayers", "Valene Herrmann",
				"Shila Etheridge", "Sherryl Villareal", "Mitzie Dallas", "Karie Schreiber", "Carina Oneal",
				"Christin Scroggins", "Cleta Kimball", "Stephaine Lorenzo", "Yuki Salgado", "Marisa Lyon",
				"Yukiko Malley", "Hilton Vanover", "Chong Greathouse", "Ronda Driver", "Katheleen Loveless",
				"Dorcas Kaye", "Romana Barth", "Love Creel", "Karlyn Pollock", "Chantell Breaux", "Gussie Pimentel",
				"Babara Keyes", "Del Swan", "Pilar Merrick", "Delana Artis", "Tam Swartz", "Dorthea Crook",
				"Hung Frizzell", "Jacinda Nieto", "Nakita Macklin", "Annamaria Feldman", "Noel Keys" });
	}
	
	private String address2() {
		return randomValue(new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, null,
			"Second Building", "Basement"
		});
	}
	
	private String complements() {
		final int years = this.random.nextInt(30);
		final boolean paternity = this.random.nextInt(10) == 9;
		
		final List<String> complements = new ArrayList<>();
		if (years >= 5 && years < 9)
			complements.add("fiveYears");
		if (years >= 10 && years < 20)
			complements.add("tenYears");
		if (years > 20)
			complements.add("twentyYears");
		if (paternity)
			complements.add("paternity");
		
		return complements.stream().collect(joining(", "));
	}
	
	private EmployCategory category() {
		return randomValue(EmployCategory.values());
	}
	
	public String build(String name, String[] departments, int minEmployees, int maxEmployees, int minAddresses, int maxAddresses) {
		final StringBuilder sb = new StringBuilder();
		
		sb.append("final ComplementarySalary fiveYears = new ComplementarySalary(\"5 years\", 2_000d);\n");
		sb.append("final ComplementarySalary tenYears = new ComplementarySalary(\"10 years\", 10_000d);\n");
		sb.append("final ComplementarySalary twentyYears = new ComplementarySalary(\"20 years\", 20_000d);\n");
		sb.append("final ComplementarySalary paternity = new ComplementarySalary(\"Paternity\", 5_000d);\n");
		sb.append("\n");
		
		sb.append("final Company company = new Company(\"ESEI Company\", asList(\n");
		
		sb.append(
			stream(departments)
				.map(department -> buildDepartment(department, randomBetween(minEmployees, maxEmployees), minAddresses, maxAddresses))
			.collect(Collectors.joining(",\n"))
		);
		
		sb.append("\n\n));");
		
		return sb.toString();
	}
	
	private String buildDepartment(String name, int employees, int minAddresses, int maxAddresses) {
		final StringBuilder sb = new StringBuilder("\tnew Department(\"").append(name).append("\", asList(\n");

		sb.append(
			IntStream.range(0, employees)
				.mapToObj(i -> buildEmployee(randomBetween(minAddresses, maxAddresses)))
			.collect(Collectors.joining(",\n"))
		);
		
		sb.append("\n\t))");
		
		return sb.toString();
	}
	
	private String buildEmployee(int numAddresses) {
		final String addresses = IntStream.range(0, numAddresses)
			.mapToObj(i -> buildAddress(i, country()))
		.collect(joining(",\n"));
		
		if (addresses.isEmpty()) {
			return String.format("\t\tnew Employee(\"%s\", %s, asList(), asList(%s))",
				name(), category(), complements());
		} else {
			return String.format("\t\tnew Employee(\"%s\", %s, asList(%n%s%n\t\t), asList(%s))",
				name(), category(), addresses, complements());
		}
	}
	
	private String buildAddress(int i, Country country) {
		String address2 = address2();
		address2 = address2 == null ? "null" : format("\"%s\"", address2);
		
		return format("\t\t\tnew Address(\"Address %d\", %s, \"%s\", %s, %d, \"%s\", %s)",
			i, streetType(), street(), address2, pc(), country.getName(), buildPhone(country));
	}
	
	private String buildPhone(Country country) {
		if (this.random.nextBoolean()) {
			return format("new Phone(\"%s\", \"%s\")", country.getPrefix(), phone());
		} else {
			return "null";
		}
	}
	
	private int randomBetween(int min, int max) {
		return min + this.random.nextInt(max - min);
	}

	private <T> T randomValue(T[] values) {
		return values[this.random.nextInt(values.length)];
	}
	
	private <T> T randomValueOrNull(T[] values) {
		final int index = this.random.nextInt(values.length + 1);
		
		return index == values.length ? null : values[index];
	}
}
