package GameCollection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args){
		launch(args);

	}

	@Override
	public void init() throws Exception {
		
//		super.init();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		new FXMLLoader();
		Parent root = FXMLLoader.load(getClass().getResource("myGamesView.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Melissas, Julians und Thomas Spieleliste");
		primaryStage.setScene(scene);
		primaryStage.show();
		//primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("laubbaumicon.jpg")));
	
	}
	
	@Override
	public void stop() {
		

	}

}
