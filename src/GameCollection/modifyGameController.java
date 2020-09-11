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
	Label msgLabel;
	@FXML
	Label errLabel;
	@FXML
	TextField titleTF;
	@FXML
	TextField releaseTF;
	@FXML
	ComboBox<String> genreCB;
	@FXML
	RadioButton consoleRB;
	@FXML
	RadioButton pcRB;
	@FXML
	RadioButton mobileRB;
	@FXML
	ComboBox<String> osCB;
	@FXML
	TextField requirementsTF;
	@FXML
	Label systemOSLabel;
	@FXML
	Label requirementsLabel;
	@FXML
	Button newGameButton;
	@FXML
	Button cancelButton;

	@FXML
	CheckBox completedCHB;
	
	@FXML
	Button modifyGameButton;
	Game tempGame;
	
	
	Model model = Model.getInstance();
	ToggleGroup tg = new ToggleGroup();
	
	
	public void modifyGame(ActionEvent e) {
			
		
		
	}
	
	public void cancel() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MyGamesView.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
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
			
			osCB.getSelectionModel().clearSelection();
			
			mobileRB.setSelected(true);
			
			requirementsTF.visibleProperty().set(false);
			requirementsLabel.visibleProperty().set(false);		
			
			
			ObservableList<String> OSlist = FXCollections.observableArrayList(OperatingSystem.ANDROID.getName(),
					OperatingSystem.IOS.getName());
			osCB.getItems().addAll(OSlist);
			osCB.getSelectionModel().select(((MobileGame) tempGame).getOperatingSystem().getName());
		
			
		}else
			
			
			if(tempGame instanceof ConsoleGame) {
				osCB.getSelectionModel().clearSelection();
				
				consoleRB.setSelected(true);
				
				requirementsTF.visibleProperty().set(false);
				requirementsLabel.visibleProperty().set(false);		
				
				
				ObservableList<String> OSlist = FXCollections.observableArrayList(ConsoleSystem.PS4.getShortName(),
						ConsoleSystem.Switch.getShortName(), ConsoleSystem.XONE.getShortName());

				osCB.getItems().addAll(OSlist);
				osCB.getSelectionModel().select(((MobileGame) tempGame).getOperatingSystem().getName());
			
				
			
		}else 
			
			
			
			if(tempGame instanceof PcGame) {
				osCB.getSelectionModel().clearSelection();
				pcRB.setSelected(true);
				ObservableList<String> OSlist = FXCollections.observableArrayList(OperatingSystem.MS.getName(),
						OperatingSystem.LINUX.getName(), OperatingSystem.MAC.getName());
						osCB.getItems().addAll(OSlist);
						requirementsTF.visibleProperty().set(true);
						requirementsLabel.visibleProperty().set(true);
						
				releaseTF.setText(((PcGame) tempGame).getSystemSpecification());
			}
			
		
		
		tempGame = model.getGameToModify();
		
		titleTF.setText(tempGame.getTitle());
		releaseTF.setText(String.valueOf(tempGame.getReleasedate()));
		completedCHB.setSelected(tempGame.getIsCompleted());
		
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
