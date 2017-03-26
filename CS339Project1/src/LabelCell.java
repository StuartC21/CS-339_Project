import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class LabelCell extends Cell {

    public LabelCell(String id) {
        super(id);

        Label view = new Label(id);
        view.setText(id);
        view.setStyle("-fx-border-color:blue; -fx-background-color:cyan;");

        setView(view);

    }

}