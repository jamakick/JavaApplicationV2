package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class HelpWindowController {
	@FXML
	private Button closeButton;
	@FXML
	private TextArea helpText;

	// Event Listener on Button[#closeButton].onAction
	@FXML
	public void closeButtonAction(ActionEvent event) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void initialize() {
		String text = "Welcome to searchquake, a program that uses USGS earthquake data and outputs it on a map. \n \n";
		text += "Upon startup of the application, all of the data points will be present. \n \n";
		text += "Search: To search by a criteria, select a variable from the drop down and add two criteria. For example, "
				+ "select latitude and input 40 for the min and 60 for the max to get all earthquakes in the northern US."
				+ " To add more criteria on top of that, simply select another variable and new parameters to further specify your search \n \n";
		text += "Reset: To reset to all results, press this button. \n \n";
		text += "Convert selection to text file: Use this button to create a text file (.txt) output with a specified name file name of your choosing. Your specified selection will only be specific if you have ran a search, otherwise it will return all points. \n \n";
		text += "Convert entire setto text file: Use this button to create a text file (.txt) output with all entries in the data. \n \n";
		text += "Map Window: This will take a second to invoke, but once it is loading simply click any data point to review its information. \n \n";
		helpText.setText(text);
		
		helpText.setWrapText(true);
		helpText.setEditable(false);
	}
}
