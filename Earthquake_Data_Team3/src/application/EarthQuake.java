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
	
	public static void main(String[] args) {
		//Read in data from csv file
		java.io.File file = new java.io.File("all_month.csv");
		try ( Scanner input = new Scanner(file)) {
			//Read first line of headers
			
		}
		catch (Exception ex) {
			System.out.println("File could not be opened or data did not match.");
		}
	}

}
