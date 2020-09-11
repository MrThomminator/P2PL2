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
	private boolean isCompleted;

	/*
	 * Methoden
	 */
	
	public Game (String title, Genre genre, int releasedate, boolean isCompleted) {
		this.title = title;
		this.genre = genre;
		this.releasedate = releasedate;
		this.isCompleted = isCompleted;
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

	public boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	
	
	
}
