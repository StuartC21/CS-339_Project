import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.Group;

public class PieChartInterface extends Application {
	
	ArrayList<Traffic> trafficList;
	
	public void start(Stage stage) {
		trafficList = Part1.trafficList;
        Scene scene = new Scene(new Group());
        stage.setTitle("Protocols");
        stage.setWidth(500);
        stage.setHeight(500);
 
        ObservableList<PieChart.Data> pieChartData = getChartData();
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Protocols");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
        
        
	}

	private ObservableList<PieChart.Data> getChartData() {
		ObservableList<PieChart.Data> pieChartData =FXCollections.observableArrayList();
		ArrayList<String> protocols = getPros();
		for(String p : protocols){
			int i = 0;
			for(Traffic t : trafficList){
				if(p.equals(t.pro)){
					i++;
				}
			}
			pieChartData.add(new PieChart.Data(p, i));
		}
		return pieChartData;
	}

	private ArrayList<String> getPros() {
		ArrayList<String> protocols = new ArrayList<String>();
		for(Traffic t : trafficList){
			if(!protocols.contains(t.pro)){
				protocols.add(t.pro);
			}
		}
		return protocols;
	}
	
}
