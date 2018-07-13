package fr.gtm.project.proxibanque.entity;

public class Address implements Entity {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String country;
	private String city;
	private String postalCode;
	private String mainLine;
	private String optionalLine;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getMainLine() {
		return mainLine;
	}

	public void setMainLine(String mainLine) {
		this.mainLine = mainLine;
	}

	public String getOptionalLine() {
		return optionalLine;
	}

	public void setOptionalLine(String optionalLine) {
		this.optionalLine = optionalLine;
	}

}
