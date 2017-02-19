import javafx.scene.control.Button;

public class ButtonCell extends Cell {

    public ButtonCell( String id) {
        super( id);
        Button btn = new Button(id);
        setView(btn);

    }

}