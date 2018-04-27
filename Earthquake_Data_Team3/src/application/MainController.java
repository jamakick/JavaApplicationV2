package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import netscape.javascript.JSObject;

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
	
	private GoogleMap map;
	
	private ArrayList<EarthQuake> currentSearchedQuakes;
	
	ArrayList<Marker> markers = new ArrayList<Marker>();
	
	public void currentQuakeList(ArrayList<EarthQuake> currentQuakes) {
		
		currentSearchedQuakes = currentQuakes;
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

	        InfoWindow quakeWindow = new InfoWindow(quakeWindowOptions);
	        
	        map.addUIEventHandler(quakeMarker, UIEventType.click, (JSObject obj) -> {
	            quakeWindow.open(map, quakeMarker);
	        });
	        
			
		}
	}
	
	// Event Listener on Button[#help].onAction
	@FXML
	public void helpAction(ActionEvent event) {
		@SuppressWarnings("unused")
		String outstring= "Summary Button: print out a summary of all of the data (# of events, timerange of the events,etc) Type summary to invoke." + "\n \n" + 
				"Print Button: Prints out all the earthquake events. Type print to invoke." + "\n \n" + "Print By Button: Print out all the Earthquake events, sorted by some field (date, depth, mag, place, status) Click on button, then set field to sort by."
				+ "\n \n" + "Search Button: Print out all of the earthquake events that meet some criteria (date, location, depth, magnitude, magType, place, status). Type search, then set field to search." 
				+ "\n \n" + "Help Button: Prints out the description of buttons and how to invoke them. Type help to invoke."+ "\n \n" + "Type 'quit' to break the command line.";
	}

	
	@FXML
	public void allOutAction(ActionEvent event) {
	}
	
	@FXML
	public void selectionOutAction(ActionEvent event) {
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
	        
			
		}
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		searchDrop.getItems().addAll("Latitude", "Longitude", "Depth", "Magnitude", "Date", "Status", "Place", "Magnitude Type");
		searchDrop.getSelectionModel().select("Latitude");
		
		currentSearchedQuakes = Console.getFileInformation();
		
		mapView.addMapInializedListener(this);
			
	}
	
	@Override
	public void mapInitialized() {
		//LatLong loc1 = new LatLong(39.1710061, -86.51679969999998);
		
		MapOptions mapOptions = new MapOptions();
		
		mapOptions.center(new LatLong(39.1710061, -86.51679969999998)).mapType(MapTypeIdEnum.TERRAIN).zoom(4);
		
		
		map = mapView.createMap(mapOptions, false);
		
		ArrayList<EarthQuake> earthquakes = Console.getFileInformation();
		
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
	        
			
		}
		
//		MarkerOptions markerOptions1 = new MarkerOptions();
//        markerOptions1.position(loc1);
//        
//        Marker loc1Marker = new Marker(markerOptions1);
//  
//		map.addMarker(loc1Marker);
        
	}
}
