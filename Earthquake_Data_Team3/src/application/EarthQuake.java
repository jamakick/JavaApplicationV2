package application;
import java.util.Scanner;
import java.sql.Date;



public class EarthQuake  {
	//Create a file object
	Date time;
	double latitude;
	double longitude;
	double depth;
	double mag;
	String magType;
	int nst;
	double gap;
	double dMin;
	double rms;
	String net;
	String id;
	Date updated;
	String place;
	String type;
	double horizontal;
	double depthError;
	double magError;
	double magNst;
	String status;
	String locationSource;
	String magSource;
	



	
	
	public EarthQuake() {
		
	}
	
	public EarthQuake(Date time, double latitude, double longitude, double depth, 
			double mag, String magType, int nst, double gap, double dMin, double rms, String net,
			String id, Date updated, String place, String type, double horizontal, double depthError, 
			double magError, double magNst, String status, String locationSource, String magSource) {
		
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