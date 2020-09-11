package GameCollection;

import java.util.ArrayList;

public class Model {
	private static Model instance;
	
	ArrayList<Game> games = new ArrayList<>();
	
	private Model() {

	}

//	public void createGame(String title, Genre genre, int releasedate, boolean isCompleted) {
//		games.add(new Game(title, genre, releasedate, isCompleted));
//		for(Game game : games) {
//			System.out.println(game.getGenre().getName());
//		}
//	}
//	
	public void createGame(String title, Genre genre, int releasedate, boolean isCompleted, OperatingSystem os, String systemRequirements) {
		games.add(new PcGame(title, genre, releasedate, isCompleted, os, systemRequirements));
		for(Game game : games) {
			System.out.println(game.getGenre().getName());
		}
	}
	
	public void createGame(String title, Genre genre, int releasedate, boolean isCompleted, ConsoleSystem cs) {
		games.add(new ConsoleGame(title, genre, releasedate, isCompleted, cs));
		for(Game game : games) {
			System.out.println(game.getGenre().getName());
		}
	}
	
	public void createGame(String title, Genre genre, int releasedate, boolean isCompleted, OperatingSystem os) {
		games.add(new MobileGame(title, genre, releasedate, isCompleted, os));
		for(Game game : games) {
			System.out.println(game.getGenre().getName());
		}
	}	
	
	
	public static Model getInstance() {
		if (instance == null) {
			instance = new Model();
		}
		return instance;
	}

	
	public void modifyGame() {
		
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
