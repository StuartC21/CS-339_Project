import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Interface extends Application implements EventHandler<ActionEvent> {

	Stage window;
	TableView<Traffic> table;
	ArrayList<Traffic> trafficList;
	@SuppressWarnings("unchecked")
	public void start(Stage primaryStage) throws Exception {
		trafficList = Part1.trafficList;
		window = primaryStage;
		window.setTitle("Parser UI");
		
		VBox box = new VBox();
		
		TableColumn<Traffic, Float> timeStamp = new TableColumn<>("Time");
		timeStamp.setMinWidth(50);
		timeStamp.setCellValueFactory(new PropertyValueFactory<>("Time"));
		
		TableColumn<Traffic, String> src = new TableColumn<>("Source");
		src.setMinWidth(50);
		src.setCellValueFactory(new PropertyValueFactory<>("Source"));
		
		TableColumn<Traffic, String> des = new TableColumn<>("Destination");
		des.setMinWidth(50);
		des.setCellValueFactory(new PropertyValueFactory<>("Destination"));
		
		TableColumn<Traffic, String> protocol = new TableColumn<>("Protocol");
		protocol.setMinWidth(50);
		protocol.setCellValueFactory(new PropertyValueFactory<>("Protocol"));
		
		TableColumn<Traffic, Integer> length = new TableColumn<>("Length");
		protocol.setMinWidth(50);
		protocol.setCellValueFactory(new PropertyValueFactory<>("Length"));
		
		TableColumn<Traffic, String> info = new TableColumn<>("Info");
		info.setMinWidth(50);
		info.setCellValueFactory(new PropertyValueFactory<>("Info"));
		
		table = new TableView<>();
		table.getColumns().addAll(timeStamp, src, des, protocol, length, info);
		table.setItems(getTraffic());
		
		
		box.getChildren().addAll(table);
		Scene scene = new Scene(box);
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
