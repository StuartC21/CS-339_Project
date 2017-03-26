import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class LabelCell3 extends Cell {

    public LabelCell3(String id) {
        super(id);

        Label view = new Label(id);
        view.setText(id);
        view.setStyle("-fx-border-color: crimson; -fx-background-color: pink;");

        setView(view);

    }

}