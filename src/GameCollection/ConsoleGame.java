package GameCollection;

import java.io.Serializable;
public class ConsoleGame extends Game implements Serializable {

	/*
	 * Attribute
	 */
	
	private static final long serialVersionUID = 1L;
	private ConsoleSystem consoleSystem;
	
	/*
	 * Methoden
	 */
	
	public ConsoleGame(String title, Genre genre, int releasedate, boolean isPlayed, ConsoleSystem consoleSystem) {
		super(title, genre, releasedate, isPlayed);
		this.consoleSystem = consoleSystem;
	}

	public ConsoleSystem getConsoleSystem() {
		return consoleSystem;
	}

	public void setConsoleSystem(ConsoleSystem consoleSystem) {
		this.consoleSystem = consoleSystem;
	}

}
