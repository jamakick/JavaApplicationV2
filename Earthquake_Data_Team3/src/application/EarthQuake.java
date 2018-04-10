package application;

import java.util.Comparator;


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
		String command= "";
		
		
	
	
	

	
	// No arg-constructor. This means NULL will be used for each value so far
	public EarthQuake( ) {
		
	}
		

	//earthquake class.
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
	//will print this out when toString is called.
	@Override
	public String toString() {
		
		return "Earthquake Location: " + locationSource +"\n" + "Preferred data source: "+net+"\n" + "EarthQuake ID:" + id + "\n" + "EarthQuakeUpdate: " + updated + "\n" + "Magnitude: "+ mag + "\n" + "Magnitude Type: " + magType + "\n" +"Network reporting Magntitude: "+ magNst + "\n" + "Uncertainty of reported mangitude: " 
	+ magError + "\n" + "Latitude: " + latitude + "\n" + "Longitude: " + longitude + "\n" + "Depth: " + depth + "\n" + "Seismic Stations required: "+ nst + "\n" + "Largest azimuthal gap between stations: "+ gap + "\n" + "Distance to nearest Station: " +
	dMin +"\n" + "Root mean Square(travel time in seconds): " + rms + "\n" + "Location nearest Event: " + place + "\n" + "Type of Seismic event: "+ type + "\n"+ "Review Status: " + status +"\n" + "Uncertainty of Location in km: " + horizontal + "\n" + "Uncertainty of reported depth in km: " + depthError + "\n" + "Magnitude Source: " + magSource;
	}
	//Getter methods
	public String getTime() {
		return this.time;
	}
	public String getLat() {
		return this.latitude;
	}
	public String getLong() {
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
	public String getMag() {
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
	public String getDepth() {
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
			
	
			//Depth
			public static Comparator<EarthQuake> DepthComparator = new Comparator<EarthQuake>() {
			// Compares To Methods
			public int compare(EarthQuake arg0, EarthQuake arg1) {
				return arg0.getDepth().compareTo(arg1.getDepth());
		}
	};
			//Magnitude
			public static Comparator<EarthQuake> MagnitudeComparator = new Comparator<EarthQuake>() {
			// Compares To Methods
			public int compare(EarthQuake arg0, EarthQuake arg1) {
				return arg0.getMag().compareTo(arg1.getMag());
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
}
