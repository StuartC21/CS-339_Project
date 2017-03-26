import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class LabelCell2 extends Cell {

    public LabelCell2(String id) {
        super(id);

        Label view = new Label(id);
        view.setText(id);
        view.setStyle("-fx-border-color: crimson; -fx-background-color: orange;");

        setView(view);

    }

}