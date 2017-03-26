import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import java.util.List;
import javafx.scene.Group;


public class Edge extends Group {

	
    protected Cell source;
    protected Cell target;

    Line line;

    public Edge(Cell source, Cell target, String prefix) {
    	
        this.source = source;
        this.target = target;

        source.addCellChild(target);
        target.addCellParent(source);
        
        Text text = new Text(prefix);
        text.layoutXProperty().bind(source.layoutXProperty().add(source.getBoundsInParent().getWidth() / 2.0));
        text.layoutYProperty().bind(source.layoutYProperty().add(source.getBoundsInParent().getHeight() / 2.0));
        line = new Line();

        line.startXProperty().bind(source.layoutXProperty().add(source.getBoundsInParent().getWidth() / 2.0));
        line.startYProperty().bind(source.layoutYProperty().add(source.getBoundsInParent().getHeight() / 2.0));

        line.endXProperty().bind(target.layoutXProperty().add(target.getBoundsInParent().getWidth() / 2.0));
        line.endYProperty().bind(target.layoutYProperty().add(target.getBoundsInParent().getHeight() / 2.0));

        getChildren().add(line);
        getChildren().add(text);

    }

    public Cell getSource() {
        return source;
    }

    public Cell getTarget() {
        return target;
    }

}