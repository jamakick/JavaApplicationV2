package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;

public class FileSaveWindowController {
	@FXML
	private Button saveButton;
	@FXML
	private Button cancelButton;
	@FXML
	private TextField fileNameField;
	
	private ArrayList<EarthQuake> currentQuakes;
	
	private MainController callingController;
	@FXML
	public void setController(MainController c) {
		callingController = c;
	}

	// Event Listener on Button[#saveButton].onAction
	@FXML
	public void saveButtonAction(ActionEvent event) {
		
		currentQuakes = callingController.saveQuakes;
		
		String fileName = fileNameField.getText();
		
		String filePath = "C:\\Users\\Jacopo\\Desktop";
		
        try {
            FileWriter writer = new FileWriter(filePath + "\\" + fileName + ".txt", true);
            writer.write(currentQuakes.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		Stage stage = (Stage) saveButton.getScene().getWindow();
		stage.close();
		
	}
	// Event Listener on Button[#cancelButton].onAction
	@FXML
	public void cancelButtonAction(ActionEvent event) {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}
}
