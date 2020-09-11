package GameCollection;

public enum ConsoleSystem {

	/*
	 * enum Auswahl 
	 */
	
	PS4("PS4","Playstation 4"), XONE("XONE","XBOX One"), Switch("SWT","Switch");
	
	/*
	 * Attribute
	 */
	
	private String name;
	private String shortName;
	
	/*
	 * Methoden
	 */
	
	ConsoleSystem (String shortName, String name) {
		this.shortName = shortName;
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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

}
