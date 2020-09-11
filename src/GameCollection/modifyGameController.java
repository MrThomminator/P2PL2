package GameCollection;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class modifyGameController implements Initializable{

	@FXML
	private Label msgLabel;
	@FXML
	private Label errLabel;
	@FXML
	private TextField titleTF;
	@FXML
	private TextField releaseTF;
	@FXML
	private ComboBox<String> genreCB;
	@FXML
	private RadioButton consoleRB;
	@FXML
	private RadioButton pcRB;
	@FXML
	private RadioButton mobileRB;
	@FXML
	private ComboBox<String> osCB;
	@FXML
	private TextField requirementsTF;
	@FXML
	private Label systemOSLabel;
	@FXML
	private Label requirementsLabel;
	@FXML
	private Button newGameButton;
	@FXML
	private Button cancelButton;

	@FXML
	private CheckBox completedCHB;
	
	@FXML
	private Button modifyGameButton;
	private Game tempGame;
	
	
	private Model model = Model.getInstance();
	private ToggleGroup tg = new ToggleGroup();
	private Genre temp = null;
	private OperatingSystem tempOS = null;
	private ConsoleSystem tempCS = null;
	
	/**
	 * @Class ModifyGameController
	 * @author Melissa, Julian, Thomas
	 */
	
	
	/*
	 * Anhand des ausgewählten Radiobuttons wird ein neues Objekt erstellt, welches tendentiell ein neues Objekt anlegt.
	 * Das "Alte" Game-Objekt, welches zum bearbeiten ausgewählt wurde, wird gelöscht. (Das neue ersetzt das alte).
	 * 
	 */
	public void modifyGame(ActionEvent e) {
		
		try {

			for (Genre g : Genre.values()) {
				if (g.getName().equals(genreCB.getSelectionModel().getSelectedItem())) {
					temp = g;
					System.out.println("Genre " + temp.getName());
					break;
				}
			}

			if (pcRB.isSelected()) {
				ObservableList<String> OSlist = FXCollections.observableArrayList(OperatingSystem.MS.getName(),
				OperatingSystem.LINUX.getName(), OperatingSystem.MAC.getName());
				osCB.getItems().addAll(OSlist);
				releaseTF.visibleProperty().set(true);
				requirementsLabel.visibleProperty().set(true);
				for (OperatingSystem osTemp : OperatingSystem.values()) {
					if (osTemp.getName().equals(osCB.getSelectionModel().getSelectedItem())) {
						tempOS = osTemp;
					}
				}

				model.createGame(titleTF.getText(), temp, Integer.valueOf(releaseTF.getText()), completedCHB.isSelected(), tempOS,
						requirementsTF.getText());
			} 
			
			
			else if (consoleRB.isSelected()) {
				
				model.createGame(titleTF.getText(), temp, Integer.valueOf(releaseTF.getText()), completedCHB.isSelected(), tempCS);

			} else if (mobileRB.isSelected()) {
				

				model.createGame(titleTF.getText(), temp, Integer.valueOf(releaseTF.getText()), completedCHB.isSelected(), tempOS);

			}

		} catch (NumberFormatException e1) {
			errLabel.setText("Sie haben ein flasches Zeichen eingegeben.");
		} catch (NullPointerException e2) {
			errLabel.setText("Sie haben vergessen ein Feld auszufüllen");
		}
		
		
		model.getGames().remove(tempGame);
		
	
		
	}
	
	/*
	 * Führt zurück zu der Main-Gui, wo die Game-Objekte aufgelistet sind.
	 */
	public void cancel() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MyGamesView.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	
	
	
	/**
	 * ließt das Game-Objekt ein, welches zu bearbeiten gilt. Alle Standardwerte die für alle Games gelten können so eingelesen werden.
	 * Für Games-spezifische Einträge sowie die visable-Eigenschaften werden erst nach einer Überprüfung und Umwandlung (Downcast) in die GUI initalisiert.
	 * Nach dem Downcast wird noch in einer Foreach-Schleife geprüft, welcher Wert des jeweiligen Objekts gesetzt ist, um dies als Selektieren Wert der Combobox zu setzen.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tempGame = model.getGameToModify();
		ObservableList<String> genresCollection = FXCollections.observableArrayList(Genre.ACTION.getName(),
				Genre.ACTION_ADVENTURE.getName(), Genre.RPG.getName(), Genre.SIMULATION.getName(),
				Genre.SPORT.getName(), Genre.STRATEGY.getName());
		genreCB.getItems().addAll(genresCollection);
		for(Genre g : Genre.values()) {
			if(g.getName().equals(tempGame.getGenre().getName())) {
				genreCB.getSelectionModel().select(g.getName());
			}
		}
		
		
		
		
		consoleRB.setToggleGroup(tg);
		pcRB.setToggleGroup(tg);
		mobileRB.setToggleGroup(tg);
		
		if(tempGame instanceof MobileGame) {
			osCB.getItems().clear();
			MobileGame mGame = (MobileGame) tempGame;
			//osCB.getSelectionModel().clearSelection();
			
			mobileRB.setSelected(true);
			
			requirementsTF.visibleProperty().set(false);
			requirementsLabel.visibleProperty().set(false);		
			
			
			ObservableList<String> OSlist = FXCollections.observableArrayList(OperatingSystem.ANDROID.getName(),
					OperatingSystem.IOS.getName());
			
			osCB.getItems().addAll(OSlist);
	
			for(OperatingSystem mos : OperatingSystem.values()) {
				if(mos.getName().equals(mGame.getOperatingSystem().getName())) {
					osCB.getSelectionModel().select(mos.getName());
				}
			}
		
			
		}else
			
			
			if(tempGame instanceof ConsoleGame) {
			
				ConsoleGame cGame = (ConsoleGame) tempGame;
				osCB.getSelectionModel().clearSelection();
				
				consoleRB.setSelected(true);
				
				requirementsTF.visibleProperty().set(false);
				requirementsLabel.visibleProperty().set(false);		
				
				
				ObservableList<String> OSlist = FXCollections.observableArrayList(ConsoleSystem.PS4.getShortName(),
						ConsoleSystem.Switch.getShortName(), ConsoleSystem.XONE.getShortName());

				osCB.getItems().addAll(OSlist);
				
				for(ConsoleSystem s : ConsoleSystem.values()) {
					if(s.getShortName().equals(cGame.getConsoleSystem().getShortName())) {
						osCB.getSelectionModel().select(s.getShortName());
					}
				}
		
			
				
			
		}else 
			
			
			
			if(tempGame instanceof PcGame) {
		osCB.getItems().clear();
				PcGame pGame = (PcGame) tempGame;
			//	osCB.getSelectionModel().clearSelection();
				pcRB.setSelected(true);
				ObservableList<String> OSlist = FXCollections.observableArrayList(OperatingSystem.MS.getName(),
						OperatingSystem.LINUX.getName(), OperatingSystem.MAC.getName());
						osCB.getItems().addAll(OSlist);
						requirementsTF.visibleProperty().set(true);
						requirementsLabel.visibleProperty().set(true);
						
						for(OperatingSystem os : OperatingSystem.values()) {
							if(os.getName().equals(pGame.getOperatingSystem().getName())) {
								osCB.getSelectionModel().select(os.getName());
							}
						}
				
						
						requirementsTF.setText(pGame.getSystemSpecification());
			}
			
		
		
		
		titleTF.setText(tempGame.getTitle());
		releaseTF.setText(String.valueOf(tempGame.getReleasedate()));
		completedCHB.setSelected(tempGame.getIsCompleted());
		
	
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
