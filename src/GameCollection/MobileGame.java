package GameCollection;

import java.io.Serializable;

public class MobileGame extends Game implements Serializable{

	/*
	 * Attribute
	 */
	
	private static final long serialVersionUID = 1L;
	private OperatingSystem operatingSystem;
	
	/*
	 * Methoden
	 */
	
	public MobileGame(String title, Genre genre, int releasedate, boolean isCompleted, OperatingSystem operatingSystem) {
		super(title, genre, releasedate, isCompleted);
		this.operatingSystem = operatingSystem;
	}

	public OperatingSystem getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(OperatingSystem operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	
	
}
