package application;
	
import java.util.Scanner;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.text.SimpleDateFormat;  
import java.util.Date;  


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		ArrayList<EarthQuake> earthArray = new ArrayList<>();

		//Read in data from csv file
		java.io.File theFile = new java.io.File("all_month.csv");
		try (Scanner input = new Scanner(theFile)) {
			//Read first line of headers
			String[] theHeader = input.nextLine().split(",");
			System.out.print("Got header.");
			while (input.hasNextLine()) {
				String[] theThing = input.nextLine().split(",");
				earthArray.add(new EarthQuake(theThing[0],
						theThing[1],
						theThing[2], 
						theThing[3], 
						theThing[4], 
						theThing[5], 
						theThing[6],
						theThing[7],
						theThing[8], 
						theThing[9], 
						theThing[10], 
						theThing[11], 
						theThing[12], 
						theThing[13], 
						theThing[14], 
						theThing[15], 
						theThing[16], 
						theThing[17], 
						theThing[18],
						theThing[19], 
						theThing[20], 
						theThing[21]));
				System.out.println("Earthquake Added");
			}
				}
				
		catch (Exception ex) {
			System.out.println("File could not be opened or data did not match." + ex);
		}
		
		
		
		
		System.out.print("Im so good at this. BOOM");
		try {
			// set a title for the Window
			primaryStage.setTitle("Earthquake Window");
			
			// get an FXML loader and read in the fxml code
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/EarthquakeData.fxml"));
			AnchorPane mainLayout = (AnchorPane)loader.load();
			
			// Create the scene with the layout in the fxml code, set the scene and show it
			Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
