package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.scene.control.Button;

public class EarthquakeDataController {
	@FXML
	private Button help;
	@FXML
	private Button summary;
	@FXML
	private Button print;
	@FXML
	private Button printby;
	@FXML
	private Button search;
	
	
	@FXML
	private void helpButtonClick (ActionEvent event) {
		System.out.println("Help Button Clicked");
	}
	
	@FXML
	private void summaryButtonClick (ActionEvent event) {
		System.out.println("Summary Button Clicked");
	}

	@FXML
	private void printButtonClick (ActionEvent event) {
		System.out.println("Print Button Clicked");
	}
	
	@FXML
	private void printByButtonClick (ActionEvent event) {
		System.out.println("PrintBy Button Clicked");
	}
	
	@FXML
	private void searchButtonClick (ActionEvent event) {
		System.out.println("Search Button Clicked");
	}
}
