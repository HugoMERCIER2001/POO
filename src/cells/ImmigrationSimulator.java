import gui.*;
import java.awt.Color;

public class ImmigrationSimulator extends AutomateSimulator{
    private Color[] shadesOfGrey;
    private int nbStates; 

    public ImmigrationSimulator(GUISimulator gui, AutomateCellulaire automate, int cellSize){
        super(gui, automate, cellSize);
    }

    // create a function that returns a tab of nbStates colors, from white to black
    public Color[] getShadesOfGrey(int nbStates){
        if (shadesOfGrey == null) {
            shadesOfGrey = new Color[nbStates];
            for(int i = 0; i < nbStates; i++){
                shadesOfGrey[i] = new Color(255/nbStates*i, 255/nbStates*i, 255/nbStates*i);
            }
        }
        return shadesOfGrey;
    }

    public void displayCell(int i, int j){
        int cellSize = this.getCellSize();
        if (shadesOfGrey == null) {
            nbStates = this.getAutomate().getNbStates();
            shadesOfGrey = getShadesOfGrey(nbStates);
        }
        Color cellColor = shadesOfGrey[this.getAutomate().getCellState(i, j)];
        this.getGui().addGraphicalElement(new Rectangle(i * cellSize, j * cellSize, cellColor, cellColor, cellSize));
    }
}