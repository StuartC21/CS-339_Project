import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class LabelCell4 extends Cell {

    public LabelCell4(String id) {
        super(id);

        Label view = new Label(id);
        view.setText(id);
        view.setStyle("-fx-border-color: crimson; -fx-background-color: yellow;");

        setView(view);

    }

}