import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Visualizer extends Application {

	Graph graph = new Graph();
	
	public void start(Stage primaryStage) throws Exception{
		ArrayList<Connection> connectionList = Part1.connections.connectionList;
		ArrayList<Router> routerList = Part1.routerList;
		ArrayList<EndHost> hostList = Part1.hostList;
		
	       BorderPane root = new BorderPane();

	        graph = new Graph();

	        root.setCenter(graph.getScrollPane());

	        Scene scene = new Scene(root, 1000, 700);
	        scene.setFill(Color.WHITE);

	        primaryStage.setScene(scene);
	        primaryStage.show();

	        addGraphComponents(routerList, connectionList, hostList);

	        Layout layout = new RandomLayout(graph);
	        layout.execute();
		
	}
	
	public void addGraphComponents(ArrayList<Router> routerList, ArrayList<Connection> connectionList, ArrayList<EndHost> hostList){
		Model model = graph.getModel();
		graph.beginUpdate();
		for(Router router : routerList){
			model.addCell(router.name, CellType.LABEL );
		}
		for(EndHost host : hostList){
			model.addCell(host.name, CellType.LABEL2);
			model.addEdge(host.router, host.name, null);
		}
		for( Connection conn : connectionList){
			model.addEdge(conn.routerA, conn.routerB, conn.prefix);
		}
		
		graph.endUpdate();
		
		
	}
}
