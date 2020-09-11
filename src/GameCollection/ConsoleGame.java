package GameCollection;

import java.io.Serializable;
public class ConsoleGame extends Game implements Serializable {

	/*
	 * Attribute
	 */
	
<<<<<<< HEAD
=======
	private static final long serialVersionUID = 1L;
>>>>>>> branch 'master' of https://github.com/MrThomminator/P2PL2
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
