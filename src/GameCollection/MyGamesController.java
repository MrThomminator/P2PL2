package GameCollection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.Pane;

public class MyGamesController {

	@FXML
	private Pane myGamesViewPane;
	@FXML
	private MenuItem saveMI;
	@FXML
	private MenuItem deleteAllMI;
	@FXML
	private MenuItem newGameCMI;
	@FXML
	private MenuItem deleteGameCMI;
	@FXML
	private MenuItem modifyGameCMI;

	@FXML
	private TableColumn<Game, String> titleColumn;
	@FXML
	private TableColumn<Game, String> genreColumn;
	@FXML
	private TableColumn<Game, Integer> releaseColumn;
	@FXML
	private TableColumn<Game, String> systemColumn;
	@FXML
	private TableColumn<Game, Boolean> isCompletedColumn;
	

	@FXML
	Button removeSelectedButton;
	@FXML
	Button goToNewGameButton;
	
	
	public void goToNewGame(ActionEvent e) {
		
	}
	
	public void removeSelectedItem(ActionEvent e) {
		
	}
	
	
	public void goToModifyGame(ActionEvent e) {
		
	}
	
	

	
	
	
	
	
	
	
	
	
	public void saveList(ActionEvent e) {
		
	}
	
	public void deleteAllGames(ActionEvent e) {
		
	}
	
}
