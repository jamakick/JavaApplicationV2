package application;
	
import java.util.Scanner;
import java.util.ArrayList;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Console{
	
	//to make it match our gui controller arguments, all the methods had to take the earthquakes list as an argument
	//this made us able to refine our search since they would search by the current searched quakes and not the getfileinfo quakes
	
	public static ArrayList<EarthQuake> SearchByPlace(String place, ArrayList<EarthQuake> earthquakes) {
		
		//ArrayList<EarthQuake> earthquakes = getFileInformation();
		
		ArrayList<EarthQuake> placeMatch = new ArrayList<EarthQuake>();
		
		for (int i = 0; i < earthquakes.size(); i++) {
			String quakePlace = earthquakes.get(i).getPlace();
			if(quakePlace.equals(place)) {
				placeMatch.add(earthquakes.get(i));}
		}
		
		return placeMatch;
	}
	
	public static ArrayList<EarthQuake> SearchByStatus(String status, ArrayList<EarthQuake> earthquakes) {
		
		//ArrayList<EarthQuake> earthquakes = getFileInformation();
		
		ArrayList<EarthQuake> statusMatch = new ArrayList<EarthQuake>();
		
		for (int i = 0; i < earthquakes.size(); i++) {
			String quakePlace = earthquakes.get(i).getStatus();
			if(quakePlace.equals(status)) {
				statusMatch.add(earthquakes.get(i));}
		}
		
		return statusMatch;
	}
	
	public static ArrayList<EarthQuake> SearchByMagType(String magType, ArrayList<EarthQuake> earthquakes) {
		
		//ArrayList<EarthQuake> earthquakes = getFileInformation();
		
		ArrayList<EarthQuake> magTypeMatch = new ArrayList<EarthQuake>();
		
		for (int i = 0; i < earthquakes.size(); i++) {
			String quakePlace = earthquakes.get(i).getMagType();
			if(quakePlace.equals(magType)) {
				magTypeMatch.add(earthquakes.get(i));}
		}
		
		return magTypeMatch;
	}
	
	public static ArrayList<EarthQuake> SearchByMag(String mag1, String mag2, ArrayList<EarthQuake> earthquakes) {
		
		//ArrayList<EarthQuake> earthquakes = getFileInformation();
		
		ArrayList<EarthQuake> magBetween = new ArrayList<EarthQuake>();
		
		double magNum1 = -1000f;
		double magNum2 = -1000f;
		
		try {
			magNum1 = Double.parseDouble(mag1);
			magNum2 = Double.parseDouble(mag2);
		} catch(Exception e) {
			System.out.println("Those are not valid magnitudes");
		}
		
		for (int i = 0; i < earthquakes.size(); i++) {
			double quakeMag = Double.parseDouble(earthquakes.get(i).getMag());
			if(quakeMag >= magNum1 && quakeMag <= magNum2) {
				magBetween.add(earthquakes.get(i));}
			}
		
		return magBetween;
	}
	
	public static ArrayList<EarthQuake> SearchByDepth(String depth1, String depth2, ArrayList<EarthQuake> earthquakes) {
		
		//ArrayList<EarthQuake> earthquakes = getFileInformation();
		
		ArrayList<EarthQuake> depthBetween = new ArrayList<EarthQuake>();
		
		double depthNum1 = -1000f;
		double depthNum2 = -1000f;
		
		try {
			depthNum1 = Double.parseDouble(depth1);
			depthNum2 = Double.parseDouble(depth2);
		} catch(Exception e) {
			System.out.println("Those are not valid magnitudes");
		}
		
		for (int i = 0; i < earthquakes.size(); i++) {
			double quakeMag = Double.parseDouble(earthquakes.get(i).getDepth());
			if(quakeMag >= depthNum1 && quakeMag <= depthNum2) {
				depthBetween.add(earthquakes.get(i));}
			}
		
		return depthBetween;
	}
	
	public static ArrayList<EarthQuake> SearchByLoc(String lat1, String long1, String lat2, String long2, ArrayList<EarthQuake> earthquakes) {
		
		//ArrayList<EarthQuake> earthquakes = getFileInformation();
		
		ArrayList<EarthQuake> locBetween = new ArrayList<EarthQuake>();
		
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
		
		for (int i = 0; i < earthquakes.size(); i++) {
			
			double quakeLat = Double.parseDouble(earthquakes.get(i).getLat());
			double quakeLong = Double.parseDouble(earthquakes.get(i).getLong());
			
			//nested if statement
			//first we check if our earthquakes lat is in between our two latitude args
			if(quakeLat >= latNum1 && quakeLat <= latNum2) {
				//we then also check if the earthquake long is in between our two longitude args
				if(quakeLong >= longNum1 && quakeLong <= longNum2) {
					//if both of these are true, we add it to our list
					locBetween.add(earthquakes.get(i));}
			}
		}
		
		return locBetween;
	}
	
	//this searchbylat was added so that we can distinguish between latitude and longitude in our gui, 
	//so you don't have to search by both at the same time
	public static ArrayList<EarthQuake> SearchByLat(String lat1, String lat2, ArrayList<EarthQuake> earthquakes) {
		
		//ArrayList<EarthQuake> earthquakes = getFileInformation();
		
		ArrayList<EarthQuake> latBetween = new ArrayList<EarthQuake>();
		
		double latNum1 = 0f;
		double latNum2 = 0f;
		
		try {
			latNum1 = Double.parseDouble(lat1);;
			latNum2 = Double.parseDouble(lat2);
		} catch(Exception e) {
			System.out.println("Those are not valid coordinates");
		}
		
		for (int i = 0; i < earthquakes.size(); i++) {
			
			double quakeLat = Double.parseDouble(earthquakes.get(i).getLat());
			
			//first we check if our earthquakes lat is in between our two latitude args
			if(quakeLat >= latNum1 && quakeLat <= latNum2) {
					latBetween.add(earthquakes.get(i));}
		}
		
		return latBetween;
	}
	
	//this searchbylong was added so that we can distinguish between latitude and longitude in our gui, 
	//so you don't have to search by both at the same time
	public static ArrayList<EarthQuake> SearchByLong(String long1, String long2, ArrayList<EarthQuake> earthquakes) {
		
		//ArrayList<EarthQuake> earthquakes = getFileInformation();
		
		ArrayList<EarthQuake> longBetween = new ArrayList<EarthQuake>();
		
		double longNum1 = 0f;
		double longNum2 = 0f;
		
		try {
			longNum1 = Double.parseDouble(long1);;
			longNum2 = Double.parseDouble(long2);
		} catch(Exception e) {
			System.out.println("Those are not valid coordinates");
		}
		
		for (int i = 0; i < earthquakes.size(); i++) {
			
			double quakeLong = Double.parseDouble(earthquakes.get(i).getLong());
			
			//first we check if our earthquakes long is in between our two longitude args
			if(quakeLong >= longNum1 && quakeLong <= longNum2) {
					longBetween.add(earthquakes.get(i));}
		}
		
		return longBetween;
	}
	
	public static ArrayList<EarthQuake> SearchByDate(String string1, String string2, ArrayList<EarthQuake> earthquakes) {
		
		//ArrayList<EarthQuake> earthquakes = getFileInformation();
		
		ArrayList<EarthQuake> dateBetween = new ArrayList<EarthQuake>();
		
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
		for (int i = 0; i < earthquakes.size(); i++) {
			//get the substring of our Time from earthquake, this matches our simpledateformat
			String dateString = earthquakes.get(i).getTime().substring(0, 10);
			String timeString = earthquakes.get(i).getTime().substring(11, 19);
			
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
				dateBetween.add(earthquakes.get(i));
			}
		}
		
		return dateBetween;
	}
	
	
	//restructured the arraylist being made into a method and added null checking
	public static ArrayList<EarthQuake> getFileInformation() {
		
		ArrayList<EarthQuake> earthArray = new ArrayList<>();
		
		//define our variables for the earthquake object
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
		String horError;
		String depthError;
		String magError;
		String magNst;
		String status;
		String locSource;
		String magSource;
		
		//Read in data from csv file
		java.io.File theFile = new java.io.File("all_month1.csv");
		try (Scanner input = new Scanner(theFile)) {
			//Read first line of headers
			
			@SuppressWarnings("unused")
			String[] theHeader = input.nextLine().split(",");
			
			//takes the data from the file and makes it an array line by line.
			while (input.hasNextLine()) {
				String[] theThing = input.nextLine().split(",");;
				
				//2018-02-27T14:40:10.010Z
        		if (theThing[0].equals(""))
        			time = "No time given";
        		else
        			time = theThing[0];
        		//38.7888333
        		if (theThing[1].equals(""))
        			latitude = "0";
        		else
        			latitude = theThing[1];
        		//-122.8001667
        		if (theThing[2].equals(""))
        			longitude = "0";
        		else
        			longitude = theThing[2];
        		//4.22
        		if (theThing[3].equals(""))
        			depth = "0";
        		else
        			depth = theThing[3];
        		//0.3
        		if (theThing[4].equals(""))
        			mag = "0";
        		else
        			mag = theThing[4];
        		//md
        		if (theThing[5].equals(""))
        			magType = "null";
        		else
        			magType = theThing[5];
        		//22	
        		if (theThing[6].equals(""))
        			nst = "0";
        		else
        			nst = theThing[6];
        		//132.0
        		if (theThing[7].equals(""))
        			gap = "0";
        		else
        			gap = theThing[7];
        		//0.01173
        		if (theThing[8].equals(""))
        			dMin = "0";
        		else
        			dMin = theThing[8];
        		//.02
        		if (theThing[9].equals(""))
        			rms = "0";
        		else
        			rms = theThing[9];
        		//nc
        		if (theThing[10].equals(""))
        			net = "null";
        		else
        			net = theThing[10];
        		//nc72991180
        		if (theThing[11].equals(""))
        			id = "null";
        		else
        			id = theThing[11];
        		//2018-03-29T14:31:02.753Z
        		if (theThing[12].equals(""))
        			updated = "null";
        		else
        			updated = theThing[12];
        		//"4km WNW of The Geysers, CA"
        		if (theThing[13].equals(""))
        			place = "null";
        		else
        			place = theThing[13];
        		//earthquake
        		if (theThing[14].equals(""))
        			type = "null";
        		else
        			type = theThing[14];
        		//0.26
        		if (theThing[15].equals(""))
        			horError = "0";
        		else
        			horError = theThing[15];
        		//0.52
        		if (theThing[16].equals(""))
        			depthError = "0";
        		else
        			depthError = theThing[16];
        		//0.15
        		if (theThing[17].equals(""))
        			magError = "0";
        		else
        			magError = theThing[17];
        		//3
        		if (theThing[18].equals(""))
        			magNst = "0";
        		else
        			magNst = theThing[18];
        		//automatic
        		if (theThing[19].equals(""))
        			status = "null";
        		else
        			status = theThing[19];
        		//nc
        		if (theThing[20].equals(""))
        			locSource = "null";
        		else
        			locSource = theThing[20];
        		//nc
        		if (theThing[21].equals(""))
        			magSource = "null";
        		else
        			magSource = theThing[21];
        		
        		//once we have all the variables, with defaults for those that were null
        	    
        		//create an earthquake with all the variable
        		EarthQuake quake = new EarthQuake(time, latitude, longitude, depth,  mag, magType,
        				nst, gap, dMin, rms, net, id, updated, place,
        				type, horError, depthError, magError, 
        				magNst, status, locSource, magSource);
        		earthArray.add(quake);
			}
				}
		catch ( Exception ex )  {
			System.out.println("File could not be opened or data did not match." + ex);
		}
		
		return earthArray;
		
	}
	
	public static String arrayListToString(ArrayList<EarthQuake> earthArray) {
		
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
		double arrayLength= earthArray.size();
		double arrayLengthD = arrayLength;
		
		for (int i = 0; i < (int)arrayLength; i++) {
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
			return "# of Earthquake events: " + arrayLength + "\n" + "Timerange: " + 
			earthArray.get(0).getTime() + " and " + earthArray.get(9905).getTime() + "\n" + "Average Magnitude: " + avgM + "\n"
			+ "Average Depth: " + avgD + "\n" + "Average Gap: " + avgG + "\n" + "Average Nst: " + avgN + "\n" + "Average RMS: "+ avgR;
		
		
	}
	
	//the below code is our console code that ran the command prompt
	
//	@Override
//	public void start() {
//		
//		ArrayList<EarthQuake> earthArray = getFileInformation();
//
//		//Asks for a command to run
//		String command = "";
//		int arrayLength = earthArray.size();
//		Scanner c_input = new Scanner(System.in);
//
//		while (!command.equals("exit")) {
//		System.out.println("Please enter a command: ");
//		command = c_input.next();
//		
//		switch (command.toLowerCase()) {
//		//explains what each command does, and explains how to run it. 
//		case "help": System.out.println("Summary Button: print out a summary of all of the data (# of events, timerange of the events,etc) Type summary to invoke." + "\n" + 
//				"Print Button: Prints out all the earthquake events. Type print to invoke." + "\n" + "Print By Button: Print out all the Earthquake events, sorted by some field (date, depth, mag, place, status) Click on button, then set field to sort by."
//				+ "\n" + "Search Button: Print out all of the earthquake events that meet some criteria (date, location, depth, mag, magType, place, status). Type search, then set field to search." 
//				+ "\n" + "Help Button: Prints out the description of buttons and how to invoke them. Type help to invoke."+ "\n" + "Type 'exit' to break the command line."); break; 
//		//prints the number of earthquake events, timerange etc.
//		case "summary":
//			System.out.println(arrayListToString(earthArray));
//    		  break;
//		//displays the earthquake events line by line
//		case "print": for (int i = 0; i < (int)arrayLength; i++) {
//			System.out.println(earthArray.get(i).toString());}
//			break;
//		//prints the events sorted by the specified field.
//	        case "printby": 
//			System.out.println("Please enter a printBy: ");
//			String printbyStuff = c_input.next();
//			switch (printbyStuff.toLowerCase()) {
//			case "depth" :
//				Collections.sort(earthArray, EarthQuake.DepthComparator);
//				for(EarthQuake earth: earthArray) {
//					System.out.println(earth);
//				}break;
//			case "date" :
//				Collections.sort(earthArray, EarthQuake.DateComparator);
//				for(EarthQuake earth: earthArray) {
//					System.out.println(earth);
//				}break;
//			case "mag" :
//				Collections.sort(earthArray, EarthQuake.MagnitudeComparator);
//				for(EarthQuake earth: earthArray) {
//					System.out.println(earth);
//				}break;
//			case "place" :
//				Collections.sort(earthArray, EarthQuake.PlaceComparator);
//				for(EarthQuake earth: earthArray) {
//					System.out.println(earth);
//				}break;
//			case "status" :
//				Collections.sort(earthArray, EarthQuake.StatusComparator);
//				for(EarthQuake earth: earthArray) {
//					System.out.println(earth);
//				} break;
//				
//			
//			}
//			
//			
//
//			
//			break;
//			
//			
//		//searches for the specified field and prints it out.
//			
//		case "search": System.out.print("What field do you want to search for, and what arguments would you like to give?: ");
//		String searchField = c_input.next();
//		switch (searchField.toLowerCase()) {
//		
//		case "place": 
//			String blank = c_input.next();
//			String place = c_input.nextLine();
//			place = blank + place;
//			System.out.println(SearchByPlace(place));
//
//			
//		break;
//		
//		case "status": 
//			String status = c_input.next();
//			System.out.println(SearchByStatus(status));
//			
//		break;
//		
//		case "magtype":
//			String magType = c_input.next();
//			System.out.println(SearchByMagType(magType));
//			
//		break;
//			
//		case "magnitude":
//			String magnitude1 = c_input.next();
//			String magnitude2 = c_input.next();
//			System.out.println(SearchByMag(magnitude1, magnitude2));
//			
//		break;
//		
//		case "depth":
//			String depth1 = c_input.next();
//			String depth2 = c_input.next();
//			System.out.println(SearchByDepth(depth1, depth2));
//			
//		break;
//		
//		case "location":
//			String lat1 = c_input.next();
//			String long1 = c_input.next();
//			String lat2 = c_input.next();
//			String long2 = c_input.next();
//			System.out.println(SearchByLoc(lat1, long1, lat2, long2));
//			
//		break;
//		
//		case "date":
//			String string1 = c_input.next();
//			String string2 = c_input.next();
//			System.out.println(SearchByDate(string1, string2));
//			
//		break;	
//			
//		case "quit": System.out.print(" "); break;
//		default: System.out.print("That's not a valid command."); break;
//		}
//		}
//		}
//		
//		
//	}
}

