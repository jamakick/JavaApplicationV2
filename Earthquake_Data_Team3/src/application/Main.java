package application;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Scanner;

public class Main extends Application {
	private static ArrayList<EarthQuake> earthArray = new ArrayList<>();
	@Override
	public void start(Stage primaryStage) {



		//Read in data from csv file
		java.io.File theFile = new java.io.File("all_month1.csv");
		try (Scanner input = new Scanner(theFile)) {
			//Read first line of headers
			
			@SuppressWarnings("unused")
			String[] theHeader = input.nextLine().split(",");

			//takes the data from the file and makes it an array line by line.
			while (input.hasNextLine()) {
				String[] theThing = input.nextLine().split(",");
				//inputs each field into the array.
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


			}
		}
		catch ( Exception ex )  {
			System.out.println("File could not be opened or data did not match." + ex);
		}
		//Asks for a command to run
		String command = "";
		int arrayLength = earthArray.size();
		Scanner c_input = new Scanner(System.in);
		double totalM= 0.0;
		double avgM = 0.0;
		double avgD = 0.0;
		double totalD= 0.0;
		double avgG = 0.0;
		double totalG= 0.0;
		double avgN = 0.0;
		double totalN= 0.0;
		double avgR = 0.0;
		double totalR= 0.0;
		double arrayLengthD = arrayLength;
		while (!command.equals("quit")) {
			System.out.println("Please enter a command: ");
			command = c_input.next();
			switch (command.toLowerCase()) {
			//explains what each command does, and explains how to run it. 
			case "help": System.out.println("Sumarry Button: print out a summary of all of the data (# of events, timerange of the events,etc) Type summary to invoke." + "\n" + 
					"Print Button: Prints out all the earthquake events. Type print to invoke." + "\n" + "Print By Button: Print out all the Earthquake events, sorted by some field (date, depth, mag, place, status) Click on button, then set field to sort by."
					+ "\n" + "Search Button: Print out all of the earthquake events that meet some criteria (date, location, depth, mag, magType, place, status). Type search, then set field to search." 
					+ "\n" + "Help Button: Prints out the description of buttons and how to invoke them. Type help to invoke."+ "\n" + "Type 'quit' to break the command line."); break; 
					//prints the number of earthquake events, timerange etc.
			case "summary": for (int i = 0; i < (int)arrayLength; i++) {
				String sValue = earthArray.get(i).getMag();
				if (sValue.equals("")) {

				} else {
					double valueM = Double.parseDouble(sValue);
					totalM += valueM;
				}

				avgM = totalM /arrayLengthD;
			}
			for (int i = 0; i < (int)arrayLength; i++) {
				String dValue = earthArray.get(i).getDepth();
				if (dValue.equals("")) {

				} else {
					double valueD = Double.parseDouble(dValue);
					totalD += valueD;
				}

				avgD = totalD /arrayLengthD;
			}
			for (int i = 0; i < (int)arrayLength; i++) {
				String gValue = earthArray.get(i).getGap();
				if (gValue.equals("")) {

				} else {
					double valueG = Double.parseDouble(gValue);
					totalG += valueG;
				}

				avgG = totalG /arrayLengthD;
			}
			for (int i = 0; i < (int)arrayLength; i++) {
				String nValue = earthArray.get(i).getNst();
				if (nValue.equals("")) {

				} else {
					double valueN = Double.parseDouble(nValue);
					totalN += valueN;
				}

				avgN = totalN /arrayLengthD;
			}
			for (int i = 0; i < (int)arrayLength; i++) {
				String rValue = earthArray.get(i).getRms();
				if (rValue.equals("")) {

				} else {
					double valueR = Double.parseDouble(rValue);
					totalR += valueR;
				}

				avgR = totalR /arrayLengthD;
			}
			System.out.println("# of Earthquake events: " + arrayLength + "\n" + "Timerange: " + 
					earthArray.get(0).getTime() + " and " + earthArray.get(9905).getTime() + "\n" + "Average Magnitude: " + avgM + "\n"
					+ "Average Depth: " + avgD + "\n" + "Average Gap: " + avgG + "\n" + "Average Nst: " + avgN + "\n" + "Average RMS: "+ avgR);

			break;
			//displays the earthquake events line by line
			case "print": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).toString());}
			break;
			//prints the events sorted by the specified field.
			case "printby": 
				System.out.println("Please enter a printBy: ");
				String printbyStuff = c_input.next();
				switch (printbyStuff.toLowerCase()) {
				case "depth" :
					Collections.sort(earthArray, EarthQuake.DepthComparator);
					for(EarthQuake earth: earthArray) {
						System.out.println(earth);
					}break;
				case "date" :
					Collections.sort(earthArray, EarthQuake.DateComparator);
					for(EarthQuake earth: earthArray) {
						System.out.println(earth);
					}break;
				case "mag" :
					Collections.sort(earthArray, EarthQuake.MagnitudeComparator);
					for(EarthQuake earth: earthArray) {
						System.out.println(earth);
					}break;
				case "place" :
					Collections.sort(earthArray, EarthQuake.PlaceComparator);
					for(EarthQuake earth: earthArray) {
						System.out.println(earth);
					}break;
				case "status" :
					Collections.sort(earthArray, EarthQuake.StatusComparator);
					for(EarthQuake earth: earthArray) {
						System.out.println(earth);
					} break;


				}




				break;


				//searches for the specified field and prints it out.

			case "search": System.out.print("What field do you want to search for?: ");
			String searchField = c_input.next();
			switch (searchField.toLowerCase()) {
			case "time": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getTime());}

			break;
			case "latitude": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getLat());}

			break;
			case "longitude": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getLong());}

			break;
			case "locationsource": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getLocSource());}

			break;
			case "net": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getNet());}

			break;
			case "id": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getID());}

			break;
			case "updated": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getUpdate());}

			break;
			case "mag": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getMag());}

			break;
			case "magtype": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getMagType());}

			break;
			case "magnst": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getMagNet());}

			break;
			case "magerror": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getMagError());}

			break;
			case "magsource": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getMagSource());}

			break;
			case "depth": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getDepth());}

			break;
			case "deptherror": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getDepthError());}

			break;
			case "nst": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getNst());} break;
			case "rms": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getRms());}

			break;
			case "place": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getPlace());}

			break;
			case "gap": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getGap());}

			break;
			case "dmin": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getDmin());}

			break;
			case "type": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getType());}

			break;
			case "horizontal": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getHorizontal());}

			break;
			case "status": for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i).getStatus());}

			break;

			}
			break;
			case "quit": System.out.print(" "); break;
			default: System.out.print("That's not a valid command."); break;
			}
		}

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
