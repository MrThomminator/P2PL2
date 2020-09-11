package GameCollection;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MyGamesController implements Initializable{

	@FXML
	private TableView<Game> gamesTable;
	
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
	private Button removeSelectedButton;
	@FXML
	private Button goToNewGameButton;
	
	private Model model = Model.getInstance();
	
	/*
	 * Wechsel zur der View um ein Spiel hinzuzuf�gen.
	 */
	public void goToNewGame(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("NewGameView.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) goToNewGameButton.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	
	/*
	 * Die Methode des Kontextmen�s "Eintrag l�schen" f�hrt diese Methode aus und l�scht den ausgew�hlten EIntrag aus der Tabelle und der ArrayList im Model, wo alle Games verwaltet werden.
	 */
	public void removeSelectedItem(ActionEvent e) {
		ObservableList<Game> selectedRows = gamesTable.getSelectionModel().getSelectedItems();
		ArrayList<Game> rows = new ArrayList<>(selectedRows);
		rows.forEach(row -> model.getGames().remove(row));
		rows.forEach(row -> gamesTable.getItems().remove(row));
		
		
	}
	
	/*
	 * Wechselt zu der Oberfl�che, in der Eintr�ge angepasst werden k�nnen.
	 */
	public void goToModifyGame(ActionEvent e) throws IOException {
		model.setGameToModify(gamesTable.getSelectionModel().getSelectedItem());
		Parent root = FXMLLoader.load(getClass().getResource("modifyGameView.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) goToNewGameButton.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	
	/*
	 * F�hrt die Methode save() im Model aus und speichert die Listeneintr�ge (Games-Objekte) als ArrayList-Bytestrom in die gameslist.txt
	 */
	public void saveList(ActionEvent e) {
		model.save();
	}
	
	
	
	
	
	
	/*
	 * L�scht alle Tabelleneintr�ge und die ArrayList zur verwaltung aller Games-Objekte im Model.
	 */
	
	public void deleteAllGames(ActionEvent e) {
		
		gamesTable.getItems().clear();
		model.getGames().clear();
		gamesTable.refresh();
	}

	
	/*
	 * Definiert die Check-Box Controls in der Gui und liest die Games-Objekte ein, die in der ArrayList im Model gespeichert sind.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		isCompletedColumn.setCellFactory(new Callback<TableColumn<Game, Boolean>, TableCell<Game, Boolean>>() {

			@Override
			public TableCell<Game, Boolean> call(TableColumn<Game, Boolean> param) {
				CheckBoxTableCell<Game, Boolean> cell = new CheckBoxTableCell<>();
				return cell;
			}
		});

		isCompletedColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Game, Boolean>, ObservableValue<Boolean>>() {

					public ObservableValue<Boolean> call(CellDataFeatures<Game, Boolean> param) {
						SimpleBooleanProperty booleanProperty = new SimpleBooleanProperty(
								param.getValue().getIsCompleted());
						return booleanProperty;
					}
				});
	
		gamesTable.getItems().addAll(model.getGames());
	
	}
	
}
