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
		this.releasedate = releasedate;
		this.isPlayed = isPlayed;
	}

	/*
	 * Getter und Setter
	 */
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(int releasedate) {
		this.releasedate = releasedate;
	}

	public boolean isPlayed() {
		return isPlayed;
	}

	public void setPlayed(boolean isPlayed) {
		this.isPlayed = isPlayed;
	}
	
	
	
	
}
