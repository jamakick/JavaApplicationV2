package application;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;


public class EarthQuake {
		//Create a file object
		String time;
		double latitude;
		double longitude;
		double depth;
		double mag;
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
		this.latitude = Double.parseDouble(latitude);
		this.locationSource = locationSource;
		this.longitude= Double.parseDouble(longitude);
		this.depth = Double.parseDouble(depth);
		this.mag = Double.parseDouble(mag);
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
		public double getLat() {
			return this.latitude;
		}
		public double getLong() {
			return this.longitude;
		}
		public String getLocSource() {
			return this.locationSource;
		}
		public String getNet() {
			return this.net;
		}
		public String getID() {
			return this.id;
		}
		public String getUpdate() {
			return this.updated;
		}
		public double getMag() {
			return this.mag;
		}
		public String getMagType() {
			return this.magType;
		}
		public String getMagNet() {
			return this.magNst;
		}
		public String getMagError() {
			return this.magError;
		}
		public String getMagSource() {
			return this.magSource;
		}
		public double getDepth() {
			return this.depth;
		}
		public String getDepthError() {
			return this.depthError;
		}
		public String getNst() {
			return this.nst;
		}
		public String getRms() {
			return this.rms;
		}
		public String getPlace() {
			return this.place;
		}
		public String getGap() {
			return this.gap;
		}
		public String getDmin() {
			return this.dMin;
		}
		public String getType() {
			return this.type;
		}
		public String getHorizontal() {
			return this.horizontal;
		}
		public String getStatus() {
			return this.status;
		}
		
		
		
		
		//Latitude
		public static Comparator<EarthQuake> LatitudeComparator = new Comparator<EarthQuake>() {
		// Compares To Methods
		public int compare(EarthQuake arg0, EarthQuake arg1) {
			if (arg0.getLat() < arg1.getLat()) return -1;
			if (arg0.getLat() > arg1.getLat()) return 1;
			return 0;
	}
};
		//Longitude
		public static Comparator<EarthQuake> LongitudeComparator = new Comparator<EarthQuake>() {
		// Compares To Methods
		public int compare(EarthQuake arg0, EarthQuake arg1) {
			if (arg0.getLong() < arg1.getLong()) return -1;
			if (arg0.getLong() > arg1.getLong()) return 1;
			return 0;
	}
};
		//Depth
		public static Comparator<EarthQuake> DepthComparator = new Comparator<EarthQuake>() {
		// Compares To Methods
		public int compare(EarthQuake arg0, EarthQuake arg1) {
			if (arg0.getDepth() < arg1.getDepth()) return -1;
			if (arg0.getDepth() > arg1.getDepth()) return 1;
			return 0;
	}
};
		//Magnitude
		public static Comparator<EarthQuake> MagnitudeComparator = new Comparator<EarthQuake>() {
		// Compares To Methods
		public int compare(EarthQuake arg0, EarthQuake arg1) {
			if (arg0.getMag() < arg1.getMag()) return 1;
			if (arg0.getMag() > arg1.getMag()) return -1;
			return 0;
	}
};
		//Date
		public static Comparator<EarthQuake> DateComparator = new Comparator<EarthQuake>() {
		// Compares To Methods
		public int compare(EarthQuake arg0, EarthQuake arg1) {
			return arg0.getTime().compareTo(arg1.getTime());
	}
};
		public static Comparator<EarthQuake> PlaceComparator = new Comparator<EarthQuake>() {
		// Compares To Methods
		public int compare(EarthQuake arg0, EarthQuake arg1) {
			return arg0.getPlace().compareTo(arg1.getPlace());
	}
};
		public static Comparator<EarthQuake> StatusComparator = new Comparator<EarthQuake>() {
		// Compares To Methods
		public int compare(EarthQuake arg0, EarthQuake arg1) {
			return arg0.getStatus().compareTo(arg1.getStatus());
	}
};

	
	@Override
	public String toString() {
		return "Earthquake Location: " + locationSource +"\n" + "Preferred data source: "+ net +"\n" + "EarthQuake ID:" + id + "\n" + "Magnitude: "+ mag + "\n" + "Magnitude Type: " + magType + "\n" + "Latitude: " + latitude + "\n" + "Longitude: " + longitude +
				"\n" + "Depth: " + depth + "\n" + "Seismic Stations required: "+ nst + "\n" + "Largest azimuthal gap between stations: "+ gap + "\n" + "Distance to nearest Station: "+ dMin +"\n" + "Location nearest Event: "+
				place + "\n" + "Type of Seismic event: "+ type + "\n"+ "Review Status: " + status +"\n" + "";
	}
}



