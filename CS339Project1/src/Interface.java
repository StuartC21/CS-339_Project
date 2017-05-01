import java.util.ArrayList;
import java.util.function.Predicate;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Interface extends Application implements EventHandler<ActionEvent> {

	Stage window;
	TableView<Traffic> table;
	ArrayList<Traffic> trafficList;
	
	@SuppressWarnings("unchecked")
	public void start(Stage primaryStage) throws Exception {
		
		trafficList = Part1.trafficList;
		ObservableList<Traffic> trafficSearchList = FXCollections.observableArrayList(trafficList);
		window = primaryStage;
		window.setTitle("Parser UI");
		
		VBox box = new VBox();
		
		TextField searchField;
		
		searchField = new TextField();
		searchField.setFont(Font.font("SanSerif", 15));
		searchField.setPromptText("Search");
		searchField.setMaxWidth(1000);
		
		TableColumn<Traffic, Float> timeStamp = new TableColumn<>("Time");
		timeStamp.setMinWidth(50);
		timeStamp.setCellValueFactory(new PropertyValueFactory<>("timeStamp"));
		
		TableColumn<Traffic, String> src = new TableColumn<>("Source");
		src.setMinWidth(50);
		src.setCellValueFactory(new PropertyValueFactory<>("src"));
		
		TableColumn<Traffic, String> dst = new TableColumn<>("Destination");
		dst.setMinWidth(50);
		dst.setCellValueFactory(new PropertyValueFactory<>("dst"));
		
		TableColumn<Traffic, String> pro = new TableColumn<>("Protocol");
		pro.setMinWidth(50);
		pro.setCellValueFactory(new PropertyValueFactory<>("pro"));
		
		TableColumn<Traffic, String> info = new TableColumn<>("Info");
		info.setMinWidth(50);
		info.setCellValueFactory(new PropertyValueFactory<>("info"));
		
		table = new TableView<>();
		table.setItems(getTraffic());
		table.getColumns().addAll(timeStamp, src, dst, pro, info);
		
		
		box.getChildren().addAll(searchField, table);
		Scene scene = new Scene(box);
		
		FilteredList<Traffic> searchList = new FilteredList<>(trafficSearchList, e -> true);
		searchField.setOnKeyReleased(e -> {
			searchField.textProperty().addListener((observableValue, oldValue, newValue)  -> {
				searchList.setPredicate((Predicate<? super Traffic>) traffic->{
					if(newValue == null || newValue.isEmpty()){
						return true;
					}
					String lowerCaseFilter = newValue.toLowerCase();
					if(traffic.getTimeStamp().contains(newValue)){
						return true;
					}else if(traffic.getPro().toLowerCase().contains(lowerCaseFilter)){
						return true;
					}
					else if(traffic.getSrc().toLowerCase().contains(lowerCaseFilter)){
						return true;
					}
					else if(traffic.getDst().toLowerCase().contains(lowerCaseFilter)){
						return true;
					}
					
					return false;
				});
			});
			SortedList<Traffic> sortedSearchList = new SortedList<>(searchList);
			sortedSearchList.comparatorProperty().bind(table.comparatorProperty());
			table.setItems(sortedSearchList);
			
		});
		
		window.setScene(scene);
		window.show();
	}

	//--- Not for use until parse data is ready ---
	
	public ObservableList<Traffic> getTraffic(){
		ObservableList<Traffic> trafficArrayList = FXCollections.observableArrayList();
		for (Traffic t : trafficList){
			trafficArrayList.add(t);
		}
		return trafficArrayList;
	}
	
	public void handle(ActionEvent event) {
		
	}


}
