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

import java.text.ParseException;
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
		case "help": System.out.println("Summary Button: print out a summary of all of the data (# of events, timerange of the events,etc) Type summary to invoke." + "\n" + 
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
			
		case "search": System.out.print("What field do you want to search for, and what arguments would you like to give?: ");
		String searchField = c_input.next();
		switch (searchField.toLowerCase()) {
		
		case "place": 
			String blank = c_input.next();
			String place = c_input.nextLine();
			place = blank + place;
			for (int i = 0; i < (int)arrayLength; i++) {
				String quakePlace = earthArray.get(i).getPlace();
				if(quakePlace.equals(place)) {
					System.out.println(earthArray.get(i));}
			}
			
		break;
		
		case "status": 
			String status = c_input.next();
			for (int i = 0; i < (int)arrayLength; i++) {
				String quakeStatus = earthArray.get(i).getStatus();
			//checks if the earthquakes status matches the argument
				if(quakeStatus.equals(status)) {
					System.out.println(earthArray.get(i));}
		}
			
		break;
		
		case "magtype":
			String magType = c_input.next();
			for (int i = 0; i < (int)arrayLength; i++) {
				String quakeMagType = earthArray.get(i).getMagType();
				if(quakeMagType.equals(magType)) {
					System.out.println(earthArray.get(i));}
				}
			
		break;
			
		case "magnitude":
			String magnitude1 = c_input.next();
			String magnitude2 = c_input.next();
			
			double magNum1 = -1000f;
			double magNum2 = -1000f;
			
			try {
				magNum1 = Double.parseDouble(magnitude1);
				magNum2 = Double.parseDouble(magnitude2);
			} catch(Exception e) {
				System.out.println("Those are not valid magnitudes");
			}
			
			for (int i = 0; i < (int)arrayLength; i++) {
				System.out.println(earthArray.get(i));
				double quakeMag = Double.parseDouble(earthArray.get(i).getMag());
				if(quakeMag >= magNum1 && quakeMag <= magNum2) {
					System.out.println(earthArray.get(i));}
				}
			
		break;
		
		case "depth":
			String depth1 = c_input.next();
			String depth2 = c_input.next();
			
			double depthNum1 = -1000f;
			double depthNum2 = -1000f;
			
			try {
				depthNum1 = Double.parseDouble(depth1);
				depthNum2 = Double.parseDouble(depth2);
			} catch(Exception e) {
				System.out.println("Those are not valid depths");
			}
			
			for (int i = 0; i < (int)arrayLength; i++) {
				double quakeDepth = Double.parseDouble(earthArray.get(i).getDepth());
				if(quakeDepth >= depthNum1 && quakeDepth <= depthNum1) {
					System.out.println(earthArray.get(i));}
				}
			
		break;
		
		case "location":
			String lat1 = c_input.next();
			String long1 = c_input.next();
			String lat2 = c_input.next();
			String long2 = c_input.next();
			
			double latNum1 = 0f;
			double longNum1 = 0f;
			double latNum2 = 0f;
			double longNum2 = 0f;
			
			try {
				latNum1 = Double.parseDouble(lat1);
				longNum1 = Double.parseDouble(long1);
				latNum2 = Double.parseDouble(lat2);
				longNum2 = Double.parseDouble(long2);
			} catch(Exception e) {
				System.out.println("Those are not valid coordinates");
			}
			
			for (int i = 0; i < (int)arrayLength; i++) {
				
				double quakeLat = Double.parseDouble(earthArray.get(i).getLat());
				double quakeLong = Double.parseDouble(earthArray.get(i).getLong());
				
				//nested if statement
				//first we check if our earthquakes lat is in between our two latitude args
				if(quakeLat >= latNum1 && quakeLat <= latNum2) {
					//we then also check if the earthquake long is in between our two longitude args
					if(quakeLong >= longNum1 && quakeLong <= longNum2) {
						//if both of these are true, we add it to our list
						System.out.println(earthArray.get(i));}
				}
			}
			
		break;
		
		case "date":
			String string1 = c_input.next();
			String string2 = c_input.next();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			//define our two dates
			Date date1 = new Date();
			Date date2 = new Date();
			
			//parse our dates
			try {
				date1 = sdf.parse(string1 + " 00:00:00");
				date2 = sdf.parse(string2 + " 00:00:00");
			} catch (ParseException e) {
				//if our dates are incorrect, we tell them they aren't valid dates
				System.out.println("Those are not valid dates");
			}
			
			//loop earthquakes
			for (int i = 0; i < (int)arrayLength; i++) {
				//get the substring of our Time from earthquake, this matches our simpledateformat
				String dateString = earthArray.get(i).getTime().substring(0, 10);
				String timeString = earthArray.get(i).getTime().substring(11, 19);
				
				//define our earthquake date
				Date timeDate = new Date();
				
				//parse our earthquake date
				try {
					timeDate = sdf.parse(dateString + " " + timeString);
				} catch (ParseException e) {
					//if we get an error here, we print the stacktrace
					e.printStackTrace();
				}
				//we check to see if the earthquakes date is after the first date, but before the second date
				if (timeDate.after(date1) && timeDate.before(date2)) {
					//if it is, we add it to our list
					System.out.println(earthArray.get(i));
				}
			}
			
			
			
			
		case "quit": System.out.print(" "); break;
		default: System.out.print("That's not a valid command."); break;
		}
		}
		}
		
		
	}

	public static void main(String[] args) {
		launch(args);
		
		
	}
	
}
