package application;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;


public class EarthQuake {
	public static void main(String[] args) {
		//Create a file object
		/*
		Date time;
		String latitude;
		String longitude;
		String depth;
		String mag;
		String magType;
		int nst;
		String gap;
		String dMin;
		String rms;
		String net;
		String id;
		Date updated;
		String place;
		String type;
		String horizontal;
		String depthError;
		String magError;
		String magNst;
		String status;
		String locationSource;
		String magSource;
		*/
		String time;
		String latitude;
		String longitude;
		String depth;
		String mag;
		String magType;
		String nst;
		String gap;
		String dMin;
		String rms;
		String net;
		String id;
		String updated;
		String place;
		String type;
		String horizontal;
		String depthError;
		String magError;
		String magNst;
		String status;
		String locationSource;
		String magSource;
		

	
	
}
	// No arg-constructor. This means NULL will be used for each value so far
	public EarthQuake( ) {
		
	}
		

	
	public EarthQuake(String time, String latitude, String longitude, String depth, 
			String mag, String magType, String nst, String gap, String dMin, String rms, String net,
			String id, String updated, String place, String type, String horizontal, String depthError, 
			String magError, String magNst, String status, String locationSource, String magSource) {
		

			
	}


	
	
	



public static void commandLine (String[] args) {
	
	Scanner input = new Scanner(System.in);
	System.out.print("Please enter a command: ");
	String command = input.next();
	switch (command) {
	case "help": System.out.println("Sumarry Button: print out a summary of all of the data (# of events, timerange of the events,etc) Click on button to invoke." + "/n" + 
			"Print Button: Prints out all the earthquake events. Click on button to invoke." + "/n" + "Print By Button: Print out all the Earthquake events, sorted by some field (date, depth, mag, place, status) Click on button, then set field to sort by."
			+ "/n" + "Search Button: Print out all of the earthquake events that meet some criteria (date, location, depth, mag, magType, place, status). Click on button, then set field to search." 
			+ "/n" + "Help Button: Prints out the description of buttons and how to invoke them. Click on button to invoke.");
	case "summary": ;
	case "print": ;
	case "printby": ;
	case "search": ; 
				
	}
	}

}