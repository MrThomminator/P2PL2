package GameCollection;

public enum OperatingSystem {

	/*
	 * enum Auswahl 
	 */
	
	MS("MS Windows"), MAC("macOS"), LINUX("Linux"), IOS("iOS"), ANDROID ("Android");
	
	/*
	 * Attribute
	 */
	
	private String name;

	/*
	 * Methoden
	 */
	
	OperatingSystem (String name) {
		this.name = name;
	}

	/*
	 * Getter und Setter
	 */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
