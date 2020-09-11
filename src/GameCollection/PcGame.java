package GameCollection;

import java.io.Serializable;

public class PcGame extends Game implements Serializable{

	/*
	 * Attribute
	 */
	
	private static final long serialVersionUID = 1L;
	private OperatingSystem operatingSystem;
	private String systemSpecification;
	
	/*
	 * Methoden
	 */
	
	public PcGame(String title, Genre genre, int releasedate, boolean isCompleted, OperatingSystem operatingSystem, String systemSpecification) {
		super(title, genre, releasedate, isCompleted);
		this.operatingSystem = operatingSystem;
		this.systemSpecification = systemSpecification;
	}

	public OperatingSystem getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(OperatingSystem operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getSystemSpecification() {
		return systemSpecification;
	}

	public void setSystemSpecification(String systemSpecification) {
		this.systemSpecification = systemSpecification;
	}
	
	

}
