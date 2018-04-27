package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelpWindowController {
	@FXML
	private Button closeButton;
	@FXML
	private Label helpTextLabel;

	// Event Listener on Button[#closeButton].onAction
	@FXML
	public void closeButtonAction(ActionEvent event) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}
	
	//make a variable for our controller that we are setting from the placeorder window
	private MainController callingController;
	
	//method to set controller from our other window
	@FXML
	public void setController(MainController c) {
		callingController = c;
	}
	
	@FXML
	public void setHelpText(String helpText) {
		helpTextLabel.setText(helpText);
	}
}
