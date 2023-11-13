import gui.*;
import java.awt.Color;

public class ConwaySimulator extends AutomateSimulator{
    public ConwaySimulator(GUISimulator gui, Conway conway, int cellSize){
        super(gui, conway, cellSize);
    }

    public void displayCell(int i, int j){
        int cellSize = this.getCellSize();
        if(((Conway) this.getAutomate()).getCellState(i, j) == 1){
            this.getGui().addGraphicalElement(new Rectangle(i * cellSize, j * cellSize, Color.WHITE, Color.WHITE, cellSize));
        } else {
            this.getGui().addGraphicalElement(new Rectangle(i * cellSize, j * cellSize, Color.BLACK, Color.BLACK, cellSize));
        }
    }
}