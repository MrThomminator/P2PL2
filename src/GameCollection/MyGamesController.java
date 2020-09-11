package GameCollection;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
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
	TableView<Game> gamesTable;
	
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
	
	Model model = Model.getInstance();
	
	
	public void goToNewGame(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("NewGameView.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) goToNewGameButton.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	public void removeSelectedItem(ActionEvent e) {
		
	}
	
	
	public void goToModifyGame(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("modifyGameView.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) goToNewGameButton.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	
	
	
	public void saveList(ActionEvent e) {
		model.save();
	}
	
	
	
	
	
	
	
	
	public void deleteAllGames(ActionEvent e) {
		
		gamesTable.getItems().clear();
		gamesTable.refresh();
	}

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
