package GameCollection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args){
		launch(args);

	}

	
	/**
	 * Die init-Methode initalisierung die Objekte, die in der Datei gameslist.txt gepeichert wurden, 
	 * dazu ruft sie die nötige Methode im Model auf.
	 */
	
	@Override
	public void init() throws Exception {
		Model.getInstance().openList();
	}
	
	/**
	 * Die Startmethode öffnet beim Start die Oberfläche MyGamesview.fxml und setzt ein Icon für die Stage.
	 */
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		new FXMLLoader();
		Parent root = FXMLLoader.load(getClass().getResource("myGamesView.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Spieleliste von Melissa, Julian und Thomas");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/Images/ApplicationIcon.png")));
	
	}
	
	@Override
	public void stop() {
		

	}

}
