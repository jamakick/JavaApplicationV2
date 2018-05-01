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
	
	//lets our savewindow call the savequakes variable from our maincontroller
	public void setController(MainController c) {
		callingController = c;
	}

	// Event Listener on Button[#saveButton].onAction
	@FXML
	public void saveButtonAction(ActionEvent event) {
		
		//get the savequakes from maincontroller
		//the way that we can select only 1 quake once we search is that saveQuakes will either save the arraylist when you refine the search
		//or it will save just the single point once you click on it's marker. This allows our one window to handle both cases.
		currentQuakes = callingController.saveQuakes;
		
		String fileName = fileNameField.getText();
		
		//we had the file path set absolute to my desktop to test
		//String filePath = "C:\\Users\\Jacopo\\Desktop";
		
        try {
        	//we make a new filewriter with the filename and a .txt at the end to make sure it writes as a text file
            FileWriter writer = new FileWriter(fileName + ".txt", true);
            //we write the quakes from our controller to the file
            writer.write(currentQuakes.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //make the window close once you click the button and it saves
		Stage stage = (Stage) saveButton.getScene().getWindow();
		stage.close();
		
	}
	// Event Listener on Button[#cancelButton].onAction
	@FXML
	public void cancelButtonAction(ActionEvent event) {
		//cancel button will close the window
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}
}
