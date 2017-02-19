import java.util.List;
import java.util.Random;

public class RandomLayout extends Layout {

    Graph graph;

    Random rnd = new Random();
    

    public RandomLayout(Graph graph) {

        this.graph = graph;

    }

    public void execute() {

        List<Cell> cells = graph.getModel().getAllCells();

        for (Cell cell : cells) {
        	double x = rnd.nextDouble() * 700;
        	double y = rnd.nextDouble() * 700;
        	cell.xPost = x;
        	cell.yPost = y;
            
            while (checkLocal(x,y, cells)){
            	x = rnd.nextDouble() * 700;
            	y = rnd.nextDouble() * 700;
            	
            }
            cell.xPost = x;
            cell.yPost = y;
            cell.relocate(x, y);

        }

    }

	private boolean checkLocal(double x, double y, List<Cell> cells) {
		for (Cell cell : cells){
			double xDif = Math.abs(cell.xPost - 25);
			double yDif = Math.abs(cell.yPost - 25);
			if((xDif > 25) && (yDif > 25)){
				return false;
			}
		}
		return true;
	}

}