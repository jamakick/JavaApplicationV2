package application;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;


public class EarthQuake {
		//Create a file object
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
		String command = "";
		

	
	

	
	// No arg-constructor. This means NULL will be used for each value so far
	public EarthQuake() {
		
	}
		

	public EarthQuake(String time, String latitude, String longitude, String depth, 
			String mag, String magType, String nst, String gap, String dMin, String rms, String net,
			String id, String updated, String place, String type, String horizontal, String depthError, 
			String magError, String magNst, String status, String locationSource, String magSource) {
		this.time = time;
		this.latitude = latitude;
		this.locationSource = locationSource;
		this.longitude= longitude;
		this.depth = depth;
		this.mag = mag;
		this.magType = magType;
		this.nst = nst;
		this.gap = gap;
		this.dMin = dMin;
		this.rms = rms;
		this.net = net;
		this.id= id;
		this.updated= updated;
		this.place = place;
		this.type= type;
		this.horizontal=horizontal;
		this.depthError = depthError;
		this.magError= magError;
		this.magNst = magNst;
		this.status = status;
		this.locationSource = locationSource;
		this.magSource = magSource;
	}
		// Getter Methods
		public String getTime() {
			return this.time;
		}
		
		// Compares To Methods
	public int comparetime(EarthQuake comparesTo) {
		return this.getTime().compareTo(comparesTo.getTime());
	}
	
	@Override
	public String toString() {
		return "Earthquake Location: " + locationSource +"\n" + "Preferred data source: "+ net +"\n" + "EarthQuake ID:" + id + "\n" + "Magnitude: "+ mag + "\n" + "Magnitude Type: " + magType + "\n" + "Latitude: " + latitude + "\n" + "Longitude: " + longitude +
				"\n" + "Depth: " + depth + "\n" + "Seismic Stations required: "+ nst + "\n" + "Largest azimuthal gap between stations: "+ gap + "\n" + "Distance to nearest Station: "+ dMin +"\n" + "Location nearest Event: "+
				place + "\n" + "Type of Seismic event: "+ type + "\n"+ "Review Status: " + status +"\n" + "";
	}
}



