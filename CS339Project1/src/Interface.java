import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Interface extends Application implements EventHandler<ActionEvent> {

	Stage window;
	
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Parser UI");
		
		VBox box = new VBox();
		box.getChildren().addAll();
		
		Scene scene = new Scene(box);
		window.setScene(scene);
		window.show();
	}
	
	//--- Not for use until parse data is ready ---
	
//	public ObservableList<Traffic> getTraffic(){
//		ObservableList<Traffic> traffic = FXCollections.observableArrayList();
//		
//	}
	
	public void handle(ActionEvent event) {
		
	}


}
