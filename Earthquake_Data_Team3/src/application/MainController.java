package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.ChoiceBox;


public class MainController {
	@FXML
	private Button help;
	@FXML
	private Button dataSummary;
	@FXML
	private TextArea output;
	@FXML
	private Button allEvents;
	@FXML
	private Button searchBy;
	@FXML
	private Button printBy;
	@FXML
	private Button selectionOut;
	@FXML
	private Button allOut;
	@FXML
	private ChoiceBox<String> searchDrop;
	@FXML
	private TextField searchText;
	@FXML
	private TextField searchText2;
	
	
	
	// Event Listener on Button[#help].onAction
	@FXML
	public void helpAction(ActionEvent event) {
		String outstring= "Summary Button: print out a summary of all of the data (# of events, timerange of the events,etc) Type summary to invoke." + "\n \n" + 
				"Print Button: Prints out all the earthquake events. Type print to invoke." + "\n \n" + "Print By Button: Print out all the Earthquake events, sorted by some field (date, depth, mag, place, status) Click on button, then set field to sort by."
				+ "\n \n" + "Search Button: Print out all of the earthquake events that meet some criteria (date, location, depth, magnitude, magType, place, status). Type search, then set field to search." 
				+ "\n \n" + "Help Button: Prints out the description of buttons and how to invoke them. Type help to invoke."+ "\n \n" + "Type 'quit' to break the command line.";
		output.setText(outstring);
	}
	// Event Listener on Button[#dataSummary].onAction
	@FXML
	public void dataSummaryAction(ActionEvent event) {
		output.setText("Data summary...");
	}
	// Event Listener on Button[#allEvents].onAction
	@FXML
	public void allEventsAction(ActionEvent event) {
		output.setText("All events...");
	}
	
	@FXML
	public void allOutAction(ActionEvent event) {
        output.setText("Outputing all to text...");
	}
	
	@FXML
	public void selectionOutAction(ActionEvent event) {
        output.setText("Outputing selection to text...");
	}
	
	// Event Listener on Button[#Search].onAction
	@FXML
	public void searchByAction(ActionEvent event) {
		 output.setText("search by...");
	}
	
	@FXML
	public void printByAction(ActionEvent event) {
		 output.setText("print by...");
	}
	
	@FXML
	public void initialize() {
		output.setEditable(false);
	}
}
