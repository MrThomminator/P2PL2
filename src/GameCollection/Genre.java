package GameCollection;

public enum Genre {

	/*
	 * enum Auswahl 
	 */
	
	ACTION("Action"), ACTION_ADVENTURE("Action Adventure"), RPG("RPG"), SPORTS("Sport"), STRATEGY ("Strategie"), SIMULATION ("Simulation");
	
	/*
	 * Attribute
	 */
	
	private String name;
	
	/*
	 * Methoden
	 */
	
	Genre (String name) {
		this.name = name;
	}
	
	public String getName () {
		return name;
	}
	
	
}
