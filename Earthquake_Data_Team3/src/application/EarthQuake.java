package application;
import java.util.Scanner;

public class EarthQuake {
	//Create a file object
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
