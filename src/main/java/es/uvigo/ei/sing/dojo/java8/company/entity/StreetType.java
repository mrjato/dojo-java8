package es.uvigo.ei.sing.dojo.java8.company.entity;

public enum StreetType {
	ALLEY("Alley"),
	AVENUE("Avenue"),
	BACKROAD("Backroad"),
	BOULEVARD("Boulevard"),
	BYWAY("Byway"),
	COLLECTORROAD("Collectorroad"),
	CRESCENT("Crescent"),
	COURT("Court"),
	CUL_DE_SAC("Cul-de-sac"),
	DIRTROAD("Dirtroad"),
	DRIVE("Drive"),
	DRIVEWAY("Driveway"),
	FRONTAGEROAD("Frontageroad"),
	GRAVELROAD("Gravelroad"),
	HIGHWAY("Highway"),
	LANE("Lane"),
	LIVINGSTREET("Livingstreet"),
	PLACE("Place"),
	ROAD("Road"),
	ROUTE("Route"),
	SINGLECARRIAGEWAY("Singlecarriageway"),
	STREET("Street"),
	WOONERF("Woonerf"),
	WAY("Way");
	
	private final String descriptiveName;
	
	private StreetType(String descriptiveName) {
		this.descriptiveName = descriptiveName;
	}
	
	public String getDescriptiveName() {
		return descriptiveName;
	}
}
