import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class Cell extends Pane {

    String cellId;

    List<Cell> children = new ArrayList<>();
    List<Cell> parents = new ArrayList<>();
    double xPost = 0, yPost = 0;

    public double getxPost() {
		return xPost;
	}

	public void setxPost(double xPost) {
		this.xPost = xPost;
	}

	public double getyPost() {
		return yPost;
	}

	public void setyPost(double yPost) {
		this.yPost = yPost;
	}

	Node view;

    public Cell(String cellId) {
        this.cellId = cellId;
    }

    public void addCellChild(Cell cell) {
        children.add(cell);
    }

    public List<Cell> getCellChildren() {
        return children;
    }

    public void addCellParent(Cell cell) {
        parents.add(cell);
    }

    public List<Cell> getCellParents() {
        return parents;
    }

    public void removeCellChild(Cell cell) {
        children.remove(cell);
    }

    public void setView(Node view) {

        this.view = view;
        getChildren().add(view);

    }

    public Node getView() {
        return this.view;
    }

    public String getCellId() {
        return cellId;
    }
}