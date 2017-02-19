import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectCell extends Cell {

    public RectCell( String id) {
        super( id);
        Rectangle view = new Rectangle( 50,50);
        view.setStroke(Color.RED);
        view.setFill(Color.RED);
        setView( view);

    }

}