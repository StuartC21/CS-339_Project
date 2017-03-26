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
		
	       BorderPane root = new BorderPane();

	        graph = new Graph();

	        root.setCenter(graph.getScrollPane());

	        Scene scene = new Scene(root, 1000, 700);
	        scene.setFill(Color.WHITE);

	        primaryStage.setScene(scene);
	        primaryStage.show();

	        addGraphComponents(routerList, connectionList);

	        Layout layout = new RandomLayout(graph);
	        layout.execute();
		
	}
	
	public void addGraphComponents(ArrayList<Router> routerList, ArrayList<Connection> connectionList){
		Model model = graph.getModel();
		graph.beginUpdate();
		for(Router router : routerList){
			model.addCell(router.name, CellType.LABEL );
		}
		for( Connection conn : connectionList){
			model.addEdge(conn.routerA, conn.routerB);
		}
		
		graph.endUpdate();
		
		
	}
}
