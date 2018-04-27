package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	
	MainController mainController;
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			// set a title for the Window
			primaryStage.setTitle("Earthquake Window");

			// get an FXML loade	r and read in the fxml code
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/EarthquakeData.fxml"));
			AnchorPane mainLayout = (AnchorPane)loader.load();

			// Create the scene with the layout in the fxml code, set the scene and show it
			Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}


	}

	public static void main(String[] args) {
		launch(args);

	}

}
