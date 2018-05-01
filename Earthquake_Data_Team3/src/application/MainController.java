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
	//gets all the variables from our fxml
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
	
	//create our stages and controllers for our two popup windows
	private Stage helpWindowStage;
	private HelpWindowController helpController;
	private Stage fileSaveWindowStage;
	private FileSaveWindowController fileController;

	
	//this is an arrayList that is constantly updated so that we can refine our searches rather than resetting it every time
	public ArrayList<EarthQuake> currentSearchedQuakes;
	
	//this arraylist is used to save to our text files
	public ArrayList<EarthQuake> saveQuakes;
	
	//this arraylist holds all of our earthquake markers so we can remove them when we refine the search
	ArrayList<Marker> markers = new ArrayList<Marker>();
	
	
	//method that takes an arraylist of earthquakes and makes it the new save and searchedquakes lists
	public void currentQuakeList(ArrayList<EarthQuake> currentQuakes) {
		
		currentSearchedQuakes = currentQuakes;
		
		saveQuakes = currentQuakes;
	}
	
	//method that creates new map markers on our gmaps window
	public void newMapMarkers() {
		
		//we use our arraylist to remove all the markers on our map
		map.removeMarkers(markers);
		
		//we then clear the arraylist so we can use it again
		markers.clear();
		
		//we pull in our earthquakes from our currentsearched quakes
		ArrayList<EarthQuake> earthquakes = currentSearchedQuakes;
		
		
		//for every earthquake, we get its lat and long
		for(int i=0;i<earthquakes.size();i++) {
			double latitude = Double.parseDouble(earthquakes.get(i).getLat());
			double longitude = Double.parseDouble(earthquakes.get(i).getLong());
			
			//we construct the latlong
			LatLong quakeLoc= new LatLong(latitude, longitude);
			
			//make a new markeroptions with our latlong
			MarkerOptions quakeOptions = new MarkerOptions();
			quakeOptions.position(quakeLoc);
			
			//make a new marker with the options and add it to the map
			Marker quakeMarker = new Marker(quakeOptions);
			
			map.addMarker(quakeMarker);
			
			//we also add it to our arraylist so we can remove it later
			markers.add(quakeMarker);
			
			//this code adds the info to our marker so when you click you see the toString of the earthquake
			InfoWindowOptions quakeWindowOptions = new InfoWindowOptions();
	        quakeWindowOptions.content("<h3> Earthquake entry #"+ Integer.toString(i) + "</h3> Earthquake ID: "+earthquakes.get(i).getID()+"<br> Date: "+ earthquakes.get(i).getTime()+"<br> Status: "+ earthquakes.get(i).getStatus()+"<br> Place: "+ earthquakes.get(i).getPlace()+ "<br> Latitude: "+ earthquakes.get(i).getLat() + "° <br> Longitude: "
	        		+ earthquakes.get(i).getLong() + "°<br> Magnitude: "+ earthquakes.get(i).getMag()+"<br> Magnitude Type: "+ earthquakes.get(i).getMagType() + "<br> Depth: "+ earthquakes.get(i).getDepth()+" km");
	        
	        EarthQuake quake = earthquakes.get(i);

	        InfoWindow quakeWindow = new InfoWindow(quakeWindowOptions);
	        
	        //this makes it clickable so they don't all show up at once
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
			
			//creates our window
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
		//shows the window
		helpWindowStage.show();
	}

	
	@FXML
	public void allOutAction(ActionEvent event) {
		
		//check is there is a window already
		if (fileSaveWindowStage == null) {
			//if not, we create our window with this block of code
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FileSaveWindow.fxml"));
			AnchorPane fileSaveWindowPane;
			
			//creates our window
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
		//sets this controller to the allOutWindow so it can use saveQuakes
		fileController.setController(this);
		//show the window
		fileSaveWindowStage.show();
	}
	
	@FXML
	public void selectionOutAction(ActionEvent event) {
		
		//check is there is a window already
		if (fileSaveWindowStage == null) {
			//if not, we create our window with this block of code
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FileSaveWindow.fxml"));
			AnchorPane fileSaveWindowPane;
			
			//create window
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
		//show the window and set the controller again to get saveQuakes
		fileController.setController(this);
		fileSaveWindowStage.show();
	}
	
	// Event Listener on Button[#Search].onAction
	@FXML
	public void searchAction(ActionEvent event) {
		
		//create a new earthquake list for our search to put into
		ArrayList<EarthQuake> searchQuakes = new ArrayList<EarthQuake>();
		
		//get the options from our user in the GUI
		String minimum = min.getText();
		String maximum = max.getText();
		String choice = searchDrop.getSelectionModel().getSelectedItem();
		
		//looks at the option made and runs the correct method with our min and max or just min for the equals methods
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
		
		//replace our currentquakelist
		currentQuakeList(searchQuakes);
		//remakes our map markers with the current list
		newMapMarkers();
		
		//shows the user how many earthquakes are being displayed
		numText.setText(Integer.toString(currentSearchedQuakes.size())+" earthquakes shown");
		
	}
	
	@FXML
	public void resetAction(ActionEvent event) {
		//clears the window of all selections
		min.clear();
		max.clear();
		markers.clear();
		searchDrop.getSelectionModel().select("Latitude");
		
		//here we reset our currentquakes back to the original from our console so the search goes back to the original set of data
		ArrayList<EarthQuake> earthquakes = Console.getFileInformation();
		currentQuakeList(earthquakes);
		
		//we rerun our mapinitialize code here to remake all the markers from the original earthquake list
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
	        quakeWindowOptions.content("<h3> Earthquake entry #"+ Integer.toString(i) + "</h3> Earthquake ID: "+earthquakes.get(i).getID()+"<br> Date: "+ earthquakes.get(i).getTime()+"<br> Status: "+ earthquakes.get(i).getStatus()+"<br> Place: "+ earthquakes.get(i).getPlace()+ "<br> Latitude: "+ earthquakes.get(i).getLat() + "° <br> Longitude: "
	        		+ earthquakes.get(i).getLong() + "°<br> Magnitude: "+ earthquakes.get(i).getMag()+"<br> Magnitude Type: "+ earthquakes.get(i).getMagType() + "<br> Depth: "+ earthquakes.get(i).getDepth()+" km");

	        InfoWindow quakeWindow = new InfoWindow(quakeWindowOptions);
	        
	        map.addUIEventHandler(quakeMarker, UIEventType.click, (JSObject obj) -> {
	            quakeWindow.open(map, quakeMarker);
	        });
	        
	        numText.setText(Integer.toString(earthquakes.size())+" earthquakes shown");
	        
			
		}
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		//in our initialize we add the items to our choicebox and select the first one as a default
		searchDrop.getItems().addAll("Latitude", "Longitude", "Depth", "Magnitude", "Date", "Status", "Place", "Magnitude Type");
		searchDrop.getSelectionModel().select("Latitude");
		
		//on initialize we make our current and savequakes the original earthquake list
		currentSearchedQuakes = Console.getFileInformation();
		saveQuakes = Console.getFileInformation();
		
		//add the listener to our map window
		mapView.addMapInializedListener(this);
			
	}
	
	@Override
	public void mapInitialized() {
		//LatLong loc1 = new LatLong(39.1710061, -86.51679969999998);
		
		//the code below makes our gmaps map appear
		
		MapOptions mapOptions = new MapOptions();
		
		mapOptions.center(new LatLong(39.1710061, -86.51679969999998)).mapType(MapTypeIdEnum.TERRAIN).zoom(4);
		
		
		map = mapView.createMap(mapOptions, false);
		
		//we take our original list and initialize the original set of markers that the user sees when the window opens
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
	        quakeWindowOptions.content("<h3> Earthquake entry #"+ Integer.toString(i) + "</h3> Earthquake ID: "+earthquakes.get(i).getID()+"<br> Date: "+ earthquakes.get(i).getTime()+"<br> Status: "+ earthquakes.get(i).getStatus()+"<br> Place: "+ earthquakes.get(i).getPlace()+ "<br> Latitude: "+ earthquakes.get(i).getLat() + "° <br> Longitude: "
	        		+ earthquakes.get(i).getLong() + "°<br> Magnitude: "+ earthquakes.get(i).getMag()+"<br> Magnitude Type: "+ earthquakes.get(i).getMagType() + "<br> Depth: "+ earthquakes.get(i).getDepth()+" km");

	        InfoWindow quakeWindow = new InfoWindow(quakeWindowOptions);
	        
	        map.addUIEventHandler(quakeMarker, UIEventType.click, (JSObject obj) -> {
	            quakeWindow.open(map, quakeMarker);
	        });
	        
	        
			
		}
        
	}
}
