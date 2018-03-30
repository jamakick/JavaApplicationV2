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
		

	public EarthQuake(String /*time*/, String /*latitude*/, String /*longitude*/, String /*depth*/, 
			String /*mag*/, String /*magType*/, String /*nst*/, String /*gap*/, String /*dMin*/, String rms, String net,
			String /*id*/, String updated, String /*place*/, String type, String horizontal, String depthError, 
			String magError, String magNst, String status, String locationSource, String magSource) {
		

			
	}
	@Override
	public Override toString() {
		return "Earthquake Location: " + locationSource +"\n" + "Preferred data source: "+net+"\n" + "EarthQuake ID:" + id + "\n" + "Magnitude: "+ mag + "\n" + "Magnitude Type: " + magType + "\n" + "Latitude: " + latitude + "\n" + "Longitude: " + longitude +
				+ "\n" + "Depth: " + depth + "\n" + "Seismic Stations required: "+ nst + "\n" + "Largest azimuthal gap between stations: "+ gap + "\n" + "Distance to nearest Station: "+ dmin +"\n" + "Location nearest Event: "+
				place + "\n" + "Type of Seismic event: "+ type + "\n"+ "Review Status: " + status +"\n" + ""
	}
}



