package GameCollection;

import java.io.Serializable;
public class MobileGame extends Game implements Serializable{

	/*
	 * Attribute
	 */
	
	private OperatingSystem operatingsystem;
	
	public MobileGame(String title, Genre genre, int releasedate, boolean isCompleted, OperatingSystem operatingSystem) {
		super(title, genre, releasedate, isCompleted);
		this.operatingsystem = operatingSystem;
	}

}
