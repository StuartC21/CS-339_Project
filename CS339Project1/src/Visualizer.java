import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Visualizer extends Application implements EventHandler<ActionEvent> {

//	Button listButton;
//	Button findPrefixButton;
//	Button rdmVisualButton;
//	Button shellVisualButton;
//	Button springVisualButton;
	Graph graph = new Graph();
	
	public void start(Stage primaryStage) throws Exception{
		
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 900, 500);
		
		primaryStage.setTitle("Router Visualizer");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		graph = new Graph();
		
		root.setCenter(graph.getScrollPane());
		
		addGraphComponents();
	
		Layout layout = new RandomLayout(graph);
		layout.execute();
		
	}
	
	public void addGraphComponents(){
		Model model = graph.getModel();
		graph.beginUpdate();
		model.addCell("Confi1", CellType.RECTANGLE );
		model.addCell("Confi2", CellType.RECTANGLE );
		model.addCell("Confi3", CellType.RECTANGLE );
		model.addCell("Confi4", CellType.RECTANGLE );
		model.addCell("Confi5", CellType.RECTANGLE );
		model.addCell("Confi6", CellType.RECTANGLE );
		model.addCell("Confi7", CellType.RECTANGLE );
		model.addCell("Confi8", CellType.RECTANGLE );
		model.addCell("Confi9", CellType.RECTANGLE );
		model.addCell("Confi10", CellType.RECTANGLE );
		model.addCell("Confi11", CellType.RECTANGLE );
		model.addCell("Confi12", CellType.RECTANGLE );
		model.addCell("Confi13", CellType.RECTANGLE );
		graph.endUpdate();
		
		
	}

	
//	listButton = new Button();
//	findPrefixButton = new Button();
//	rdmVisualButton = new Button();
//	shellVisualButton = new Button();
//	springVisualButton = new Button();
//	
//	listButton.setText("Interfaces");
//	findPrefixButton.setText("Prefixes");
//	rdmVisualButton.setText("Prefixes");
//	shellVisualButton.setText("Prefixes");
//	springVisualButton.setText("Prefixes");
//	
//	listButton.setOnAction(this);
//	findPrefixButton.setOnAction(this);
//	rdmVisualButton.setOnAction(this);
//	shellVisualButton.setOnAction(this);
//	springVisualButton.setOnAction(this);
//
//	layout.getChildren().add(listButton);
//	layout.getChildren().add(findPrefixButton);
//	layout.getChildren().add(rdmVisualButton);
//	layout.getChildren().add(shellVisualButton);
//	layout.getChildren().add(springVisualButton);
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}
