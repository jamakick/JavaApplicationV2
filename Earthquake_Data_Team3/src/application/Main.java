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
			//System.out.print("Got header.");
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
				//System.out.println("Earthquake Adeded");
			}
				}
				
		catch (Exception ex) {
			System.out.println("File could not be opened or data did not match." + ex);
		}
		
		String command = "";
		int arrayLength = earthArray.size();
		Scanner input = new Scanner(System.in);
		while (!command.equals("quit")) {
		System.out.println("Please enter a command: ");
		command = input.next();
		switch (command.toLowerCase()) {
		case "help": System.out.println("Sumarry Button: print out a summary of all of the data (# of events, timerange of the events,etc) Type summary to invoke." + "\n" + 
				"Print Button: Prints out all the earthquake events. Type print to invoke." + "\n" + "Print By Button: Print out all the Earthquake events, sorted by some field (date, depth, mag, place, status) Click on button, then set field to sort by."
				+ "\n" + "Search Button: Print out all of the earthquake events that meet some criteria (date, location, depth, mag, magType, place, status). Type search, then set field to search." 
				+ "\n" + "Help Button: Prints out the description of buttons and how to invoke them. Type help to invoke."); break; 
		case "summary": System.out.println("# of Earthquake events: " + arrayLength + "\nTime of earthquakes are between " + earthArray.get(0).getTime() + " and " + earthArray.get(9905).getTime()); break;
		case "print": for (int i = 0; i < (int)arrayLength; i++) {
			System.out.println(earthArray.get(i).toString());}
			break;
		//prints the events sorted by the specified field.
		case "printby": 
			
			break;
		//searches for the specified field and prints it out.
		case "search": 
			break;
		default: System.out.print("That's not a valid command. "); break;
		}
		}
	
		
		
		
		
		/* System.out.print("Im so good at this. BOOM");
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
		} */
	}
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}

	


