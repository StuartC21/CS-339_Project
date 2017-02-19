import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Visualizer extends Application {

	Graph graph = new Graph();
	
	public void start(Stage primaryStage) throws Exception{
		ArrayList<Connection> connectionList = Part1.connections.connectionList;
		ArrayList<Router> routerList = Part1.routerList;
		
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 1000, 700);
		
		primaryStage.setTitle("Router Visualizer");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		graph = new Graph();
		
		root.setCenter(graph.getScrollPane());
		
		addGraphComponents(routerList, connectionList);
	
		Layout layout = new RandomLayout(graph);
		layout.execute();
		
	}
	
	public void addGraphComponents(ArrayList<Router> routerList, ArrayList<Connection> connectionList){
		Model model = graph.getModel();
		graph.beginUpdate();
		for(Router router : routerList){
			model.addCell(router.name, CellType.BUTTON );
		}
		for( Connection conn : connectionList){
			model.addEdge(conn.routerA, conn.routerB);
		}
		
		graph.endUpdate();
		
		
	}
}
