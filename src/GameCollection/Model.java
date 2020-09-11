package GameCollection;

import java.util.ArrayList;

public class Model {
	private static Model instance;
	
	ArrayList<Game> games = new ArrayList<>();
	
	private Model() {

	}

	public static Model getInstance() {
		if (instance == null) {
			instance = new Model();
		}
		return instance;
	}

	
	public void deleteAllGames() {
		games.clear();
		save();
	}
	
	public void save(){
		
	}
	
	
	/*
	 * Getter and Setter
	 */
	public ArrayList<Game> getGames() {
		return games;
	}

	public void setGames(ArrayList<Game> games) {
		this.games = games;
	}
	
	
	
	
}
