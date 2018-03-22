package application;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class EarthQuake {
	//Create a file object
	public static void main(String[] args) {
		//Read in data from csv file
		java.io.File theFile = new java.io.File("all_month.csv");
		try (Scanner input = new Scanner(theFile)) {
			//Read first line of headers
			int i = 0;
			while (input.hasNextLine()) {
			String[] theThing = input.nextLine().split(",");
			for (int j = 0; 22 > j; j++) {
			System.out.print(theThing[j] + "\t");}
			System.out.println();
			}
			
		}
		catch (Exception ex) {
			System.out.println("File could not be opened or data did not match.");
		}
	}

}
