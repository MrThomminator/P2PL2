package GameCollection;

public class ConsoleGame extends Game {

	/*
	 * Attribute
	 */
	
	private ConsoleSystem consoleSystem;
	
	/*
	 * Methoden
	 */
	
	public ConsoleGame(String title, Genre genre, int releasedate, boolean isPlayed, ConsoleSystem consoleSystem) {
		super(title, genre, releasedate, isPlayed);
		this.consoleSystem = consoleSystem;
	}
	
	

}
