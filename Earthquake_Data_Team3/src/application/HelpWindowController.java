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
	
	@FXML
	public void setHelpText(String helpText) {
		helpTextLabel.setText(helpText);
	}
}
