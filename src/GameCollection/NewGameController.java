package GameCollection;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewGameController {

	
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
	Model model = Model.getInstance();
	
	public void createNewGame() {
		
	}
	
	public void cancel() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MyGamesView.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
		
	}
	
}
