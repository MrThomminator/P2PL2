package GameCollection;

import java.io.Serializable;

public class Game implements Serializable {

	/*
	 * Attribute
	 */

	private static final long serialVersionUID = 1L;
	private String title;
	private Genre genre;
	private int releasedate;
	private boolean isPlayed;

	/*
	 * Methoden
	 */
	
	public Game (String title, Genre genre, int releasedate, boolean isPlayed) {
		this.title = title;
		this.genre = genre;
	}
}
