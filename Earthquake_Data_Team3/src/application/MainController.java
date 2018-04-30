package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;


public class MainController implements Initializable, MapComponentInitializedListener{
	@FXML
	private Button help;
	@FXML
	private Button search;
	@FXML
	private Button reset;
	@FXML
	private Button selectionOut;
	@FXML
	private Button allOut;
	@FXML
	private ChoiceBox<String> searchDrop;
	@FXML
	private TextField min;
	@FXML
	private TextField max;
	@FXML
	private GoogleMapView mapView;
	@FXML
	private Label numText;
	
	private GoogleMap map;
	
	private Stage helpWindowStage;
	private HelpWindowController helpController;
	
	
	private Stage fileSaveWindowStage;
	private FileSaveWindowController fileController;

	
	
	public ArrayList<EarthQuake> currentSearchedQuakes;
	
	public ArrayList<EarthQuake> saveQuakes;
	
	ArrayList<Marker> markers = new ArrayList<Marker>();
	
	public void currentQuakeList(ArrayList<EarthQuake> currentQuakes) {
		
		currentSearchedQuakes = currentQuakes;
		
		saveQuakes = currentQuakes;
	}
	
	public void newMapMarkers() {
		
		map.removeMarkers(markers);
		
		markers.clear();
		
		ArrayList<EarthQuake> earthquakes = currentSearchedQuakes;
		
		for(int i=0;i<earthquakes.size();i++) {
			double latitude = Double.parseDouble(earthquakes.get(i).getLat());
			double longitude = Double.parseDouble(earthquakes.get(i).getLong());
			
			LatLong quakeLoc= new LatLong(latitude, longitude);
			
			MarkerOptions quakeOptions = new MarkerOptions();
			quakeOptions.position(quakeLoc);
			
			Marker quakeMarker = new Marker(quakeOptions);
			
			map.addMarker(quakeMarker);
			
			markers.add(quakeMarker);
			
			InfoWindowOptions quakeWindowOptions = new InfoWindowOptions();
	        quakeWindowOptions.content(earthquakes.get(i).toString());
	        
	        EarthQuake quake = earthquakes.get(i);

	        InfoWindow quakeWindow = new InfoWindow(quakeWindowOptions);
	        
	        map.addUIEventHandler(quakeMarker, UIEventType.click, (JSObject obj) -> {
	        	saveQuakes.add(quake);
	            quakeWindow.open(map, quakeMarker);
	        });
	        
			
		}
	}
	
	// Event Listener on Button[#help].onAction
	@FXML
	public void helpAction(ActionEvent event) {
		
		
		//check is there is a window already
		if (helpWindowStage == null) {
			//if not, we create our window with this block of code
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/HelpWindow.fxml"));
			AnchorPane helpWindowPane;
			
			try {
				helpWindowPane = (AnchorPane)loader.load();
				Scene helpWindowScene = new Scene(helpWindowPane);
				helpWindowStage = new Stage();
				helpWindowStage.setScene(helpWindowScene);
				helpWindowStage.setTitle("Help Window");
				helpController = (HelpWindowController)loader.getController();
				}
			
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		helpWindowStage.show();
	}

	
	@FXML
	public void allOutAction(ActionEvent event) {
		
		//check is there is a window already
		if (fileSaveWindowStage == null) {
			//if not, we create our window with this block of code
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FileSaveWindow.fxml"));
			AnchorPane fileSaveWindowPane;
			
			try {
				fileSaveWindowPane = (AnchorPane)loader.load();
				Scene fileSaveWindowScene = new Scene(fileSaveWindowPane);
				fileSaveWindowStage = new Stage();
				fileSaveWindowStage.setScene(fileSaveWindowScene);
				fileSaveWindowStage.setTitle("File Save Window");
				fileController = (FileSaveWindowController)loader.getController();
				}
			
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		fileController.setController(this);
		fileSaveWindowStage.show();
	}
	
	@FXML
	public void selectionOutAction(ActionEvent event) {
		
		//check is there is a window already
		if (fileSaveWindowStage == null) {
			//if not, we create our window with this block of code
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FileSaveWindow.fxml"));
			AnchorPane fileSaveWindowPane;
			
			try {
				fileSaveWindowPane = (AnchorPane)loader.load();
				Scene fileSaveWindowScene = new Scene(fileSaveWindowPane);
				fileSaveWindowStage = new Stage();
				fileSaveWindowStage.setScene(fileSaveWindowScene);
				fileSaveWindowStage.setTitle("File Save Window");
				fileController = (FileSaveWindowController)loader.getController();
				}
			
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		fileController.setController(this);
		fileSaveWindowStage.show();
	}
	
	// Event Listener on Button[#Search].onAction
	@FXML
	public void searchAction(ActionEvent event) {
		
		ArrayList<EarthQuake> searchQuakes = new ArrayList<EarthQuake>();
		
		String minimum = min.getText();
		String maximum = max.getText();
		String choice = searchDrop.getSelectionModel().getSelectedItem();
		
		switch (choice) {
		
		case "Date":
			searchQuakes = Console.SearchByDate(minimum, maximum, currentSearchedQuakes);
			break;
		
		case "Latitude":
			searchQuakes = Console.SearchByLat(minimum, maximum, currentSearchedQuakes);
			break;
		
		case "Longitude":
			searchQuakes = Console.SearchByLong(minimum, maximum, currentSearchedQuakes);
			break;
			
		case "Depth":
			searchQuakes = Console.SearchByDepth(minimum, maximum, currentSearchedQuakes);
			break;
			
		case "Magnitude":
			searchQuakes = Console.SearchByMag(minimum, maximum, currentSearchedQuakes);
			break;
			
		case "Status":
			searchQuakes = Console.SearchByStatus(minimum, currentSearchedQuakes);
			break;
			
		case "Place":
			searchQuakes = Console.SearchByPlace(minimum, currentSearchedQuakes);
			break;
			
		case "Magnitude Type":
			searchQuakes = Console.SearchByMagType(minimum, currentSearchedQuakes);
			break;
		}
		
		currentQuakeList(searchQuakes);
		newMapMarkers();
		
		numText.setText(Integer.toString(currentSearchedQuakes.size())+" earthquakes shown");
		
	}
	
	@FXML
	public void resetAction(ActionEvent event) {
		min.clear();
		max.clear();
		markers.clear();
		searchDrop.getSelectionModel().select("Latitude");
		
		ArrayList<EarthQuake> earthquakes = Console.getFileInformation();
		currentQuakeList(earthquakes);
		
		for(int i=0;i<earthquakes.size();i++) {
			double latitude = Double.parseDouble(earthquakes.get(i).getLat());
			double longitude = Double.parseDouble(earthquakes.get(i).getLong());
			
			LatLong quakeLoc= new LatLong(latitude, longitude);
			
			MarkerOptions quakeOptions = new MarkerOptions();
			quakeOptions.position(quakeLoc);
			
			Marker quakeMarker = new Marker(quakeOptions);
			
			map.addMarker(quakeMarker);
			
			markers.add(quakeMarker);
			
			InfoWindowOptions quakeWindowOptions = new InfoWindowOptions();
	        quakeWindowOptions.content(earthquakes.get(i).toString());

	        InfoWindow quakeWindow = new InfoWindow(quakeWindowOptions);
	        
	        map.addUIEventHandler(quakeMarker, UIEventType.click, (JSObject obj) -> {
	            quakeWindow.open(map, quakeMarker);
	        });
	        
	        numText.setText(Integer.toString(earthquakes.size())+" earthquakes shown");
	        
			
		}
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		searchDrop.getItems().addAll("Latitude", "Longitude", "Depth", "Magnitude", "Date", "Status", "Place", "Magnitude Type");
		searchDrop.getSelectionModel().select("Latitude");
		
		
		currentSearchedQuakes = Console.getFileInformation();
		saveQuakes = Console.getFileInformation();
		
		
		mapView.addMapInializedListener(this);
			
	}
	
	@Override
	public void mapInitialized() {
		//LatLong loc1 = new LatLong(39.1710061, -86.51679969999998);
		
		MapOptions mapOptions = new MapOptions();
		
		mapOptions.center(new LatLong(39.1710061, -86.51679969999998)).mapType(MapTypeIdEnum.TERRAIN).zoom(4);
		
		
		map = mapView.createMap(mapOptions, false);
		
		
		ArrayList<EarthQuake> earthquakes = Console.getFileInformation();
		numText.setText(Integer.toString(earthquakes.size())+" earthquakes shown");
		
		for(int i=0;i<earthquakes.size();i++) {
			double latitude = Double.parseDouble(earthquakes.get(i).getLat());
			double longitude = Double.parseDouble(earthquakes.get(i).getLong());
			
			LatLong quakeLoc= new LatLong(latitude, longitude);
			
			MarkerOptions quakeOptions = new MarkerOptions();
			quakeOptions.position(quakeLoc);
			
			Marker quakeMarker = new Marker(quakeOptions);
			
			map.addMarker(quakeMarker);
			
			markers.add(quakeMarker);
			
			InfoWindowOptions quakeWindowOptions = new InfoWindowOptions();
			
			//window text
	        quakeWindowOptions.content("<h3> Earthquake entry #"+ Integer.toString(i) + "</h3> Earthquake ID: "+earthquakes.get(i).getID()+"<br> Place: "+ earthquakes.get(i).getPlace()+ "<br> Latitude: "+ earthquakes.get(i).getLat() + "° <br> Longitude: "
	        		+ earthquakes.get(i).getLong() + "°<br> Magnitude: "+ earthquakes.get(i).getMag() + "<br> Depth: "+ earthquakes.get(i).getDepth()+" km");

	        InfoWindow quakeWindow = new InfoWindow(quakeWindowOptions);
	        
	        map.addUIEventHandler(quakeMarker, UIEventType.click, (JSObject obj) -> {
	            quakeWindow.open(map, quakeMarker);
	        });
	        
	        
			
		}
        
	}
}
